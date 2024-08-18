/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domain.Ticket;
import interfaces.IServiciosTicket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistence.ConexionDataBase;

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
        String sql = "INSERT INTO Ticket (idTicket, nombre_pasajero, apellido_pasajero, ci_pasajero, fecha_salida, destino, matricula) VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Intenta realizar la operación de inserción dentro de un bloque try-with-resources.
        // Esto asegura que los recursos (Connection y PreparedStatement) se cierren automáticamente al final del bloque.
        try (Connection connection = conexion.getConnection();  // Obtiene una conexión a la base de datos usando el método getConnection() de la clase conexion.
            PreparedStatement stmt = connection.prepareStatement(sql)) {  // Prepara la sentencia SQL para la ejecución.

            // Establece el valor del primer parámetro en la sentencia SQL con el id del ticket.
            stmt.setString(1, ticket.getIdTicket());
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
    
    
}
