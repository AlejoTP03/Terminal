/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import domain.Omnibus;

/**
 *
 * @author PC
 */
public interface IServiciosOmnibus {
    public boolean agregarOmnibus(Omnibus omnibus);
    public boolean eliminarOmnibus();
    public void actualizarTicket(String matricula, String nombreColumna, Object dato);
}
