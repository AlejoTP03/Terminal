/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.IServiciosTaller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistence.ConexionDataBase;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.Date;

/**
 *
 * @author PC
 */
public class ServiciosTaller implements IServiciosTaller{
    ConexionDataBase conexion = new ConexionDataBase();
    
    
    
    @Override
    public boolean enviarAlTaller(String matricula) {
        String sql = "UPDATE \"Omnibus\" SET disponible = false WHERE matricula = ?";
        Connection conn = conexion.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, matricula);
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean ponerDisponible(String matricula) {
        String sql = "UPDATE \"Omnibus\" SET disponible = TRUE WHERE matricula = ?";
        Connection conn = conexion.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, matricula);
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean tieneTicketsPendientes(String matricula, LocalDate fechaActual) {
        String sql = "SELECT COUNT(*) FROM \"Ticket\" WHERE matricula = ? AND fecha_salida > ?";
        Connection conn = conexion.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, matricula);
            pstmt.setDate(2, Date.valueOf(fechaActual));

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // True si hay tickets en fechas posteriores
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    
    public boolean eliminarOmnibus(String matricula) {
        try (Connection conn = conexion.getConnection()) {
            String sql = "DELETE FROM \"Omnibus\" WHERE matricula = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, matricula);
                int filasAfectadas = pstmt.executeUpdate();
                return filasAfectadas > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
