/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VentanaNuevoHorario.java
 *
 * Created on 11/07/2010, 08:21:15 PM
 */

package registrocontrol;

import registrocontrol.lib.Mensajes;
import clases.Horario;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.swing.JTextField;

/**
 *
 * @author gurzaf
 */
public class VentanaNuevoHorario extends javax.swing.JDialog {

    private Horario horario;
    //private boolean nuevo=true;
    private EntityManager entityManager = null;
    /** Creates new form VentanaNuevoHorario */
    public VentanaNuevoHorario(EntityManager entityManager) {
        this.entityManager=entityManager;
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public VentanaNuevoHorario(Horario horario,EntityManager entityManager){
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.horario=horario;
        this.entityManager=entityManager;
        ponerDatos();
        this.setVisible(true);
    }

    private void ponerDatos(){
        campoNombreHorario.setText(horario.getNombreHorario());
        campoHoraEntrada.setText(horario.getHoraEntrada().getHours()+"");
        campoMinEntrada.setText(horario.getHoraEntrada().getMinutes()+"");
        campoHoraSalida.setText(horario.getHoraSalida().getHours()+"");
        campoMinSalida.setText(horario.getHoraSalida().getMinutes()+"");
        botonEnviar.setText("Actualizar Horario");
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
        campoNombreHorario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoHoraEntrada = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoMinEntrada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campoHoraSalida = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        campoMinSalida = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        botonEnviar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(registrocontrol.RegistroControlApp.class).getContext().getResourceMap(VentanaNuevoHorario.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setName("Form"); // NOI18N
        setResizable(false);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        campoNombreHorario.setText(resourceMap.getString("campoNombreHorario.text")); // NOI18N
        campoNombreHorario.setName("campoNombreHorario"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        campoHoraEntrada.setColumns(2);
        campoHoraEntrada.setText(resourceMap.getString("campoHoraEntrada.text")); // NOI18N
        campoHoraEntrada.setName("campoHoraEntrada"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        campoMinEntrada.setText(resourceMap.getString("campoMinEntrada.text")); // NOI18N
        campoMinEntrada.setName("campoMinEntrada"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        campoHoraSalida.setColumns(2);
        campoHoraSalida.setName("campoHoraSalida"); // NOI18N

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        campoMinSalida.setName("campoMinSalida"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        botonEnviar.setText(resourceMap.getString("botonEnviar.text")); // NOI18N
        botonEnviar.setName("botonEnviar"); // NOI18N
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(botonEnviar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoMinEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6))
                            .addComponent(campoNombreHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoMinSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)))))
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
                    .addComponent(campoNombreHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(campoHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoMinEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoMinSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEnviar)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        if(campoNombreHorario.getText().length()<3){
            Mensajes.Error(this, "Ingrese un nombre para el horario");
            campoNombreHorario.requestFocus();
            campoNombreHorario.selectAll();
        }else if(isHoraValida(campoHoraEntrada) && isMinValido(campoMinEntrada) 
                && isHoraValida(campoHoraSalida) && isMinValido(campoMinSalida))
        {
            try{
            
            if( horario == null)
                horario = new Horario();
            horario.setNombreHorario(campoNombreHorario.getText());
            int hora = Integer.parseInt(campoHoraEntrada.getText());
            int min = Integer.parseInt(campoMinEntrada.getText());
            horario.setHoraEntrada(new Date(0,0,0,hora,min));
            hora = Integer.parseInt(campoHoraSalida.getText());
            min = Integer.parseInt(campoMinSalida.getText());
            horario.setHoraSalida(new Date(0,0,0,hora,min));
            entityManager.getTransaction().begin();
            entityManager.persist(horario);
            entityManager.getTransaction().commit();
            Mensajes.Ok(this, "El horario se ha guardado satisfactoriamente");
            this.dispose();
            }catch(NumberFormatException ne){
            }catch(PersistenceException pe){
                Mensajes.Error(this, "Error guardando el horario en la bd");
            }finally{ entityManager.close(); }
        }
    }//GEN-LAST:event_botonEnviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEnviar;
    private javax.swing.JTextField campoHoraEntrada;
    private javax.swing.JTextField campoHoraSalida;
    private javax.swing.JTextField campoMinEntrada;
    private javax.swing.JTextField campoMinSalida;
    private javax.swing.JTextField campoNombreHorario;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private boolean isHoraValida(JTextField campo){
        try{
            int numero = Integer.parseInt(campo.getText());
            if(numero>=0 && numero<=23)
                return true;
            else
               Mensajes.Error(this, "El numero ingresado no es una hora válida");
        }catch(NumberFormatException nm){
            Mensajes.Error(this, "El valor ingresado no es una hora válida");
        }finally{
            campo.requestFocus();
            campo.selectAll();
        }
        return false;
    }

    private boolean isMinValido(JTextField campo){
        try{
            int numero = Integer.parseInt(campo.getText());
            if(numero>=0 && numero<=59)
                return true;
            else
               Mensajes.Error(this, "El numero ingresado no es una cantidad de minutos valida");
        }catch(NumberFormatException nm){
            Mensajes.Error(this, "El valor ingresado no es una cantidad de minutos válida");
        }finally{
            campo.requestFocus();
            campo.selectAll();
        }
        return false;
    }

}
