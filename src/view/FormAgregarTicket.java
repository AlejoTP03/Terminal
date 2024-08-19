/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import domain.Omnibus;
import domain.Ticket;
import interfaces.IServiciosTicket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import persistence.ConexionDataBase;
import services.ServiciosOmnibus;
import services.ServiciosTicket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author PC
 */
public class FormAgregarTicket extends javax.swing.JDialog {

    /**
     * Creates new form FormAgregarTicket
     */
    public FormAgregarTicket(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jComboBoxDestino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String destinoSeleccionado = jComboBoxDestino.getSelectedItem().toString();
            llenarComboBoxMatricula(jComboBoxMatricula, destinoSeleccionado);
            }
            
        });
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
        jLabelNombreDelPasajero = new javax.swing.JLabel();
        jLabelApellidosPasajero = new javax.swing.JLabel();
        jLabelCiPasajero = new javax.swing.JLabel();
        jLabelFechaDeSalida = new javax.swing.JLabel();
        jLabelMatricula = new javax.swing.JLabel();
        jTextFieldNombrePasajero = new javax.swing.JTextField();
        jTextFieldApellidoPasajero = new javax.swing.JTextField();
        jTextFieldCiPasajero = new javax.swing.JTextField();
        jTextFieldFechasalida = new javax.swing.JTextField();
        jComboBoxMatricula = new javax.swing.JComboBox<>();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelDestino = new javax.swing.JLabel();
        jComboBoxDestino = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Ticket");
        setResizable(false);

        jPanel1.setOpaque(false);

        jLabelNombreDelPasajero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNombreDelPasajero.setText("Nombre del Pasajero:");

        jLabelApellidosPasajero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelApellidosPasajero.setText("Apellidos del Pasajero:");

        jLabelCiPasajero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCiPasajero.setText("CI:");

        jLabelFechaDeSalida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFechaDeSalida.setText("Fecha de Salida:");

        jLabelMatricula.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMatricula.setText("Matrícula:");

        jTextFieldNombrePasajero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldNombrePasajero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombrePasajeroKeyTyped(evt);
            }
        });

        jTextFieldApellidoPasajero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldApellidoPasajero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoPasajeroKeyTyped(evt);
            }
        });

        jTextFieldCiPasajero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldCiPasajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCiPasajeroActionPerformed(evt);
            }
        });
        jTextFieldCiPasajero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCiPasajeroKeyTyped(evt);
            }
        });

        jTextFieldFechasalida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldFechasalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFechasalidaKeyTyped(evt);
            }
        });

        jComboBoxMatricula.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

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

        jLabelDestino.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDestino.setText("Destino:");

        jComboBoxDestino.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBoxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pinar del Río", "Artemisa", "La Habana", "Mayabeque", "Matanzas", "Isla de la Juventud", "Cienfuegos", "Villa Clara", "Sancti Spíritus", "Ciego de Ávila", "Camagüey", "Las Tunas", "Granma", "Holguín", "Santiago de Cuba", "Guantánamo" }));
        jComboBoxDestino.setSelectedIndex(-1);
        jComboBoxDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDestinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(351, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addGap(18, 18, 18)
                .addComponent(jButtonAceptar)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDestino)
                    .addComponent(jLabelCiPasajero)
                    .addComponent(jLabelFechaDeSalida)
                    .addComponent(jLabelMatricula)
                    .addComponent(jLabelApellidosPasajero)
                    .addComponent(jLabelNombreDelPasajero))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldApellidoPasajero)
                    .addComponent(jTextFieldCiPasajero)
                    .addComponent(jTextFieldFechasalida)
                    .addComponent(jComboBoxMatricula, 0, 200, Short.MAX_VALUE)
                    .addComponent(jTextFieldNombrePasajero)
                    .addComponent(jComboBoxDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreDelPasajero)
                    .addComponent(jTextFieldNombrePasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellidosPasajero)
                    .addComponent(jTextFieldApellidoPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCiPasajero)
                    .addComponent(jTextFieldCiPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaDeSalida)
                    .addComponent(jTextFieldFechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDestino)
                    .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMatricula)
                    .addComponent(jComboBoxMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addGap(30, 30, 30))
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

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
        String nombrePasajero = jTextFieldNombrePasajero.getText();
        String apellidoPasajero = jTextFieldApellidoPasajero.getText();
        String ciPasajero = jTextFieldCiPasajero.getText();

        // Declara una variable para almacenar la fecha de salida.
        Date fechaSalida = null;
        try {
            // Define el formato de fecha esperado (AAAA-MM-DD).
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            // Intenta analizar el texto ingresado en el campo de fecha y convertirlo a un objeto Date.
            fechaSalida = dateFormat.parse(jTextFieldFechasalida.getText());
        } catch (ParseException e) {
            // Si ocurre una excepción al analizar la fecha, muestra un mensaje de error al usuario.
            JOptionPane.showMessageDialog(this, "Fecha de salida inválida, la fecha debe cumplir el formato AAAA-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
            // Sale del método sin continuar con la inserción del ticket.
            return;
        }

        // Verifica que se haya seleccionado un destino y una matrícula antes de continuar
        if (jComboBoxDestino.getSelectedItem() == null || jComboBoxMatricula.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un destino y una matrícula", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String destino = jComboBoxDestino.getSelectedItem().toString();
        String matricula = jComboBoxMatricula.getSelectedItem().toString();

        if(emptyFields()){
            Ticket ticket = new Ticket(nombrePasajero, apellidoPasajero, ciPasajero, fechaSalida, destino, matricula);

            // Crea una instancia de IServiciosTicket para interactuar con la capa de servicios.
            IServiciosTicket iServiciosTicket = new ServiciosTicket();
            // Llama al método agregarTicket para insertar el ticket en la base de datos y almacena el resultado.
            boolean resultado = iServiciosTicket.agregarTicket(ticket);

            // Muestra un mensaje de confirmación si el ticket fue agregado exitosamente.
            // De lo contrario, muestra un mensaje de error.
            if (resultado) {
                JOptionPane.showMessageDialog(this, "Ticket agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                clear();
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar el ticket", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos");
        }
        
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jTextFieldCiPasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCiPasajeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCiPasajeroActionPerformed

    private void jComboBoxDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDestinoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBoxDestinoActionPerformed

    private void jTextFieldFechasalidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFechasalidaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFechasalidaKeyTyped

    private void jTextFieldCiPasajeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCiPasajeroKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) 
            evt.consume();
        
        if(jTextFieldCiPasajero.getText().length() > 10)
            evt.consume();
    }//GEN-LAST:event_jTextFieldCiPasajeroKeyTyped

    private void jTextFieldNombrePasajeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombrePasajeroKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();

        // Permitir solo letras y espacios
        if (!Character.isLetter(car) && car != ' ') {
            evt.consume();
        }

        // Evitar espacios al final
        if (car == ' ' && jTextFieldCiPasajero.getText().endsWith(" ")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldNombrePasajeroKeyTyped

    private void jTextFieldApellidoPasajeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPasajeroKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();

        // Permitir solo letras y espacios
        if (!Character.isLetter(car) && car != ' ') {
            evt.consume();
        }

        // Evitar espacios al final
        if (car == ' ' && jTextFieldCiPasajero.getText().endsWith(" ")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldApellidoPasajeroKeyTyped

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
            java.util.logging.Logger.getLogger(FormAgregarTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgregarTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgregarTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgregarTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormAgregarTicket dialog = new FormAgregarTicket(new javax.swing.JDialog(), true);
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
    private javax.swing.JComboBox<String> jComboBoxMatricula;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelApellidosPasajero;
    private javax.swing.JLabel jLabelCiPasajero;
    private javax.swing.JLabel jLabelDestino;
    private javax.swing.JLabel jLabelFechaDeSalida;
    private javax.swing.JLabel jLabelMatricula;
    private javax.swing.JLabel jLabelNombreDelPasajero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldApellidoPasajero;
    private javax.swing.JTextField jTextFieldCiPasajero;
    private javax.swing.JTextField jTextFieldFechasalida;
    private javax.swing.JTextField jTextFieldNombrePasajero;
    // End of variables declaration//GEN-END:variables

    
    public boolean emptyFields() {
    // Verifica que los JTextField no estén vacíos
    
    return !jTextFieldNombrePasajero.getText().equals("")
        && !jTextFieldApellidoPasajero.getText().equals("")
        && !jTextFieldCiPasajero.getText().equals("")
        && !jTextFieldFechasalida.getText().equals("")
        // Verifica que se haya seleccionado un valor en los JComboBox
        && jComboBoxDestino.getSelectedItem() != null
        && jComboBoxMatricula.getSelectedItem() != null;
}
     
    public void clear(){
        jTextFieldNombrePasajero.setText("");
        jTextFieldApellidoPasajero.setText("");
        jTextFieldCiPasajero.setText("");
        jTextFieldFechasalida.setText("");
        jComboBoxMatricula.setSelectedIndex(-1);
     
    }
    
    public void llenarComboBoxMatricula(JComboBox<String> comboBox, String destino) {
    IServiciosTicket iServiciosTicket = new ServiciosTicket();
    comboBox.removeAllItems();
    List<Omnibus> listaOmnibus = iServiciosTicket.obtenerOmnibusPorDestino(destino);
    for (Omnibus omnibus : listaOmnibus) {
        comboBox.addItem(omnibus.getMatricula());
    }
    }
}
