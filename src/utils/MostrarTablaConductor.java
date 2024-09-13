/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import persistence.ConexionDataBase;
/**
 *
 * @author PC
 */
public class MostrarTablaConductor {
    public final Connection conexion;

    public MostrarTablaConductor(Connection conexion) {
        this.conexion = conexion;
    }
    
    public DefaultTableModel obtenerConductores(){
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        String sql = "SELECT id_conductor AS \"ID Conductor\", \n" +
                     "nombre AS \"Nombre\",\n" +
                     "apellido AS \"Apellido\",\n" +
                     "direccion AS \"Dirección\",\n" +
                     "telefono AS \"Teléfono\",\n" +
                     "matricula AS \"Matrícula\"\n" +
                     "FROM \"Conductor\" ORDER BY id_conductor ASC";

        Connection conexion2 = ConexionDataBase.getConnection();
        try (Statement stmt = conexion2.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Obtén el número de columnas y sus nombres
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                modelo.addColumn(rs.getMetaData().getColumnName(i));
            }

            // Agrega cada fila de la base de datos al modelo de la tabla
            while (rs.next()) {
                Object[] fila = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelo;
    }
}
