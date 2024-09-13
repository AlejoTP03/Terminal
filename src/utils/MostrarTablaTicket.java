/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import persistence.ConexionDataBase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author PC
 */
public class MostrarTablaTicket {
    private Connection conexion;

    public MostrarTablaTicket(Connection conexion) {
        this.conexion = conexion;
    }
    
    public DefaultTableModel obtenerTickets() {
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        String sql = "SELECT id_ticket AS \"ID Ticket\", \n" +
                     "nombre_pasajero AS \"Nombre del Pasajero\",\n" +
                     "apellidos_pasajero AS \"Apellidos del Pasajero\",\n" +
                     "ci_pasajero AS \"Carnet de Identidad\",\n" +
                     "fecha_salida AS \"Fecha de Salida\",\n" +
                     "destino AS \"Destino\",\n" +
                     "matricula AS \"Matricula\"\n" +
                     "FROM \"Ticket\" ORDER BY id_ticket ASC";

        // Abre una nueva conexión
        Connection conexion = ConexionDataBase.getConnection(); // Suponiendo que este método obtiene una nueva conexión
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
              

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
    
    
    public DefaultTableModel obtenerTicketsBuscados(String destino, Date fecha) {
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "SELECT id_ticket AS \"ID Ticket\", \n" +
                     "nombre_pasajero AS \"Nombre del Pasajero\",\n" +
                     "apellidos_pasajero AS \"Apellidos del Pasajero\",\n" +
                     "ci_pasajero AS \"Carnet de Identidad\",\n" +
                     "fecha_salida AS \"Fecha de Salida\",\n" +
                     "destino AS \"Destino\",\n" +
                     "matricula AS \"Matricula\"\n" +
                     "FROM \"Ticket\"\n" +
                     "WHERE destino = ? AND fecha_salida = ?\n" +
                     "ORDER BY id_ticket ASC";

        Connection conexion2 = ConexionDataBase.getConnection(); // Suponiendo que este método obtiene una nueva conexión
        try (PreparedStatement pst = conexion2.prepareStatement(sql)) {
            // Establece los parámetros de la consulta
            pst.setString(1, destino);
            pst.setDate(2, new java.sql.Date(fecha.getTime())); // Convertir java.util.Date a java.sql.Date

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
    
    
    public DefaultTableModel obtenerTicketsBuscados(String destino, Date fecha, String matricula) {
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "SELECT id_ticket AS \"ID Ticket\", \n" +
                     "nombre_pasajero AS \"Nombre del Pasajero\",\n" +
                     "apellidos_pasajero AS \"Apellidos del Pasajero\",\n" +
                     "ci_pasajero AS \"Carnet de Identidad\",\n" +
                     "fecha_salida AS \"Fecha de Salida\",\n" +
                     "destino AS \"Destino\",\n" +
                     "matricula AS \"Matricula\"\n" +
                     "FROM \"Ticket\"\n" +
                     "WHERE destino = ? AND fecha_salida = ? AND matricula = ?\n" +
                     "ORDER BY id_ticket ASC";

        Connection conexion2 = ConexionDataBase.getConnection(); // Suponiendo que este método obtiene una nueva conexión
        try (PreparedStatement pst = conexion2.prepareStatement(sql)) {
            // Establece los parámetros de la consulta
            pst.setString(1, destino);
            pst.setDate(2, new java.sql.Date(fecha.getTime())); // Convertir java.util.Date a java.sql.Date
            pst.setString(3, matricula);

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
