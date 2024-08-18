/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import persistence.ConexionDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.TraerIdTaller;

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) {
        Taller taller = new Taller();
        
        System.out.println(taller.getIdTaller());
        
        
        ConexionDataBase conectar = new ConexionDataBase();
        conectar.getConnection();
        //conectar.closeConnection();;
//        conectar.comprobarConexion();
        
        
        TraerIdTaller pepe = new TraerIdTaller();
        int consulta = pepe.obtenerIdTaller();
        System.out.println(consulta);
    }
       
    
}

 
