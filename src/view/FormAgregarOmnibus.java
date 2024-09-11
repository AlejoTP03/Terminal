/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import domain.Omnibus;
import domain.Taller;
import interfaces.IServiciosOmnibus;
import java.awt.Color;
import javax.swing.JOptionPane;
import services.ServiciosOmnibus;
import utils.TraerIdTaller;
import utils.VerificarEntradaDeHora;

/**
 *
 * @author PC
 */
public class FormAgregarOmnibus extends javax.swing.JDialog {

    /**
     * Creates new form FormAgregarOmnibus
     */
    private FormOmnibus formOmnibus;
    VerificarEntradaDeHora entradaHora = new VerificarEntradaDeHora();
    TraerIdTaller traerIdTaller = new TraerIdTaller();
    public FormAgregarOmnibus(FormOmnibus formOmnibus, javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.formOmnibus = formOmnibus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabelMatricula = new javax.swing.JLabel();
        jLabelMarca = new javax.swing.JLabel();
        jLabelModelo = new javax.swing.JLabel();
        jLabelDestino = new javax.swing.JLabel();
        jLabelCapacidad = new javax.swing.JLabel();
        jLabelHoraSalida = new javax.swing.JLabel();
        jLabelPaisProcedencia = new javax.swing.JLabel();
        jTextFieldMatricula = new javax.swing.JTextField();
        jTextFieldMarca = new javax.swing.JTextField();
        jTextFieldModelo = new javax.swing.JTextField();
        jTextFieldCapacidad = new javax.swing.JTextField();
        jComboBoxDestino = new javax.swing.JComboBox<>();
        jTextFieldHoraSalida = new javax.swing.JTextField();
        jTextFieldPaisProcedencia = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Ómnibus");

        jPanel1.setOpaque(false);

        jLabelMatricula.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMatricula.setText("Matricula:");

        jLabelMarca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMarca.setText("Marca:");

        jLabelModelo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelModelo.setText("Modelo:");

        jLabelDestino.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDestino.setText("Destino:");

        jLabelCapacidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCapacidad.setText("Capacidad:");

        jLabelHoraSalida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelHoraSalida.setText("Hora de Salida:");

        jLabelPaisProcedencia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPaisProcedencia.setText("País de Procedencia:");

        jTextFieldMatricula.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMatriculaActionPerformed(evt);
            }
        });
        jTextFieldMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMatriculaKeyTyped(evt);
            }
        });

        jTextFieldMarca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMarcaKeyTyped(evt);
            }
        });

        jTextFieldModelo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jTextFieldCapacidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldCapacidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCapacidadKeyTyped(evt);
            }
        });

        jComboBoxDestino.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBoxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pinar del Río", "Artemisa", "La Habana", "Mayabeque", "Matanzas", "Isla de la Juventud", "Cienfuegos", "Villa Clara", "Sancti Spíritus", "Ciego de Ávila", "Camagüey", "Las Tunas", "Granma", "Holguín", "Santiago de Cuba", "Guantánamo" }));
        jComboBoxDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDestinoActionPerformed(evt);
            }
        });

        jTextFieldHoraSalida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldHoraSalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldHoraSalidaKeyTyped(evt);
            }
        });

        jTextFieldPaisProcedencia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jButtonAceptar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anydo_104098.png"))); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forceexit_103817.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelMatricula)
                    .addComponent(jLabelMarca)
                    .addComponent(jLabelModelo)
                    .addComponent(jLabelDestino)
                    .addComponent(jLabelCapacidad)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelPaisProcedencia)
                        .addComponent(jLabelHoraSalida, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldMarca)
                    .addComponent(jTextFieldModelo)
                    .addComponent(jTextFieldCapacidad)
                    .addComponent(jComboBoxDestino, 0, 200, Short.MAX_VALUE)
                    .addComponent(jTextFieldHoraSalida)
                    .addComponent(jTextFieldPaisProcedencia)
                    .addComponent(jTextFieldMatricula))
                .addContainerGap(238, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addGap(18, 18, 18)
                .addComponent(jButtonAceptar)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMatricula)
                    .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMarca)
                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelModelo)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDestino)
                    .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCapacidad)
                    .addComponent(jTextFieldCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHoraSalida)
                    .addComponent(jTextFieldHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPaisProcedencia)
                    .addComponent(jTextFieldPaisProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addGap(27, 27, 27))
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDestinoActionPerformed

    private void jTextFieldMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMatriculaKeyTyped
        // TODO add your handling code here:
        if (jTextFieldMatricula.getText().length() >= 7) {
        evt.consume(); // No permite más de 7 caracteres
        }
    
        // Cambiar color a rojo si no tiene exactamente 7 caracteres
        if (jTextFieldMatricula.getText().length() < 6) {
            jTextFieldMatricula.setBackground(Color.pink);
        } else {
            jTextFieldMatricula.setBackground(Color.WHITE); // O el color por defecto
        }
    }//GEN-LAST:event_jTextFieldMatriculaKeyTyped

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldHoraSalidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHoraSalidaKeyTyped
        // TODO add your handling code here:
        jTextFieldHoraSalida.setInputVerifier(entradaHora);
        
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && car != ':') 
            evt.consume();
    }//GEN-LAST:event_jTextFieldHoraSalidaKeyTyped

    private void jTextFieldCapacidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCapacidadKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) 
            evt.consume();
    }//GEN-LAST:event_jTextFieldCapacidadKeyTyped

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        if (emptyFields()) {
            String matricula = jTextFieldMatricula.getText();
            String marca = jTextFieldMarca.getText();
            String modelo = jTextFieldModelo.getText();
            int capacidad = Integer.parseInt(jTextFieldCapacidad.getText());
            String destino = jComboBoxDestino.getSelectedItem().toString();
            java.sql.Time horaSalida = java.sql.Time.valueOf(jTextFieldHoraSalida.getText());
            String paisProcedencia = jTextFieldPaisProcedencia.getText();

            int idTaller = traerIdTaller.obtenerIdTaller();
            boolean disponible = false;

                if (jTextFieldMatricula.getText().length() == 7) {
                    Omnibus omnibus = new Omnibus(matricula, marca, modelo, destino, capacidad, horaSalida, paisProcedencia, idTaller, disponible);

                    IServiciosOmnibus iServiciosOmnibus = new ServiciosOmnibus();

                    if (iServiciosOmnibus.agregarOmnibus(omnibus)) {
                        JOptionPane.showMessageDialog(this, "Ómnibus insertado con éxito.");
                        clear();
                        formOmnibus.llenarTablaOmnibus();
                        } else {
                            JOptionPane.showMessageDialog(this, "La matrícula ya está en uso.");
                        }
                } else {
                    JOptionPane.showMessageDialog(this, "Faltan caracteres en la matrícula.");
                }
        } else {
            // Muestra un mensaje si alguno de los campos está vacío
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jTextFieldMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMatriculaActionPerformed

    private void jTextFieldMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMarcaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMarcaKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormAgregarOmnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgregarOmnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgregarOmnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgregarOmnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormOmnibus dialog = new FormOmnibus(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox<String> jComboBoxDestino;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelCapacidad;
    private javax.swing.JLabel jLabelDestino;
    private javax.swing.JLabel jLabelHoraSalida;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelMatricula;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelPaisProcedencia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCapacidad;
    private javax.swing.JTextField jTextFieldHoraSalida;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldMatricula;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldPaisProcedencia;
    // End of variables declaration//GEN-END:variables


    public boolean emptyFields(){
         
        if(!jTextFieldMatricula.getText().equals("")
            &&!jTextFieldMarca.getText().equals("")
            &&!jTextFieldModelo.getText().equals("")
            &&!jTextFieldCapacidad.getText().equals("")
            &&!jTextFieldHoraSalida.getText().equals("")
            &&!jTextFieldPaisProcedencia.getText().equals(""))
            return true;
        else 
            return false;
    }
     
    public void clear(){
        jTextFieldMatricula.setText("");
        jTextFieldMarca.setText("");
        jTextFieldModelo.setText("");
        jComboBoxDestino.setSelectedIndex(0);
        jTextFieldCapacidad.setText("");
        jTextFieldHoraSalida.setText("");
        jTextFieldPaisProcedencia.setText("");
     
    }
    
    
}
