/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VentanaVinculacion.java
 *
 * Created on 13/07/2010, 11:56:59 AM
 */

package registrocontrol;

import clases.Vinculacion;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import registrocontrol.lib.Mensajes;

/**
 *
 * @author gurzaf
 */
public class VentanaNuevaVinculacion extends javax.swing.JDialog {

    private Vinculacion vinculacion;
    private EntityManager entityManager;

    /** Creates new form VentanaVinculacion */
    public VentanaNuevaVinculacion(EntityManager entityManager) {
        this.entityManager=entityManager;
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public VentanaNuevaVinculacion(Vinculacion vinculacion, EntityManager entityManager){
        this.vinculacion = vinculacion;
        this.entityManager=entityManager;
        initComponents();
        campoDesc.setText(vinculacion.getDescripcion());
        campoPrest.setSelected(vinculacion.getPrestaciones());
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        campoDesc = new javax.swing.JTextField();
        campoPrest = new javax.swing.JCheckBox();
        botonAceptar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(registrocontrol.RegistroControlApp.class).getContext().getResourceMap(VentanaNuevaVinculacion.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        campoDesc.setText(resourceMap.getString("campoDesc.text")); // NOI18N
        campoDesc.setName("campoDesc"); // NOI18N
        campoDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        campoPrest.setText(resourceMap.getString("campoPrest.text")); // NOI18N
        campoPrest.setName("campoPrest"); // NOI18N

        botonAceptar.setText(resourceMap.getString("botonAceptar.text")); // NOI18N
        botonAceptar.setName("botonAceptar"); // NOI18N
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(campoPrest))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(botonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPrest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        if(campoDesc.getText().length()<3){
            Mensajes.Error(this, "Ingrese una descripción adecuada");
            campoDesc.requestFocus();
            campoDesc.selectAll();
        }else{
            if(vinculacion == null)
                vinculacion = new Vinculacion();
            vinculacion.setDescripcion(campoDesc.getText());
            vinculacion.setPrestaciones(campoPrest.isSelected());
            try{
                entityManager.getTransaction().begin();
                entityManager.persist(vinculacion);
                entityManager.getTransaction().commit();
                Mensajes.Ok(this, "Vinculación guardada exitosamente");
                this.dispose();
            }catch(PersistenceException pe){
                Mensajes.Error(this, "Error guardando la Vinculación");
            }
        }
    }//GEN-LAST:event_botonAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JTextField campoDesc;
    private javax.swing.JCheckBox campoPrest;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}