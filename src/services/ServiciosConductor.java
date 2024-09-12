/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domain.Conductor;
import domain.Omnibus;
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
    public boolean eliminarConductor(Object idConductor) {
        String sql = "DELETE FROM \"Conductor\" WHERE id_conductor = ?";
        Connection conn = conexion.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, idConductor);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizarConductor(Conductor conductor, int idCondctor) {
        // Sentencia SQL para actualizar la tabla "Conductor"
        String sqlConductor = "UPDATE \"Conductor\" SET nombre = ?, apellido = ?, direccion = ?, telefono = ?, matricula = ? WHERE id_conductor = ?";

        try (Connection con = conexion.getConnection()) {
            // Desactivar el autoCommit
            con.setAutoCommit(false);

            try (PreparedStatement pstmt = con.prepareStatement(sqlConductor)) {

                // Establecer parámetros para la actualización de "Conductor"
                pstmt.setString(1, conductor.getNombre());
                pstmt.setString(2, conductor.getApellido());
                pstmt.setString(3, conductor.getDireccion());
                pstmt.setString(4, conductor.getTelefono());
                pstmt.setString(5, conductor.getMatricula());
                pstmt.setInt(6, idCondctor);

                // Ejecutar la actualización en la tabla "Conductor"
                int filasActualizadasConductor = pstmt.executeUpdate();

                // Si se actualizó al menos un registro en la tabla "Conductor"
                if (filasActualizadasConductor > 0) {
                    con.commit(); // Confirmar la actualización
                    return true;  // Indicar que la operación fue exitosa
                } else {
                    con.rollback(); // Revertir la actualización si no se actualizó nada
                    return false;  // Indicar que la operación falló
                }
            } catch (SQLException e) {
                con.rollback(); // Revertir la actualización en caso de excepción
                e.printStackTrace();
                return false;
            } finally {
                // Volver a activar el autoCommit
                con.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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

    @Override
    public String obtenerNombrePorIdConductor(int idConductor) {
        String nombre = null; 
        String sql = "SELECT nombre FROM \"Conductor\" WHERE id_conductor = ?"; 

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idConductor);

            try (ResultSet rs = pstmt.executeQuery()) { 
                if (rs.next()) { 
                    nombre = rs.getString("nombre");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre: " + e.getMessage());
            e.printStackTrace();
        }

        return nombre;
    }


    @Override
    public String obtenerApellidoPorIdConductor(int idConductor) {
        String apellido = null; 
        String sql = "SELECT apellido FROM \"Conductor\" WHERE id_conductor = ?"; 

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idConductor);

            try (ResultSet rs = pstmt.executeQuery()) { 
                if (rs.next()) { 
                    apellido = rs.getString("apellido");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el apellido: " + e.getMessage());
            e.printStackTrace();
        }

        return apellido;
    }

    @Override
    public String obtenerDireccionPorIdConductor(int idConductor) {
        String direccion = null; 
        String sql = "SELECT direccion FROM \"Conductor\" WHERE id_conductor = ?"; 

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idConductor);

            try (ResultSet rs = pstmt.executeQuery()) { 
                if (rs.next()) { 
                    direccion = rs.getString("direccion");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el direccion: " + e.getMessage());
            e.printStackTrace();
        }

        return direccion;
    }

    @Override
    public String obtenerTelefonoPorIdConductor(int idConductor) {
        String telefono = null; 
        String sql = "SELECT telefono FROM \"Conductor\" WHERE id_conductor = ?"; 

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idConductor);

            try (ResultSet rs = pstmt.executeQuery()) { 
                if (rs.next()) { 
                    telefono = rs.getString("telefono");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el telefono: " + e.getMessage());
            e.printStackTrace();
        }

        return telefono;
    }

    @Override
    public String obtenerMatriculaPorIdConductor(int idConductor) {
        String matricula = null; 
        String sql = "SELECT matricula FROM \"Conductor\" WHERE id_conductor = ?"; 

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idConductor);

            try (ResultSet rs = pstmt.executeQuery()) { 
                if (rs.next()) { 
                    matricula = rs.getString("matricula");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la matricula: " + e.getMessage());
            e.printStackTrace();
        }

        return matricula;
    }
    
    
}
