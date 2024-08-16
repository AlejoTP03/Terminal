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
    private String idTicket;
    private String nombePasajero;
    private String apellidoPasajero;
    private String ciPasajero;
    private Date fechaSalida;
    private String matricula;

    public Ticket(String nombePasajero, String apellidoPasajero, String ciPasajero, Date fechaSalida, String matricula) {
        this.nombePasajero = nombePasajero;
        this.apellidoPasajero = apellidoPasajero;
        this.ciPasajero = ciPasajero;
        this.fechaSalida = fechaSalida;
        this.matricula = matricula;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setId(String idTicket) {
        this.idTicket = idTicket;
    }

    public String getNombePasajero() {
        return nombePasajero;
    }

    public void setNombePasajero(String nombePasajero) {
        this.nombePasajero = nombePasajero;
    }

    public String getApellidoPasajero() {
        return apellidoPasajero;
    }

    public void setApellidoPasajero(String apellidoPasajero) {
        this.apellidoPasajero = apellidoPasajero;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
    
}
