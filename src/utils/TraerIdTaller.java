/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistence.ConexionDataBase;

/**
 *
 * @author PC
 */
public class TraerIdTaller {
    ConexionDataBase conex = new ConexionDataBase();
       public int obtenerIdTaller() {
       String sql = "SELECT id_taller FROM \"Taller\" LIMIT 1"; // Ajusta la consulta según tus necesidades
       int idTaller = -1; // Valor por defecto en caso de que no se encuentre ningún registro

       try (Connection connection = conex.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

           if (rs.next()) {
               idTaller = rs.getInt("id_taller"); // Aquí se usa el nombre correcto de la columna
           }

       } catch (SQLException e) {
           e.printStackTrace();
       }

       return idTaller;
   }
}
