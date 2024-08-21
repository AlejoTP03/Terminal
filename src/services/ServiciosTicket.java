/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domain.Omnibus;
import domain.Ticket;
import interfaces.IServiciosTicket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistence.ConexionDataBase;
import java.sql.Time;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public class ServiciosTicket implements IServiciosTicket{
    ConexionDataBase conexion = new ConexionDataBase();
    
    @Override
    public boolean agregarTicket(Ticket ticket) {
        // Consulta SQL para insertar un nuevo ticket en la tabla "Ticket"
        String sql = "INSERT INTO \"Ticket\" (nombre_pasajero, apellidos_pasajero, ci_pasajero, fecha_salida, destino, matricula) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexion.getConnection(); // Obtener la conexión a la base de datos
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Preparar la declaración SQL

            // Establecer los valores de los parámetros en la consulta SQL
            pstmt.setString(1, ticket.getNombePasajero());
            pstmt.setString(2, ticket.getApellidosPasajero());
            pstmt.setString(3, ticket.getCiPasajero());
            pstmt.setDate(4, new java.sql.Date(ticket.getFechaSalida().getTime()));
            pstmt.setString(5, ticket.getDestino());
            pstmt.setString(6, ticket.getMatricula());

            // Ejecutar la consulta SQL y verificar si se afectaron filas
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0; // Devolver true si se insertó correctamente

        } catch (SQLException e) {
            e.printStackTrace(); // Imprimir la traza de la excepción si ocurre un error
            return false; // Devolver false si ocurrió un error
        }
    }

    @Override
    public boolean eliminarTicket(int idTicket) {
        String sql = "DELETE FROM \"Ticket\" WHERE id_ticket = ?"; // Asumiendo que la columna ID en la tabla se llama "id"
    
        try (Connection conn = conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idTicket);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizarTicket(Ticket ticket) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    @Override
    // Método para obtener los ómnibus que cumplen con destino y hora de salida
    public List<Omnibus> obtenerOmnibusPorDestino(String destino){
    List<Omnibus> omnibusList = new ArrayList<>();
    String sql = "SELECT * FROM \"Omnibus\" WHERE destino = ?";

    try (Connection conn = ConexionDataBase.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, destino);
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Omnibus omnibus = new Omnibus();
                omnibus.setMatricula(rs.getString("matricula"));
                omnibus.setMarca(rs.getString("marca"));
                omnibus.setModelo(rs.getString("modelo"));
                omnibus.setCapacidad(rs.getInt("capacidad"));
                omnibus.setDestino(rs.getString("destino"));
                omnibus.setPaisProcedencia(rs.getString("pais_procedencia"));
                omnibus.setIdTaller(rs.getInt("id_taller"));
                omnibusList.add(omnibus);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return omnibusList;
    }

    
}
