
package registro;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.griaule.grfingerjava.FingerprintImage;
import com.griaule.grfingerjava.GrFingerJava;
import com.griaule.grfingerjava.GrFingerJavaException;
import com.griaule.grfingerjava.IFingerEventListener;
import com.griaule.grfingerjava.IImageEventListener;
import com.griaule.grfingerjava.IStatusEventListener;
import com.griaule.grfingerjava.MatchingContext;
import com.griaule.grfingerjava.Template;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.ImageIcon;


public class Finger implements IStatusEventListener, IImageEventListener, IFingerEventListener{

    //Contexto utilizado para la captura, extracción y coincidencia de huellas digitales
    private MatchingContext fingerprintSDK;

    //Interfaz de usuario donde se muestra la imagen de la huella
    private VentanaPrincipal ventanaPrincipal;

    // Indica si la plantilla o template debe ser extraída automáticamente
    private boolean autoExtract = true;

    // Contiene localmente los datos de la huella capturada
    private ByteArrayInputStream fingerprintData;

    //Contiene la longitud del dato de la huella
    private int fingerprintDataLength;

    // La imagen de la última huella digital capturada.
    private FingerprintImage fingerprint;

    // La plantilla de la última imagen de huella capturada
    public Template template;

    private int repeticiones=0;

    private boolean guardando=false;

    private String descripcionHuellaGuardar="";

    private Empleado empleado=null;

    public Finger(VentanaPrincipal ventanaPrincipal) {
    this.ventanaPrincipal = ventanaPrincipal;
    }

    //Inicializa el Fingerprint SDK y habilita la captura de huellas.

    public void inicializarCaptura()
    {
        try
        {
            fingerprintSDK = new MatchingContext();
            //Inicializa la captura de huella digital.
            GrFingerJava.initializeCapture(this);
        } catch (Exception e)
        {
            reinicializarCaptura();
        }
    }

    private void reinicializarCaptura(){
        try {
            GrFingerJava.finalizeCapture();
            GrFingerJava.initializeCapture(this);
        } catch (GrFingerJavaException ex) {
            Mensajes.Error(ventanaPrincipal, "Error irrecuperable del lector, reconectelo al PC");
        }
    }

    public void finalizarCaptura(){
        try {
            GrFingerJava.finalizeCapture();
        } catch (GrFingerJavaException ex) {
            Mensajes.Error(ventanaPrincipal, "Error finalizando captura del lector de huellas");
        }
    }

    public void onSensorPlug(String idSensor) {
        try {
            GrFingerJava.startCapture(idSensor, this, this);
        } catch (GrFingerJavaException e) {
            Mensajes.Error(ventanaPrincipal, "Error con el lector de huellas");
            System.out.println("Error lector de huellas:\n"+e);
        }
    }

    public void onSensorUnplug(String idSensor) {
        try {
            GrFingerJava.stopCapture(idSensor);
        } catch (GrFingerJavaException e) {
            Mensajes.Error(ventanaPrincipal, "Error con el lector de huellas");
            System.out.println("Error lector de huellas:\n"+e);
        }
    }

    //Este método es llamado cada vez que la imagen de una huella ha sido capturada.

    public void onImageAcquired(String idSensor, FingerprintImage huellaDigital) {
        
        //Almacena la imagen de la huella
        this.fingerprint=huellaDigital;

        //Muestra la imagen obtenida
        ventanaPrincipal.mostrarHuellas(huellaDigital);

        //Muestra la plantilla en la imagen actual
        extract();

        identificar();


    }

    private void identificar(){
        EntityManager entityManager = ventanaPrincipal.getEntityManager();
            entityManager.getTransaction().begin();
            Query q = entityManager.createNamedQuery("Huellas.findAll");
            List<Huellas> huellasGuardadas = q.getResultList();
            if(existeHuellaEnBD(template,huellasGuardadas)){
                ventanaPrincipal.labelApellido1.setText(empleado.getApellidos());
                ventanaPrincipal.labelNombre1.setText(empleado.getNombres());
                Image foto=null;
                try {
                    foto = ImageIO.read(new ByteArrayInputStream(empleado.getFoto()));
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                ventanaPrincipal.labelFoto1.setIcon(new ImageIcon(foto));
                ventanaPrincipal.labelMensaje.setText("");
                ventanaPrincipal.jPanel3.setVisible(true);
                registrar(empleado,entityManager);
            }else{
                ventanaPrincipal.labelMensaje.setText("No se identifico el empleado Intente de nuevo");
                ventanaPrincipal.labelApellido1.setText("");
                ventanaPrincipal.labelNombre1.setText("");
                ventanaPrincipal.labelFoto1.setIcon(null);
                ventanaPrincipal.jPanel3.setVisible(false);
            }
            entityManager.getTransaction().commit();
            
    }

    public void onFingerDown(String idSensor) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void onFingerUp(String idSensor) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

       //Establece el directorio donde se ubican las librerías nativas del SDK

   public static void setFingerprintSDKNativeDirectory(String directorio)
   {
    File directory = new File(directorio);

    try {
       GrFingerJava.setNativeLibrariesDirectory(directory);
       GrFingerJava.setLicenseDirectory(directory);
    } catch (GrFingerJavaException e) {
       Mensajes.Error(null, "Error con el lector de huellas");
       System.out.println("Error lector de huellas:\n"+e);
    }

   }

    /**
    * Extrae la plantilla de la imagen de la huella actual.
    */
    public void extract() {

        try {
            //Extrae la plantilla de la imagen.
            template = fingerprintSDK.extract(fingerprint);
            //Muestra la plantilla en la imagen
            ventanaPrincipal.mostrarHuellas(GrFingerJava.getBiometricImage(template,fingerprint));
        } catch (GrFingerJavaException e) {
            Mensajes.Error(null, "Error con el lector de huellas");
            System.out.println("Error lector de huellas:\n"+e);
        }

    }

  

    private boolean existeHuellaEnBD(Template huella, List<Huellas> huellas){
        for(int i=0;i<huellas.size();i++){
            try {
                Template tmp = new Template(huellas.get(i).getHuella());
                if (fingerprintSDK.verify(huella, tmp)) {
                    empleado=huellas.get(i).getEmpleado();
                    return true;
                }
            } catch (Exception ex) {
                System.out.println("Error: "+ex);
            }
        }
        return false;
    }

    private void registrar(Empleado empleado,EntityManager entityManager){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        Query q = entityManager.createNamedQuery("Turnos.findByFechaEmpleado");
        q.setParameter("fecha", cal.getTime());
        q.setParameter("empleado", empleado);
        Turnos turno = (Turnos) q.getSingleResult();
        if(turno==null)
            ventanaPrincipal.labelMensaje.setText("No se encontro turno asignado para este empleado");
        else{
//            Horario h = turno.getHorario();
//            q = entityManager.createNamedQuery("Registro.findByTurno");
//            q.setParameter("turnos", turno);
//            Registro registro = q.getSingleResult();
        }
        entityManager.getTransaction().commit();
    }

}
