/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import domain.Conductor;
import interfaces.IServiciosConductor;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import services.ServiciosConductor;

/**
 *
 * @author Lenovo
 */
public class FormModificarConductor extends javax.swing.JDialog {

    /**
     * Creates new form FormModificarConductor
     */
    private static int idConductor;
    private static FormConductor formConductor;
    IServiciosConductor iServiciosConductor = new ServiciosConductor();
    public FormModificarConductor(javax.swing.JDialog parent, boolean modal, FormConductor formConductor, int idConductor) {
        super(parent, modal);
        initComponents();
        this.idConductor = idConductor;
        this.formConductor = formConductor;
        llenarJTextFieldNombre();
        llenarJTextFieldApellido();
        llenarJTextFieldDireccion();
        llenarJTextFieldTelefono();
        actualizarComboBoxMatricula();
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
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabelMatricula = new javax.swing.JLabel();
        jComboBoxMatricula = new javax.swing.JComboBox<>();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Informacion");
        setResizable(false);

        jPanel1.setOpaque(false);

        jLabelNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNombre.setText("Nombe:");

        jLabelApellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelApellido.setText("Apellido:");

        jLabelDireccion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDireccion.setText("Dirección:");

        jLabelTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTelefono.setText("Teléfono:");

        jTextFieldNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jTextFieldApellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jTextFieldDireccion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jTextFieldTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoKeyTyped(evt);
            }
        });

        jLabelMatricula.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMatricula.setText("Matrícula:");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelMatricula)
                    .addComponent(jLabelTelefono)
                    .addComponent(jLabelDireccion)
                    .addComponent(jLabelApellido)
                    .addComponent(jLabelNombre))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldApellido)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxMatricula, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                    .addComponent(jTextFieldNombre))
                .addContainerGap(286, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addGap(18, 18, 18)
                .addComponent(jButtonAceptar)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellido)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDireccion)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMatricula)
                    .addComponent(jComboBoxMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
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

    private void jTextFieldTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if((car<'0' || car>'9'))
        evt.consume();

        if(jTextFieldTelefono.getText().length() > 7)
        evt.consume();
    }//GEN-LAST:event_jTextFieldTelefonoKeyTyped

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
        if(emptyFields()){
            String nombre = jTextFieldNombre.getText();
            String apellido = jTextFieldApellido.getText();
            String direccion = jTextFieldDireccion.getText();
            String telefono = jTextFieldTelefono.getText();
            String matricula = jComboBoxMatricula.getSelectedItem().toString();
            
            int idConductor = FormModificarConductor.idConductor;
            Conductor conductor = new Conductor(nombre, apellido, direccion, telefono, matricula);
            
            boolean exito = iServiciosConductor.actualizarConductor(conductor, idConductor);
            if(exito == true){
                JOptionPane.showMessageDialog(this, "Actualizacion exitosa");
            }else{
                JOptionPane.showMessageDialog(this, "Fallo la actualizacion");
            }
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(FormModificarConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormModificarConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormModificarConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormModificarConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormModificarConductor dialog = new FormModificarConductor(new javax.swing.JDialog(), true, formConductor, idConductor);
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
    private javax.swing.JComboBox<String> jComboBoxMatricula;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelMatricula;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables


    private boolean emptyFields() {
        return !jTextFieldNombre.getText().equals("")
            && !jTextFieldApellido.getText().equals("")
            && !jTextFieldDireccion.getText().equals("")
            && !jTextFieldTelefono.getText().equals("");
    }
    
    
    public void llenarJTextFieldNombre(){
        String nombre = iServiciosConductor.obtenerNombrePorIdConductor(idConductor);
        jTextFieldNombre.setText(nombre);
    }
    
    public void llenarJTextFieldApellido(){
        String apellido = iServiciosConductor.obtenerApellidoPorIdConductor(idConductor);
        jTextFieldApellido.setText(apellido);
    }
    
    public void llenarJTextFieldDireccion(){
        String direccion = iServiciosConductor.obtenerDireccionPorIdConductor(idConductor);
        jTextFieldDireccion.setText(direccion);
    }
    
    public void llenarJTextFieldTelefono(){
        String telefono = iServiciosConductor.obtenerTelefonoPorIdConductor(idConductor);
        jTextFieldTelefono.setText(telefono);
    }
    
    public String llenarJComboBoxMatricula(){
        String matricula = iServiciosConductor.obtenerMatriculaPorIdConductor(idConductor);
        System.out.println(matricula);
        return matricula;
    }
    
    private void actualizarComboBoxMatricula() {
        List<String> matriculas = iServiciosConductor.obtenerMatriculasDisponibles(); // Obtener matrículas disponibles
        String noMatricula = "Sin Asignar"; // Texto para 'Sin Asignar'
        String matriculaActual = llenarJComboBoxMatricula(); // Obtener la matrícula actual

        // Agregar las opciones al listado
        matriculas.add(noMatricula); // Agregar 'Sin Asignar' al final de la lista
        matriculas.add(0, matriculaActual); // Agregar la matrícula actual al inicio de la lista

        // Crear el modelo para el JComboBox
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(matriculas.toArray(new String[0]));
        jComboBoxMatricula.setModel(model); // Establecer el modelo en el JComboBox

        // Verificar si la matrícula actual es null o no
        if (matriculaActual == null || matriculaActual.trim().isEmpty()) {
            jComboBoxMatricula.setSelectedItem(noMatricula); // Seleccionar "Sin Asignar" si la matrícula es null o está vacía
        } else {
            jComboBoxMatricula.setSelectedItem(matriculaActual); // Seleccionar la matrícula actual si no es null
        }
    }
}
