/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Ticket {
    private int idTicket;
    private String nombePasajero;
    private String apellidosPasajero;
    private String ciPasajero;
    private Date fechaSalida;
    private String destino;
    private String matricula;

    public Ticket(int idTicket, String nombePasajero, String apellidoPasajero, String ciPasajero, Date fechaSalida, String destino, String matricula) {
        this.idTicket = idTicket;
        this.nombePasajero = nombePasajero;
        this.apellidosPasajero = apellidoPasajero;
        this.ciPasajero = ciPasajero;
        this.fechaSalida = fechaSalida;
        this.destino = destino;
        this.matricula = matricula;
    }

    public Ticket(String nombePasajero, String apellidoPasajero, String ciPasajero, Date fechaSalida, String destino, String matricula) {
        this.nombePasajero = nombePasajero;
        this.apellidosPasajero = apellidoPasajero;
        this.ciPasajero = ciPasajero;
        this.fechaSalida = fechaSalida;
        this.destino = destino;
        this.matricula = matricula;
    }

        
    public int getIdTicket() {
        return idTicket;
    }

    public void setId(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getNombePasajero() {
        return nombePasajero;
    }

    public void setNombePasajero(String nombePasajero) {
        this.nombePasajero = nombePasajero;
    }

    public String getApellidosPasajero() {
        return apellidosPasajero;
    }

    public void setApellidosPasajero(String apellidoPasajero) {
        this.apellidosPasajero = apellidosPasajero;
    }

    public String getCiPasajero() {
        return ciPasajero;
    }

    public void setCiPasajero(String ciPasajero) {
        this.ciPasajero = ciPasajero;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
    
}
