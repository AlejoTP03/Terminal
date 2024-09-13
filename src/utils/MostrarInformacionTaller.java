/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import persistence.ConexionDataBase;

/**
 *
 * @author PC
 */
public class MostrarInformacionTaller {
    private Connection conexion;

    public MostrarInformacionTaller(Connection conexion) {
        this.conexion = conexion;
    }

    public DefaultTableModel obtenerInformacionTaller() {
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        String sql = "SELECT id_taller AS \"ID Taller\",\n" +
                        "nombre AS \"Nombre\",\n" +
                        "direccion AS \"Direccion\",\n" +
                        "telefono AS \"Telefono\"\n" +
                        "FROM \"Taller\"";

        Connection conexion = ConexionDataBase.getConnection();  // Suponiendo que este método obtiene una nueva conexión
        try (Statement stmt = conexion.createStatement();
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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return modelo;
    }
}
