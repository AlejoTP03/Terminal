/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistence.ConexionDataBase;
import utils.GenerarPdf;
import utils.MostrarTablaTicket;

/**
 *
 * @author PC
 */
public class FormBuscarTicket extends javax.swing.JDialog {

    /**
     * Creates new form FormModificarTicket
     */
    private Connection conectar = ConexionDataBase.getConnection();
    MostrarTablaTicket mostrarTablaTicket = new MostrarTablaTicket(conectar);
    public FormBuscarTicket(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        createPopupMenu();
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
        jButtonReporte = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMostrarTicketsBuscados = new javax.swing.JTable();
        jLabelDestino = new javax.swing.JLabel();
        jComboBoxDestino = new javax.swing.JComboBox<>();
        jLabelFecha = new javax.swing.JLabel();
        jTextFieldFecha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabelMatricula = new javax.swing.JLabel();
        jTextFieldMatricula = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Ticket");

        jPanel1.setOpaque(false);

        jButtonReporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/32folder_archive_icon_181539.png"))); // NOI18N
        jButtonReporte.setText("Reporte");
        jButtonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteActionPerformed(evt);
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

        jTableMostrarTicketsBuscados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTableMostrarTicketsBuscados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "idTicket", "Nombre", "Apellido", "Ci", "Fecha de Salida", "Matricula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableMostrarTicketsBuscados);

        jLabelDestino.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDestino.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDestino.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDestino.setText("Destino:");

        jComboBoxDestino.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBoxDestino.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pinar del Río", "Artemisa", "La Habana", "Mayabeque", "Matanzas", "Isla de la Juventud", "Cienfuegos", "Villa Clara", "Sancti Spíritus", "Ciego de Ávila", "Camagüey", "Las Tunas", "Granma", "Holguín", "Santiago de Cuba", "Guantánamo" }));

        jLabelFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFecha.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFecha.setText("Fecha");

        jTextFieldFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldFecha.setForeground(new java.awt.Color(0, 0, 0));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/32search_locate_find_icon-icons.com_67287.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelMatricula.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMatricula.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMatricula.setText("Matricula:");

        jTextFieldMatricula.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldMatricula.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addGap(18, 18, 18)
                .addComponent(jButtonReporte)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDestino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelMatricula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDestino)
                    .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFecha)
                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMatricula)
                    .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonReporte)
                    .addComponent(jButton1))
                .addGap(18, 18, 18))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String destino = (String) jComboBoxDestino.getSelectedItem();
        String fechaTexto = jTextFieldFecha.getText();
        String matricula = jTextFieldMatricula.getText();

        // Convertir el texto de la fecha a un objeto Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = dateFormat.parse(fechaTexto);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Use AAAA-MM-DD.");
            return;
        }

        if(matricula.length() == 0){
            DefaultTableModel modelo = mostrarTablaTicket.obtenerTicketsBuscados(destino, fecha);

            jTableMostrarTicketsBuscados.setModel(modelo);
        }else{
            DefaultTableModel modelo = mostrarTablaTicket.obtenerTicketsBuscados(destino, fecha, matricula);

            jTableMostrarTicketsBuscados.setModel(modelo);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporteActionPerformed
        // TODO add your handling code here:
        JTable tabla = jTableMostrarTicketsBuscados;
        GenerarPdf generarPDF = new GenerarPdf();
        generarPDF.generarPDFTicket(tabla);
        JOptionPane.showMessageDialog(this, "Reporte generado con éxito");
    }//GEN-LAST:event_jButtonReporteActionPerformed

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
            java.util.logging.Logger.getLogger(FormBuscarTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBuscarTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBuscarTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBuscarTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormBuscarTicket dialog = new FormBuscarTicket(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonReporte;
    private javax.swing.JComboBox<String> jComboBoxDestino;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelDestino;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelMatricula;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMostrarTicketsBuscados;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldMatricula;
    // End of variables declaration//GEN-END:variables


   private void abrirJDialogModificarTicket() {
        int selectedRow = jTableMostrarTicketsBuscados.getSelectedRow();

        if (selectedRow != -1) {
            try {
                int idTicket = (int) jTableMostrarTicketsBuscados.getValueAt(selectedRow, 0);
                System.out.println(idTicket);

                FormModificarTicket formModificarTicket = new FormModificarTicket(this, true, idTicket);
                formModificarTicket.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un ticket de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
   
   private void createPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem modificarTicket = new JMenuItem("Modificar informacion");

        modificarTicket.addActionListener(e -> abrirJDialogModificarTicket());

        popupMenu.add(modificarTicket);

        jTableMostrarTicketsBuscados.setComponentPopupMenu(popupMenu);
    }
}
