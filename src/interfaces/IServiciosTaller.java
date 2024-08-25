/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.time.LocalDate;

/**
 *
 * @author PC
 */
public interface IServiciosTaller {
    public boolean enviarAlTaller(String matricula);
    public boolean tieneTicketsPendientes(String matricula, LocalDate fechaActual);
    public boolean eliminarOmnibus(String matricula);
    public boolean ponerDisponible(String matricula);
}
