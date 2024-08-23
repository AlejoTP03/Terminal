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
import java.util.ArrayList;
import java.util.List;
import persistence.ConexionDataBase;

/**
 *
 * @author PC
 */
public class ServiciosConductor implements IServiciosConductor{

    ConexionDataBase conexion = new ConexionDataBase();
    
    @Override
    public boolean agregarConductor(Conductor conductor) {
        Connection conn = conexion.getConnection();
        // Definir la consulta SQL
        String sql = "INSERT INTO \"Conductor\" (nombre, apellido, direccion, telefono, matricula) VALUES (?, ?, ?, ?, ?)";

        // Usar el PreparedStatement para ejecutar la inserción
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Configurar los parámetros del PreparedStatement
            pstmt.setString(1, conductor.getNombre());
            pstmt.setString(2, conductor.getApellido());
            pstmt.setString(3, conductor.getDireccion());
            pstmt.setString(4, conductor.getTelefono());
            pstmt.setString(5, conductor.getMatricula());

            // Ejecutar la inserción
            int filasAfectadas = pstmt.executeUpdate();

            // Verificar si se insertó al menos una fila
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
    
    
    @Override
    public List<String> obtenerMatriculasDisponibles() {
        List<String> matriculas = new ArrayList<>();
        String query = "SELECT o.matricula " +
                       "FROM \"Omnibus\" o " +
                       "LEFT JOIN \"Conductor\" c ON o.matricula = c.matricula " +
                       "GROUP BY o.matricula " +
                       "HAVING COUNT(c.matricula) < 2";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = conexion.getConnection(); // Obtén la conexión
            stmt = conn.createStatement();   // Crea el Statement
            rs = stmt.executeQuery(query);   // Ejecuta la consulta

            while (rs.next()) {
                matriculas.add(rs.getString("matricula"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierra los recursos en el bloque finally para garantizar que se cierren incluso si ocurre una excepción
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                // No cerramos la conexión aquí
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return matriculas;
    }
}
