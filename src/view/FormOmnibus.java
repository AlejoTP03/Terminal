/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import interfaces.IServiciosOmnibus;
import interfaces.IServiciosTaller;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import persistence.ConexionDataBase;
import services.ServiciosOmnibus;
import utils.MostrarTablaOmnibus;
import java.sql.Time;
import java.time.LocalDate;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import services.ServiciosTaller;
import utils.GenerarPdf;

/**
 *
 * @author PC
 */
public class FormOmnibus extends javax.swing.JDialog {

    /**
     * Creates new form FormOmnibus
     */
    private String selectedMatricula = null;
    private MostrarTablaOmnibus mostrarTablaOmnibus;
    private Connection conectar = ConexionDataBase.getConnection();
    IServiciosOmnibus iServiciosOmnibus = new ServiciosOmnibus();
    public FormOmnibus(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarTablaOmnibus = new MostrarTablaOmnibus(conectar);
        llenarTablaOmnibus();
        createPopupMenu();
        jTableMostrarOmnibus.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = jTableMostrarOmnibus.getSelectedRow();
                if (selectedRow != -1) {
                    // Asumiendo que la matrícula del ómnibus está en la primera columna de la tabla
                    selectedMatricula = (String) jTableMostrarOmnibus.getValueAt(selectedRow, 0);
                }
            }
        });
        
        // Agregar el TableModelListener para actualizar la base de datos al modificar una celda
        jTableMostrarOmnibus.getModel().addTableModelListener(e -> {
        if (e.getType() == TableModelEvent.UPDATE) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            System.out.println("Se ha actualizado la fila " + row + " en la columna " + column);

            DefaultTableModel model = (DefaultTableModel) jTableMostrarOmnibus.getModel();
            String nombreColumna = model.getColumnName(column);
            Object dato = model.getValueAt(row, column);

            String matricula = (String) model.getValueAt(row, 0); // Asegúrate de que la primera columna es 'matricula'

            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    iServiciosOmnibus.actualizarOmnibus(matricula, nombreColumna, dato);
                    return null;
                }

                @Override
                protected void done() {
                    // Si es necesario, puedes hacer algo aquí después de que la base de datos haya sido actualizada.
                }
            };

            worker.execute();
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
        jTableMostrarOmnibus = new javax.swing.JTable();
        jButtonAgregarOmnibus = new javax.swing.JButton();
        jButtonEliminarOmnibus = new javax.swing.JButton();
        jButtonReporteOmnibus = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Ómnibus");

        jPanel1.setOpaque(false);

        jTableMostrarOmnibus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTableMostrarOmnibus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Matricula", "Marca", "Modeo", "Destino", "Capacidad", "Hora de Salida", "Pais de Procedencia", "idTaller"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableMostrarOmnibus);

        jButtonAgregarOmnibus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAgregarOmnibus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus_insert_add_new_icon_181537.png"))); // NOI18N
        jButtonAgregarOmnibus.setText("Agregar");
        jButtonAgregarOmnibus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarOmnibusActionPerformed(evt);
            }
        });

        jButtonEliminarOmnibus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonEliminarOmnibus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_remove_close_icon_181533.png"))); // NOI18N
        jButtonEliminarOmnibus.setText("Eliminar");
        jButtonEliminarOmnibus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarOmnibusActionPerformed(evt);
            }
        });

        jButtonReporteOmnibus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonReporteOmnibus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/folder_archive_icon_181539.png"))); // NOI18N
        jButtonReporteOmnibus.setText("Reporte");
        jButtonReporteOmnibus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteOmnibusActionPerformed(evt);
            }
        });

        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/48search_locate_find_icon-icons.com_67287.png"))); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBuscar)
                .addGap(18, 18, 18)
                .addComponent(jButtonReporteOmnibus)
                .addGap(18, 18, 18)
                .addComponent(jButtonEliminarOmnibus)
                .addGap(18, 18, 18)
                .addComponent(jButtonAgregarOmnibus)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregarOmnibus)
                    .addComponent(jButtonEliminarOmnibus)
                    .addComponent(jButtonReporteOmnibus)
                    .addComponent(jButtonBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButtonEliminarOmnibusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarOmnibusActionPerformed
        // TODO add your handling code here:
        IServiciosTaller iServiciosTaller = new ServiciosTaller();
        int selectedRow = jTableMostrarOmnibus.getSelectedRow();
        if (selectedRow != -1) {
            // Obtén la matrícula del ómnibus seleccionado
            String selectedMatricula = (String) jTableMostrarOmnibus.getValueAt(selectedRow, 0); // Suponiendo que la matrícula está en la primera columna
            LocalDate fechaActual = LocalDate.now(); // Suponiendo que usas la fecha actual como referencia

            // Verifica si la matrícula tiene tickets pendientes
            if (iServiciosTaller.tieneTicketsPendientes(selectedMatricula, fechaActual)) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar el ómnibus porque tiene tickets pendientes.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Verifica si la matrícula está asociada a algún conductor
            if (iServiciosOmnibus.matriculaAsociadaAConductor(selectedMatricula)) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar el ómnibus porque está asociado a un conductor.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Confirmación de eliminación
            int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este ómnibus?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                boolean exito = iServiciosOmnibus.eliminarOmnibus(selectedMatricula);

                if (exito) {
                    JOptionPane.showMessageDialog(this, "Ómnibus eliminado exitosamente.");
                    // Opcional: Actualiza la tabla después de la eliminación
                    llenarTablaOmnibus();
                } else {
                    JOptionPane.showMessageDialog(this, "Hubo un problema al eliminar el ómnibus. Inténtalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un ómnibus de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEliminarOmnibusActionPerformed

    private void jButtonAgregarOmnibusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarOmnibusActionPerformed
        // TODO add your handling code here:
        FormAgregarOmnibus formAgregarOmnibus = new FormAgregarOmnibus(this, this, true);
        formAgregarOmnibus.setVisible(true);
    }//GEN-LAST:event_jButtonAgregarOmnibusActionPerformed

    private void jButtonReporteOmnibusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporteOmnibusActionPerformed
        // TODO add your handling code here:
        JTable tabla = jTableMostrarOmnibus;
        GenerarPdf generarPDF = new GenerarPdf();
        generarPDF.generarPDFOmnibus(tabla);
        JOptionPane.showMessageDialog(this, "Reporte generado con éxito");
    }//GEN-LAST:event_jButtonReporteOmnibusActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        FormBuscarOmnibus formBuscarOmnibus = new FormBuscarOmnibus(this, true);
        formBuscarOmnibus.setVisible(true);
    }//GEN-LAST:event_jButtonBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(FormOmnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormOmnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormOmnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormOmnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButtonAgregarOmnibus;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminarOmnibus;
    private javax.swing.JButton jButtonReporteOmnibus;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMostrarOmnibus;
    // End of variables declaration//GEN-END:variables


    public void llenarTablaOmnibus() {
        DefaultTableModel modelo = mostrarTablaOmnibus.obtenerOmnibus();
        jTableMostrarOmnibus.setModel(modelo);
    }
    
    private void createPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem enviarAlTaller = new JMenuItem("Enviar al taller");
        JMenuItem modificarInformacion = new JMenuItem("Modificar Información");

        enviarAlTaller.addActionListener(e -> enviarOmnibusAlTaller());
        modificarInformacion.addActionListener(e -> abrirJDialogModificarOmnibus());

        popupMenu.add(enviarAlTaller);
        popupMenu.add(modificarInformacion);

        jTableMostrarOmnibus.setComponentPopupMenu(popupMenu);
    }
    
    private void enviarOmnibusAlTaller() {
        IServiciosTaller iServiciosTaller = new ServiciosTaller();
        int selectedRow = jTableMostrarOmnibus.getSelectedRow();
        if (selectedRow != -1) {
            String matricula = (String) jTableMostrarOmnibus.getValueAt(selectedRow, 0);

            // Obtener la fecha actual para la verificación
            LocalDate fechaActual = LocalDate.now();

            // Comprobar si hay tickets pendientes para esa matrícula en fechas posteriores
            boolean tieneTicketsPendientes = iServiciosTaller.tieneTicketsPendientes(matricula, fechaActual);

            if (tieneTicketsPendientes) {
                JOptionPane.showMessageDialog(this, "No se puede enviar al taller. El ómnibus tiene tickets pendientes en fechas futuras.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                boolean exito = iServiciosTaller.enviarAlTaller(matricula);

                if (exito) {
                    JOptionPane.showMessageDialog(this, "Ómnibus enviado al taller exitosamente.");
                    llenarTablaOmnibus();
                } else {
                    JOptionPane.showMessageDialog(this, "Hubo un problema al enviar el ómnibus al taller. Inténtalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un ómnibus de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void abrirJDialogModificarOmnibus() {
        int selectedRow = jTableMostrarOmnibus.getSelectedRow();

        if (selectedRow != -1) {
            try {
                String matricula = (String) jTableMostrarOmnibus.getValueAt(selectedRow, 0);
                System.out.println(matricula);

                FormModificarOmnibus formModificarOmnibus = new FormModificarOmnibus(this, true, matricula);
                formModificarOmnibus.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un ticket de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    } 
}