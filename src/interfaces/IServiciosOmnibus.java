/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import domain.Omnibus;
import java.util.Date;

/**
 *
 * @author PC
 */
public interface IServiciosOmnibus {
    public boolean agregarOmnibus(Omnibus omnibus);
    public boolean eliminarOmnibus(String matricula);
    public void actualizarOmnibus(String matricula, String nombreColumna, Object dato);
    
}
