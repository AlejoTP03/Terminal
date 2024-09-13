/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import interfaces.IServiciosConductor;
import java.sql.Connection;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import persistence.ConexionDataBase;
import services.ServiciosConductor;
import utils.GenerarPdf;
import utils.MostrarTablaConductor;

/**
 *
 * @author PC
 */
public class FormConductor extends javax.swing.JDialog {

    /**
     * Creates new form FormConductor
     */
    MostrarTablaConductor mostrarTablaConductor;
    private Connection conectar = ConexionDataBase.getConnection();
    IServiciosConductor iServiciosConductor = new ServiciosConductor();
    public FormConductor(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarTablaConductor = new MostrarTablaConductor(conectar);
        llenarTablaConductor();
        createPopupMenu();
        
        jButtonEliminarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarConductorActionPerformed(evt);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMostrarConductor = new javax.swing.JTable();
        jButtonAgregarConductor = new javax.swing.JButton();
        jButtonEliminarConductor = new javax.swing.JButton();
        jButtonReporteConductor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Conductores");
        setResizable(false);

        jPanel1.setOpaque(false);

        jTableMostrarConductor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTableMostrarConductor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idConductor", "Nombre", "Apellido", "Dirección", "Teléfono", "Matricula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(jTableMostrarConductor);

        jButtonAgregarConductor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAgregarConductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus_insert_add_new_icon_181537.png"))); // NOI18N
        jButtonAgregarConductor.setText("Agregar");
        jButtonAgregarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarConductorActionPerformed(evt);
            }
        });

        jButtonEliminarConductor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonEliminarConductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_remove_close_icon_181533.png"))); // NOI18N
        jButtonEliminarConductor.setText("Eliminar");
        jButtonEliminarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarConductorActionPerformed(evt);
            }
        });

        jButtonReporteConductor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonReporteConductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/folder_archive_icon_181539.png"))); // NOI18N
        jButtonReporteConductor.setText("Reporte");
        jButtonReporteConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteConductorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonReporteConductor)
                .addGap(18, 18, 18)
                .addComponent(jButtonEliminarConductor)
                .addGap(18, 18, 18)
                .addComponent(jButtonAgregarConductor)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregarConductor)
                    .addComponent(jButtonEliminarConductor)
                    .addComponent(jButtonReporteConductor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButtonAgregarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarConductorActionPerformed
        // TODO add your handling code here:
        FormAgregarConductor formAgregarConductor = new FormAgregarConductor(this, this, true);
        formAgregarConductor.setVisible(true);
    }//GEN-LAST:event_jButtonAgregarConductorActionPerformed

    private void jButtonEliminarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarConductorActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTableMostrarConductor.getModel();
    
        // Obtener la fila seleccionada
        int selectedRow = jTableMostrarConductor.getSelectedRow();
        System.out.println("Fila seleccionada: " + selectedRow); // Línea de depuración

        // Verificar si se seleccionó una fila
        if (selectedRow == -1) {
//            JOptionPane.showMessageDialog(this, "Por favor, seleccione algún conductor.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si no hay fila seleccionada
        }

        // Obtener el ID del conductor de la fila seleccionada
        Object idConductor = modelo.getValueAt(selectedRow, 0); // Ajusta el índice de la columna si es necesario

        // Intentar eliminar el conductor
        boolean exito = iServiciosConductor.eliminarConductor(idConductor);

        // Mostrar el resultado de la operación
        if (exito) {
            modelo.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Conductor eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el conductor.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEliminarConductorActionPerformed

    private void jButtonReporteConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporteConductorActionPerformed
        // TODO add your handling code here:
        JTable tabla = jTableMostrarConductor;
        GenerarPdf generarPDF = new GenerarPdf();
        generarPDF.generarPDFConductor(tabla);
        JOptionPane.showMessageDialog(this, "Reporte generado con éxito");
    }//GEN-LAST:event_jButtonReporteConductorActionPerformed

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
            java.util.logging.Logger.getLogger(FormConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormConductor dialog = new FormConductor(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButtonAgregarConductor;
    private javax.swing.JButton jButtonEliminarConductor;
    private javax.swing.JButton jButtonReporteConductor;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMostrarConductor;
    // End of variables declaration//GEN-END:variables


    public void llenarTablaConductor() {
        DefaultTableModel modelo = mostrarTablaConductor.obtenerConductores();
        jTableMostrarConductor.setModel(modelo);
    }
    
    private void createPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem modificarTicket = new JMenuItem("Modificar información");

        modificarTicket.addActionListener(e -> abrirJDialogModificarTicket());

        popupMenu.add(modificarTicket);

        jTableMostrarConductor.setComponentPopupMenu(popupMenu);
    }
    
    private void abrirJDialogModificarTicket() {
        int selectedRow = jTableMostrarConductor.getSelectedRow();

        if (selectedRow != -1) {
            try {
                int idConductor = (int)jTableMostrarConductor.getValueAt(selectedRow, 0);
                System.out.println(idConductor);

                FormModificarConductor formModificarConductor = new FormModificarConductor(this, true, this, idConductor);
                formModificarConductor.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un omnibus de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
