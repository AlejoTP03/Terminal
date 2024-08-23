/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import domain.Omnibus;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author PC
 */
public interface IServiciosOmnibus {
    public boolean agregarOmnibus(Omnibus omnibus);
    public boolean eliminarOmnibus(String matricula);
    public boolean actualizarOmnibus(String matricula, String marca, String modelo, int capacidad, String destino, Time horaSalida, String paisProcedencia, int idTaller);
    
}
