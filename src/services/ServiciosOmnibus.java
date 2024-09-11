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
import java.sql.Types;
import javax.swing.SwingWorker;

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
        // Mapeo de los nombres de columnas del JTable a los nombres reales en la base de datos
        String dbColumnName;
        int tipoDato;
        switch (nombreColumna) {
            case "ID Omnibus":
                dbColumnName = "id_omnibus";
                tipoDato = Types.INTEGER;  // Asume que es INTEGER
                break;
            case "Matrícula":
                dbColumnName = "matricula";
                tipoDato = Types.VARCHAR;  // Asume que es VARCHAR
                break;
            case "Marca":
                dbColumnName = "marca";
                tipoDato = Types.VARCHAR;  // Asume que es VARCHAR
                break;
            case "Modelo":
                dbColumnName = "modelo";
                tipoDato = Types.VARCHAR;  // Asume que es VARCHAR
                break;
            case "Capacidad":
                dbColumnName = "capacidad";
                tipoDato = Types.INTEGER;  // Asegúrate de que es INTEGER
                break;
            case "Destino":
                dbColumnName = "destino";
                tipoDato = Types.VARCHAR;  // Asume que es VARCHAR
                break;
            case "Hora de Salida":
                dbColumnName = "hora_salida";
                tipoDato = Types.TIME;  // Asume que es TIME
                break;
            case "País de Procedencia":
                dbColumnName = "pais_procedencia";
                tipoDato = Types.VARCHAR;  // Asume que es VARCHAR
                break;
            case "Número de Taller":
                dbColumnName = "id_taller";
                tipoDato = Types.INTEGER;  // Asume que es INTEGER
                break;
            default:
                throw new IllegalArgumentException("Columna desconocida: " + nombreColumna);
        }

        String sql = "UPDATE \"Omnibus\" SET " + dbColumnName + " = ? WHERE matricula = ?";

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            // Establece el valor del nuevo dato según el tipo
            switch (tipoDato) {
                case Types.INTEGER:
                    pstmt.setInt(1, (Integer) dato);
                    break;
                case Types.VARCHAR:
                    pstmt.setString(1, (String) dato);
                    break;
                case Types.TIME:
                    pstmt.setTime(1, (Time) dato);
                    break;
                // Añadir otros tipos si es necesario
                default:
                    throw new IllegalArgumentException("Tipo de dato desconocido: " + tipoDato);
            }

            pstmt.setString(2, matricula);  // Usa matricula en lugar de idOmnibus

            // Ejecuta la actualización
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("El registro con matricula " + matricula + " fue actualizado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public String obtenerMarcaPorMatricula(String matricula) {
        String marca = null;
        String sql = "SELECT marca FROM \"Omnibus\" WHERE matricula = ?"; 

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, matricula);

            try (ResultSet rs = pstmt.executeQuery()) { 
                if (rs.next()) { 
                    marca = rs.getString("marca");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la marca: " + e.getMessage());
            e.printStackTrace();
        }

        return marca;
    }
    

    @Override
    public String obtenerModeloPorMatricula(String matricula) {
        String modelo = null;
        String sql = "SELECT modelo FROM \"Omnibus\" WHERE matricula = ?"; 

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, matricula);

            try (ResultSet rs = pstmt.executeQuery()) { 
                if (rs.next()) { 
                    modelo = rs.getString("modelo");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la modelo: " + e.getMessage());
            e.printStackTrace();
        }

        return modelo;
    }

    @Override
    public String obtenerDestinoPorMatricula(String matricula) {
        String destino = null;
        String sql = "SELECT destino FROM \"Omnibus\" WHERE matricula = ?"; 

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, matricula);

            try (ResultSet rs = pstmt.executeQuery()) { 
                if (rs.next()) { 
                    destino = rs.getString("destino");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la destino: " + e.getMessage());
            e.printStackTrace();
        }

        return destino;
    }

    @Override
    public int obtenerCapacidadPorMatricula(String matricula) {
        int capacidad = -1;
        String sql = "SELECT capacidad FROM \"Omnibus\" WHERE matricula = ?"; 

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, matricula);

            try (ResultSet rs = pstmt.executeQuery()) { 
                if (rs.next()) { 
                    capacidad = rs.getInt("capacidad");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la capacidad: " + e.getMessage());
            e.printStackTrace();
        }

        return capacidad;
    }

    @Override
    public String obtenerHoraSalidaPorMatricula(String matricula) {
        String horaSalida = null;
        String sql = "SELECT hora_salida FROM \"Omnibus\" WHERE matricula = ?";

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            pstmt.setString(1, matricula);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Time time = rs.getTime("hora_salida");
                    if (time != null) {
                        // Convierte el Time a formato HH:mm:ss
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                        horaSalida = sdf.format(time);
                    }
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return horaSalida;
    }

    @Override
    public String obtenerPaisProcedenciaPorMatricula(String matricula) {
        String paisProcedencia = null;
        String sql = "SELECT pais_procedencia FROM \"Omnibus\" WHERE matricula = ?"; 

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, matricula);

            try (ResultSet rs = pstmt.executeQuery()) { 
                if (rs.next()) { 
                    paisProcedencia = rs.getString("pais_procedencia");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el Pais de procedencia: " + e.getMessage());
            e.printStackTrace();
        }

        return paisProcedencia;
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
    
    
    public boolean matriculaAsociadaAConductor(String matricula) {
        String sql = "SELECT COUNT(*) FROM \"Conductor\" WHERE matricula = ?";
        Connection conn = conexion.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, matricula);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // True si hay conductores asociados a la matrícula
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
        
}