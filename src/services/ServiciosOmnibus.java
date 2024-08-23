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
import java.sql.Time;

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
    public boolean actualizarOmnibus(String matricula, String marca, String modelo, int capacidad, String destino, Time horaSalida, String paisProcedencia, int idTaller) {
        String sql = "UPDATE \"Omnibus\" SET matricula = ?, marca = ?, modelo = ?, capacidad = ?, destino = ?, hora_salida = ?, pais_procedencia = ?, id_taller = ? WHERE matricula = ?";
    
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, matricula);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setInt(4, capacidad);
            ps.setString(5, destino);
            ps.setTime(6, horaSalida);
            ps.setString(7, paisProcedencia);
            ps.setInt(8, idTaller);
            

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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