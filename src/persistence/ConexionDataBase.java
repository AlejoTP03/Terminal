/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author PC
 */
public class ConexionDataBase {
    private static final String URL = "jdbc:postgresql://localhost:5432/Terminal";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Alejandro2003";

    private static Connection connection;

    // Método para obtener la conexión
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Registrar el driver de PostgreSQL
                Class.forName("org.postgresql.Driver");
                
                // Establecer la conexión
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión establecida con éxito");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar con la base de datos");
        }
        return connection;
    }

//    // Método para cerrar la conexión
//    public static void closeConnection() {
//        if (connection != null) {
//            try {
//                connection.close();
//                System.out.println("Conexión cerrada");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    
//    
//    // Método para comprobar la conexión a la base de datos
//    public static boolean comprobarConexion() {
//        try {
//            Connection testConnection = DriverManager.getConnection(URL, USER, PASSWORD);
//            testConnection.close(); // Cerrar la conexión de prueba inmediatamente
//            return true; // La conexión fue exitosa
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false; // La conexión falló
//        }
//    }
}
