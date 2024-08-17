/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domain.Omnibus;
import interfaces.IServiciosOmnibus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author PC
 */
public class ServiciosOmnibus implements IServiciosOmnibus{
    
    private Connection connection;

    public ServiciosOmnibus(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public boolean agregarOmnibus(Omnibus omnibus) {
        String sql = "INSERT INTO Omnibus (Matricula, Marca, Modelo, Capacidad, Destino, Hora de Salida, Pais de Procedencia, idTaller) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, omnibus.getMatricula());
            stmt.setString(2, omnibus.getMarca());
            stmt.setString(3, omnibus.getModelo());
            stmt.setInt(4, omnibus.getCapacidad());
            stmt.setString(5, omnibus.getDestino());
            stmt.setTime(6, omnibus.getHoraSalida());
            stmt.setString(7, omnibus.getPaisProcedencia());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Ómnibus agregado exitosamente.");
                return true;
            } else {
                System.out.println("No se insertó ningún ómnibus.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error al agregar el ómnibus: " + e.getMessage());
            return false;
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
