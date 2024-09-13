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
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class MostrarTablaOmnibus {
    private Connection conexion;

    public MostrarTablaOmnibus(Connection conexion) {
        this.conexion = conexion;
    }

    public DefaultTableModel obtenerOmnibus() {
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };;
        String sql = "SELECT matricula AS \"Matrícula\", \n" +
                     "marca AS \"Marca\",\n" +
                     "modelo AS \"Modelo\",\n" +
                     "destino AS \"Destino\",\n" +
                     "capacidad AS \"Capacidad\",\n" +
                     "hora_salida AS \"Hora de Salida\",\n" +
                     "pais_procedencia AS \"País de Procedencia\",\n" +
                     "id_taller AS \"ID Taller\"\n" +
                     "FROM \"Omnibus\" WHERE disponible = TRUE ORDER BY matricula ASC";

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
    
    public DefaultTableModel obtenerOmnibusBuscador() {
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };;
        String sql = "SELECT matricula AS \"Matrícula\", \n" +
                     "marca AS \"Marca\",\n" +
                     "modelo AS \"Modelo\",\n" +
                     "destino AS \"Destino\",\n" +
                     "capacidad AS \"Capacidad\",\n" +
                     "hora_salida AS \"Hora de Salida\",\n" +
                     "pais_procedencia AS \"País de Procedencia\",\n" +
                     "id_taller AS \"ID Taller\"\n" +
                     "FROM \"Omnibus\" ORDER BY matricula ASC";

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
    
    
    public DefaultTableModel obtenerOmnibusBuscados(String destino) {
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        String sql = "SELECT matricula AS \"Matrícula\",\n" +
                     "marca AS \"Marca\",\n" +
                     "modelo AS \"Modelo\",\n" +
                     "capacidad AS \"Capacidad\",\n" +
                     "destino AS \"Destino\",\n" +
                     "hora_salida AS \"Hora de Salida\",\n" +
                     "pais_procedencia AS \"País de Procedencia\",\n" +
                     "id_taller AS \"Número de Taller\"\n" +
                     "FROM \"Omnibus\"\n" +
                     "WHERE destino = ?\n" +
                     "ORDER BY matricula ASC";

        Connection conexion = ConexionDataBase.getConnection();
        try (PreparedStatement pst = conexion.prepareStatement(sql)) {
            // Establece el parámetro de la consulta
            pst.setString(1, destino);

            try (ResultSet rs = pst.executeQuery()) {
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
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelo;
    }
}    
