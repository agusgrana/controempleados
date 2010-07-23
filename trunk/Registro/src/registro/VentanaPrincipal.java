/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VentanaPrincipal.java
 *
 * Created on 23/07/2010, 04:48:54 PM
 */

package registro;

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author gurzaf
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    //objeto usado para realizar todas las operaciones relacionadas al Fingerprint-SDK
    private Finger finger;

    //Panel para mostrar la huella digital
    private JPanel fingerprintViewPanel = null;

    //Imagen de la huella actual
    private BufferedImage fingerprintImage = null;

    /** Creates new form PanelHuellas */
    VentanaPrincipal() {
        inicializar();
        initComponents();
        jPanel3.setVisible(false);
        finger.inicializarCaptura();
        this.panelContenedorHuella.add(crearPanelHuella());
        mostrarReloj();
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }

    private void mostrarReloj(){

        Runnable relojito = new Runnable() {

            public void run() {
                while(true){
                    try{
                    Calendar c = Calendar.getInstance();
                    String cadena = c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND)+" ";
                    cadena+=c.getDisplayName(Calendar.AM_PM, Calendar.LONG, Locale.getDefault());
                    labelReloj.setText(cadena);
                    Thread.sleep(1000);
                    }catch(InterruptedException e){}
                }
            }
        };

        Thread hilo = new Thread(relojito);
        hilo.start();

    }

    private void inicializar(){

     //Crea una instancia de Finger
        this.finger = new Finger(this);

    }

    public void mostrarHuellas(BufferedImage huellaDigital) {
        //Utiliza el imageProducer para crear una imagen de la huella digital
        fingerprintImage = huellaDigital;
        //Se dibuja la nueva imagen
        repaint();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(VentanaPrincipal.class);
        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory(resourceMap.getString("entityManager.persistenceUnit")).createEntityManager(); // NOI18N
        panelContenedorHuella = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelReloj = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelFoto1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelNombre1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelApellido1 = new javax.swing.JLabel();
        labelMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
        setName("Form"); // NOI18N
        setResizable(false);
        setUndecorated(true);

        panelContenedorHuella.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("panelContenedorHuella.border.title"))); // NOI18N
        panelContenedorHuella.setName("panelContenedorHuella"); // NOI18N
        panelContenedorHuella.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        labelReloj.setFont(resourceMap.getFont("labelReloj.font")); // NOI18N
        labelReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelReloj.setText(resourceMap.getString("labelReloj.text")); // NOI18N
        labelReloj.setName("labelReloj"); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        labelFoto1.setBackground(resourceMap.getColor("labelFoto1.background")); // NOI18N
        labelFoto1.setText(resourceMap.getString("labelFoto1.text")); // NOI18N
        labelFoto1.setName("labelFoto1"); // NOI18N
        labelFoto1.setPreferredSize(new java.awt.Dimension(175, 175));

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        labelNombre1.setFont(resourceMap.getFont("labelNombre1.font")); // NOI18N
        labelNombre1.setText(resourceMap.getString("labelNombre1.text")); // NOI18N
        labelNombre1.setName("labelNombre1"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        labelApellido1.setFont(resourceMap.getFont("labelApellido1.font")); // NOI18N
        labelApellido1.setText(resourceMap.getString("labelApellido1.text")); // NOI18N
        labelApellido1.setName("labelApellido1"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNombre1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelApellido1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel6))
                            .addComponent(labelFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(labelNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelMensaje.setFont(resourceMap.getFont("labelMensaje.font")); // NOI18N
        labelMensaje.setForeground(resourceMap.getColor("labelMensaje.foreground")); // NOI18N
        labelMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMensaje.setText(resourceMap.getString("labelMensaje.text")); // NOI18N
        labelMensaje.setName("labelMensaje"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelReloj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelContenedorHuella, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(labelMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelContenedorHuella, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        String grFingerNativeDirectory = new File(".").getAbsolutePath();
        Finger.setFingerprintSDKNativeDirectory(grFingerNativeDirectory);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JLabel labelApellido1;
    public javax.swing.JLabel labelFoto1;
    public javax.swing.JLabel labelMensaje;
    public javax.swing.JLabel labelNombre1;
    private javax.swing.JLabel labelReloj;
    private javax.swing.JPanel panelContenedorHuella;
    // End of variables declaration//GEN-END:variables


        // Crea el panel que contendrá la imagen de la huella digital
      private JComponent crearPanelHuella() {
      //Crea un panel nuevo para mostrar la huella
      fingerprintViewPanel = new JPanel(){

       //Se sobreescribe el método paintComponent
       //para habilitar la muestra de la imagen de la huella
            @Override
       public void paintComponent(Graphics g) {
           super.paintComponent(g);

           //Si hay una imagen para ser mostrada
           if (fingerprintImage!=null) {
               //Calcula el tamaño y posición de la imagen para ser pintada
               //el tamaño es ajustado para que ocupe todo el tamaño del panel
               Insets insets = getInsets();
               int transX = insets.left;
               int transY = insets.top;
               int width  = getWidth()  - getInsets().right  - getInsets().left;
               int height = getHeight() - getInsets().bottom - getInsets().top;

               //Se dibuja la imagen
               g.drawImage(fingerprintImage, transX, transY, width, height, null);
           }

       }

       };

       //Se agrega un borde alrededor del panel
       fingerprintViewPanel.setBorder(new CompoundBorder (
           new EmptyBorder (2,2,2,2),
           new BevelBorder(BevelBorder.LOWERED)));

      //si no hay existe el panel de la huella no devuelve nada...
      if(fingerprintViewPanel==null)
      {
        return null;
      }else{ // de lo contrario devuelve el panel mismo

        return fingerprintViewPanel;
     }

     }
}
