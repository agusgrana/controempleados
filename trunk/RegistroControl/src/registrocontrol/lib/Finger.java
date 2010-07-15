
package registrocontrol.lib;

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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import registrocontrol.PanelHuellas;
import registrocontrol.clases.Empleado;
import registrocontrol.clases.Huellas;


public class Finger implements IStatusEventListener, IImageEventListener, IFingerEventListener{

    //Contexto utilizado para la captura, extracción y coincidencia de huellas digitales
    private MatchingContext fingerprintSDK;

    //Interfaz de usuario donde se muestra la imagen de la huella
    private PanelHuellas panelHuellas;

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

    private List<Template> huellasVerificar;

    private int repeticiones=0;

    private boolean guardando=false;

    private String descripcionHuellaGuardar="";

    private Empleado empleado=null;

    public Finger(PanelHuellas panelHuellas) {
    this.panelHuellas = panelHuellas;
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
            Mensajes.Error(panelHuellas, "Error irrecuperable del lector, reconectelo al PC");
        }
    }

    public void finalizarCaptura(){
        try {
            GrFingerJava.finalizeCapture();
        } catch (GrFingerJavaException ex) {
            Mensajes.Error(panelHuellas, "Error finalizando captura del lector de huellas");
        }
    }

    public void onSensorPlug(String idSensor) {
        try {
            GrFingerJava.startCapture(idSensor, this, this);
        } catch (GrFingerJavaException e) {
            Mensajes.Error(panelHuellas, "Error con el lector de huellas");
            System.out.println("Error lector de huellas:\n"+e);
        }
    }

    public void onSensorUnplug(String idSensor) {
        try {
            GrFingerJava.stopCapture(idSensor);
        } catch (GrFingerJavaException e) {
            Mensajes.Error(panelHuellas, "Error con el lector de huellas");
            System.out.println("Error lector de huellas:\n"+e);
        }
    }

    //Este método es llamado cada vez que la imagen de una huella ha sido capturada.

    public void onImageAcquired(String idSensor, FingerprintImage huellaDigital) {
        panelHuellas.botonGuardar.setEnabled(!guardando);

        //Almacena la imagen de la huella
        this.fingerprint=huellaDigital;

        //Muestra la imagen obtenida
        panelHuellas.mostrarHuellas(huellaDigital);

        //Muestra la plantilla en la imagen actual
        extract();

        if(guardando){
            if(repeticiones>0){
            
            huellasVerificar.add(new Template(template.getData()));
            panelHuellas.labelMensaje.setText("Pase su dedo por el lector "+repeticiones+" vez mas ...");
            repeticiones--;
            }else{
            panelHuellas.labelMensaje.setText("Comparando Huellas...");
            guardarHuella();
            }
        }
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
            panelHuellas.mostrarHuellas(GrFingerJava.getBiometricImage(template,fingerprint));
        } catch (GrFingerJavaException e) {
            Mensajes.Error(null, "Error con el lector de huellas");
            System.out.println("Error lector de huellas:\n"+e);
        }

    }

    public void procesoGuardar(Empleado empleado){
        try{
            descripcionHuellaGuardar = Mensajes.In("Descripción de la huella a almacenar");    
            guardando=true;
            this.empleado=empleado;
            repeticiones=1;
            huellasVerificar=new ArrayList<Template>();
            huellasVerificar.add(template);
            panelHuellas.labelMensaje.setText("Pase su dedo por el lector 2 veces mas...");
            panelHuellas.botonGuardar.setEnabled(!guardando);
        }catch(NullPointerException n){}
    }

    private void guardarHuella() {
        huellasVerificar.add(template);
        try {
            EntityManager entityManager = panelHuellas.getEntityManager();
            entityManager.getTransaction().begin();
            Query q = entityManager.createNamedQuery("Huellas.findAll");
            List<Huellas> huellasGuardadas = q.getResultList();
            if(existeHuellaEnBD(huellasVerificar.get(0),huellasGuardadas)){
                Mensajes.Error(panelHuellas, "La huella ya existe en la base de datos");
                entityManager.getTransaction().commit();
            }else if(fingerprintSDK.verify(huellasVerificar.get(0), huellasVerificar.get(1))
                    && fingerprintSDK.verify(huellasVerificar.get(0), huellasVerificar.get(2))) {
                Huellas huella = new Huellas();
                huella.setDescripcion(descripcionHuellaGuardar);
                huella.setEmpleado(empleado);
                huella.setHuella(huellasVerificar.get(0).getData());
                entityManager.persist(huella);
                entityManager.getTransaction().commit();
                panelHuellas.huellasList.add(huella);
                Mensajes.Ok(panelHuellas, "Huella guardada Satisfactoriamente");
            }else{
                Mensajes.Error(panelHuellas, "Las huellas digitales no coinciden");
                entityManager.getTransaction().commit();
            }
            guardando=false;
            repeticiones=0;
            panelHuellas.labelMensaje.setText("Pase su dedo por el lector para guardar la huella");

        } catch (GrFingerJavaException ex) {
            System.out.println("Error: \n"+ex);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: \n"+ex);
        } catch(PersistenceException p){
            Mensajes.Error(panelHuellas, "Error guardando la huella en la base de datos");
            System.out.println("Error: \n"+p);
        }
    }

    private boolean existeHuellaEnBD(Template huella, List<Huellas> huellas){
        for(int i=0;i<huellas.size();i++){
            try {
                Template tmp = new Template(huellas.get(i).getHuella());
                if (fingerprintSDK.verify(huella, tmp)) {
                    return true;
                }
            } catch (Exception ex) {
                System.out.println("Error: "+ex);
            }
        }
        return false;
    }


}
