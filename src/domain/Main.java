/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import persistence.ConexionDataBase;

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
//        conectar.closeConnection();;
        conectar.comprobarConexion();
    }
    
    Taller taller = new Taller();
//    Omnibus omnibus = new Omnibus("P222222", "Youtong", "EX50H0", "Cienfuegos", 42, 12:30:00, "China", 2430);
    
    
}
