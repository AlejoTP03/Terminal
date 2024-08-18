/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domain.Omnibus;
import domain.Taller;
import interfaces.IServiciosOmnibus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistence.ConexionDataBase;
/**
 *
 * @author PC
 */
public class ServiciosOmnibus implements IServiciosOmnibus{
    
    ConexionDataBase conexion = new ConexionDataBase();
        
    
    @Override
    public boolean agregarOmnibus(Omnibus omnibus) {
        // Define la consulta SQL para insertar un nuevo registro en la tabla "Omnibus".
        String sql = "INSERT INTO \"Omnibus\" (matricula, marca, modelo, destino, capacidad, hora_salida, pais_procedencia, id_taller) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Obtén la conexión, pero no la cierres automáticamente.
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            // Abre la conexión a la base de datos usando el método getConnection() de la clase 'conexion'.
            connection = conexion.getConnection();

            // Prepara la consulta SQL para ser ejecutada.
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, omnibus.getMatricula());
            stmt.setString(2, omnibus.getMarca());
            stmt.setString(3, omnibus.getModelo());
            stmt.setString(4, omnibus.getDestino());
            stmt.setInt(5, omnibus.getCapacidad());
            stmt.setTime(6, omnibus.getHoraSalida());
            stmt.setString(7, omnibus.getPaisProcedencia());
            stmt.setInt(8, omnibus.getIdTaller());

            // Ejecuta la consulta SQL y devuelve el número de filas afectadas.
            int filasAfectadas = stmt.executeUpdate();

            // Verifica si se ha insertado el ómnibus.
            if (filasAfectadas > 0) {
                System.out.println("Ómnibus agregado exitosamente.");
                return true;
            } else {
                System.out.println("No se insertó ningún ómnibus.");
                return false;
            }
        } catch (SQLException e) {
            // Manejo de excepciones SQL.
            System.err.println("Error al agregar el ómnibus: " + e.getMessage());
            return false;
        } finally {
            // Cierra solo el PreparedStatement, la conexión queda abierta.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar el PreparedStatement: " + e.getMessage());
                }
            }
        }
    }

    @Override
    public boolean eliminarOmnibus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizarTicket(Omnibus omnibus) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
