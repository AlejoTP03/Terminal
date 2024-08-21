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
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "SELECT id_ticket AS \"ID Ticket\", \n" +
                     "nombre_pasajero AS \"Nombre del Pasajero\",\n" +
                     "apellidos_pasajero AS \"Apellidos del Pasajero\",\n" +
                     "ci_pasajero AS \"Carnet de Identidad\",\n" +
                     "fecha_salida AS \"Fecha de Salida\",\n" +
                     "destino AS \"Destino\",\n" +
                     "matricula AS \"Matricula\"\n" +
                     "FROM \"Ticket\"";

        // Abre una nueva conexión
        try (Connection conexion = ConexionDataBase.getConnection(); // Suponiendo que este método obtiene una nueva conexión
             Statement stmt = conexion.createStatement();
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
