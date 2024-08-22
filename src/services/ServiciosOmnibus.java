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
import javax.swing.JTextField;
import persistence.ConexionDataBase;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class ServiciosOmnibus implements IServiciosOmnibus{
    
    ConexionDataBase conexion = new ConexionDataBase();
        
    
    @Override
    public boolean agregarOmnibus(Omnibus omnibus) {
        // Define la consulta SQL para insertar un nuevo registro en la tabla "Omnibus".
        if (isMatriculaExists(omnibus.getMatricula())) {
            return false; // La matrícula ya existe
        }

        String sql = "INSERT INTO \"Omnibus\" (matricula, marca, modelo, destino, capacidad, hora_salida, pais_procedencia, id_taller) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = conexion.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, omnibus.getMatricula());
            pstmt.setString(2, omnibus.getMarca());
            pstmt.setString(3, omnibus.getModelo());
            pstmt.setString(4, omnibus.getDestino());
            pstmt.setInt(5, omnibus.getCapacidad());
            pstmt.setTime(6, omnibus.getHoraSalida());
            pstmt.setString(7, omnibus.getPaisProcedencia());
            pstmt.setInt(8, omnibus.getIdTaller());
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminarOmnibus(String matricula) {
        String sql = "DELETE FROM \"Omnibus\" WHERE matricula = ?";
        try (Connection conn = conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, matricula);

            int rowsAffected = pstmt.executeUpdate();

            // Si se afectó al menos una fila, significa que la eliminación fue exitosa
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    @Override
    public void actualizarOmnibus(String matricula, String nombreColumna, Object dato) {
        String dbColumnName;
        switch (nombreColumna) {
            case "Marca":
                dbColumnName = "marca";
                break;
            case "Modelo":
                dbColumnName = "modelo";
                break;
            case "Capacidad":
                dbColumnName = "capacidad";
                break;
            case "Destino":
                dbColumnName = "destino";
                break;
            case "Hora de Salida":
                dbColumnName = "hora_salida";
                break;
            case "País de Procedencia":
                dbColumnName = "pais_procedencia";
                break;
            case "Número de Taller":
                dbColumnName = "numero_taller";
                break;
            default:
                System.err.println("Columna desconocida: " + nombreColumna);
                return;
        }

        // Construye la consulta SQL
        String sql = "UPDATE \"Omnibus\" SET " + dbColumnName + " = ? WHERE matricula = ?";

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            // Establece el valor del dato
            pstmt.setObject(1, dato);

            // Establece la matrícula
            pstmt.setString(2, matricula);

            // Ejecuta la actualización
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("El registro con matrícula " + matricula + " fue actualizado.");
            } else {
                System.out.println("No se encontró el registro con matrícula " + matricula + ".");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    
    private boolean isMatriculaExists(String matricula) {
        String sql = "SELECT COUNT(*) FROM \"Omnibus\" WHERE matricula = ?";
        
        try (Connection conn = conexion.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, matricula);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    
    
}