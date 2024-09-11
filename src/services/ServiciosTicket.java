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
import java.text.SimpleDateFormat;
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
    public void actualizarTicket(int idTicket, String nombreColumna, Object dato) {
        // Mapeo de los nombres de columnas del JTable a los nombres reales en la base de datos
        String dbColumnName;
        switch (nombreColumna) {
            case "ID Ticket":
                dbColumnName = "id_ticket";
                break;
            case "Nombre del Pasajero":
                dbColumnName = "nombre_pasajero";
                break;
            case "Apellidos del Pasajero":
                dbColumnName = "apellidos_pasajero";
                break;
            case "Carnet de Identidad":
                dbColumnName = "ci_pasajero";
                break;
            case "Fecha de Salida":
                dbColumnName = "fecha_salida";
                break;
            case "Destino":
                dbColumnName = "destino";
                break;
            case "Matricula":
                dbColumnName = "matricula";
                break;
            default:
                throw new IllegalArgumentException("Columna desconocida: " + nombreColumna);
        }

        String sql = "UPDATE \"Ticket\" SET " + dbColumnName + " = ? WHERE id_ticket = ?";

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            // Establece el valor del nuevo dato
            pstmt.setObject(1, dato);
            pstmt.setInt(2, idTicket);

            // Ejecuta la actualización
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("El registro con id_ticket " + idTicket + " fue actualizado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    // Método para obtener los ómnibus que cumplen con destino y hora de salida
    public List<Omnibus> obtenerOmnibusPorDestino(String destino){
    List<Omnibus> omnibusList = new ArrayList<>();
    String sql = "SELECT * FROM \"Omnibus\" WHERE disponible = TRUE AND destino = ?";

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

    
    
    @Override
    public boolean verificarCapacidadOmnibus(Date fechaSalida, String matricula) {
        String sql = "SELECT COUNT(*) FROM \"Ticket\" WHERE \"fecha_salida\" = TO_DATE(?, 'YYYY-MM-DD') AND \"matricula\" = ?";
    
        try (Connection conn = conexion.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Configurar los parámetros
            pstmt.setString(1, new SimpleDateFormat("yyyy-MM-dd").format(fechaSalida));
            pstmt.setString(2, matricula);

            // Ejecutar la consulta
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int cantidadTickets = rs.getInt(1);

                // Aquí debes obtener la capacidad del ómnibus para comparar
                int capacidadOmnibus = obtenerCapacidadOmnibus(matricula);

                // Comparar cantidad de tickets con la capacidad del ómnibus
                return cantidadTickets < capacidadOmnibus;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    
    
    public int obtenerCapacidadOmnibus(String matricula) {
        int capacidad = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = conexion.getConnection();
            String sql = "SELECT capacidad FROM \"Omnibus\" WHERE matricula = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, matricula);

            rs = ps.executeQuery();

            if (rs.next()) {
                capacidad = rs.getInt("capacidad");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return capacidad;
    }
    
    
    public String obtenerNombrePorIdTicket(int idTicket) {
        String nombre = null; 
        String sql = "SELECT nombre_pasajero FROM \"Ticket\" WHERE id_ticket = ?"; 

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idTicket);

            try (ResultSet rs = pstmt.executeQuery()) { 
                if (rs.next()) { 
                    nombre = rs.getString("nombre_pasajero");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre: " + e.getMessage());
            e.printStackTrace();
        }

        return nombre;
    }

    public String obtenerApellidoPorIdTicket(int idTicket) {
        String apellido = null; 
        String sql = "SELECT apellidos_pasajero FROM \"Ticket\" WHERE id_ticket = ?"; 

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idTicket);

            try (ResultSet rs = pstmt.executeQuery()) { 
                if (rs.next()) { 
                    apellido = rs.getString("apellidos_pasajero");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el apellido: " + e.getMessage());
            e.printStackTrace();
        }

        return apellido;
    }
    
    public String obtenerCIPorIdTicket(int idTicket) {
        String ci = null; 
        String sql = "SELECT ci_pasajero FROM \"Ticket\" WHERE id_ticket = ?"; 

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idTicket);

            try (ResultSet rs = pstmt.executeQuery()) { 
                if (rs.next()) { 
                    ci = rs.getString("ci_pasajero");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre: " + e.getMessage());
            e.printStackTrace();
        }

        return ci;
    }
    
    public String obtenerFechaPorIdTicket(int idTicket) {
        String fechaFormato = null;
        String query = "SELECT fecha_salida FROM \"Ticket\" WHERE id_ticket = ?"; // Ajusta el nombre de la columna y la tabla según sea necesario

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement statement = conexion.prepareStatement(query)) {
            
            statement.setInt(1, idTicket);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Date fecha = resultSet.getDate("fecha_salida"); // Cambia "fecha" por el nombre correcto de la columna en la tabla
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    fechaFormato = formato.format(fecha);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fechaFormato;
    }

    @Override
    public String obtenerDestinoPorIdTicket(int idTicket) {
        String destino = null; 
        String sql = "SELECT destino FROM \"Ticket\" WHERE id_ticket = ?"; 

        try (Connection conexion = ConexionDataBase.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idTicket);

            try (ResultSet rs = pstmt.executeQuery()) { 
                if (rs.next()) { 
                    destino = rs.getString("destino");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el destino: " + e.getMessage());
            e.printStackTrace();
        }

        return destino;
    }
    
    
}
