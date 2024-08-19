/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import domain.Omnibus;
import domain.Ticket;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IServiciosTicket {
    public boolean agregarTicket(Ticket ticket);
    public boolean eliminarTicket();
    public boolean actualizarTicket(Ticket ticket);
    public List<Omnibus> obtenerOmnibusPorDestino(String destino);
}
