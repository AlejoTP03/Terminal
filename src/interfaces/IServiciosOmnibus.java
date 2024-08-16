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
    public int agregarOmnibus(Omnibus omnibus);
    public boolean eliminarOmnibus();
    public boolean actualizarTicket(Omnibus omnibus);
}
