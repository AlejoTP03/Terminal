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
        // Define la sentencia SQL para insertar un nuevo registro en la tabla Ticket.
        // Los signos de interrogación (?) son parámetros que se establecerán más adelante.
        String sql = "INSERT INTO \"Ticket\" (id_ticket, nombre_pasajero, apellido_pasajero, ci_pasajero, fecha_salida, destino, matricula) VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Intenta realizar la operación de inserción dentro de un bloque try-with-resources.
        // Esto asegura que los recursos (Connection y PreparedStatement) se cierren automáticamente al final del bloque.
        try (Connection connection = conexion.getConnection();  // Obtiene una conexión a la base de datos usando el método getConnection() de la clase conexion.
            PreparedStatement stmt = connection.prepareStatement(sql)) {  // Prepara la sentencia SQL para la ejecución.

            // Establece el valor del primer parámetro en la sentencia SQL con el id del ticket.
            stmt.setInt(1, ticket.getIdTicket());
            // Establece el valor del segundo parámetro en la sentencia SQL con el nombre del pasajero.
            stmt.setString(2, ticket.getNombePasajero());
            // Establece el valor del tercer parámetro en la sentencia SQL con el apellido del pasajero.
            stmt.setString(3, ticket.getApellidoPasajero());
            // Establece el valor del cuarto parámetro en la sentencia SQL con el CI del pasajero.
            stmt.setString(4, ticket.getCiPasajero());
            // Establece el valor del quinto parámetro en la sentencia SQL con la fecha de salida, convirtiendo el tipo Date de Java a java.sql.Date.
            stmt.setDate(5, new java.sql.Date(ticket.getFechaSalida().getTime()));
            // Establece el valor del sexto parámetro en la sentencia SQL con el destino del viaje.
            stmt.setString(6, ticket.getDestino());
            // Establece el valor del séptimo parámetro en la sentencia SQL con la matrícula del vehículo.
            stmt.setString(7, ticket.getMatricula());

            // Ejecuta la actualización de la base de datos (inserción) y obtiene el número de filas afectadas.
            int rowsAffected = stmt.executeUpdate();
            // Devuelve true si se han afectado una o más filas, indicando que la inserción fue exitosa. De lo contrario, devuelve false.
         return rowsAffected > 0;
        } catch (SQLException e) {
            // Captura cualquier excepción SQL que ocurra durante la ejecución y la imprime en la consola para fines de depuración.
         e.printStackTrace();
            // Devuelve false en caso de excepción, indicando que la inserción falló.
            return false;
        }
    }

    @Override
    public boolean eliminarTicket() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
