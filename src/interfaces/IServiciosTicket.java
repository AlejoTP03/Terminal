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
    public boolean eliminarTicket(int idTicket);
    public void actualizarTicket(int idTicket, String nombreColumna, Object dato);
    public List<Omnibus> obtenerOmnibusPorDestino(String destino);
    public boolean verificarCapacidadOmnibus(Date fechaSalida, String matricula);
    public String obtenerNombrePorIdTicket(int idTicket);
    public String obtenerApellidoPorIdTicket(int idTicket);
    public String obtenerCIPorIdTicket(int idTicket);
    public String obtenerFechaPorIdTicket(int idTicket);
}
