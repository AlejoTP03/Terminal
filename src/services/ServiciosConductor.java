/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domain.Conductor;
import interfaces.IServiciosConductor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import persistence.ConexionDataBase;

/**
 *
 * @author PC
 */
public class ServiciosConductor implements IServiciosConductor{

    @Override
    public int agregarConductor(Conductor conductor) {
        String sql = "INSERT INTO Conductor (nombre, apellido, direccion, telefono, matricula) VALUES (?, ?, ?, ?, ?)";
    
        try (Connection conn = ConexionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
         
            stmt.setString(1, conductor.getNombre());
            stmt.setString(2, conductor.getApellido());
            stmt.setString(3, conductor.getDireccion());
            stmt.setString(4, conductor.getTelefono());
            stmt.setString(5, conductor.getMatricula());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        conductor.setIdConductor(generatedId);
                     return generatedId;
                    } else {
                        throw new SQLException("Error al insertar el conductor, no se encontró el ID.");
                    }
                }
            } else {
                throw new SQLException("Error al insertar el conductor, no se afectaron filas.");
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar conductor: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public boolean eliminarConductor(Conductor conductor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizarConductor(Conductor conductor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
