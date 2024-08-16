/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import domain.Ticket;

/**
 *
 * @author PC
 */
public interface IServiciosTicket {
    public int agregarTicket(Ticket ticket);
    public boolean eliminarTicket();
    public boolean actualizarTicket(Ticket ticket);
}
