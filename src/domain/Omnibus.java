/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;


import java.sql.Time;
/**
 *
 * @author PC
 */
public class Omnibus {
    private String matricula;
    private String marca;
    private String modelo;
    private String destino;
    private int capacidad;
    private Time horaSalida;
    private String paisProcedencia;
    private int idTaller;
    private boolean disponible;

    Taller taller = new Taller();
    public Omnibus(String matricula, String marca, String modelo, String destino, int capacidad, Time horaSalida, String paisProcedencia, int idTaller, boolean disponible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.destino = destino;
        this.capacidad = capacidad;
        this.horaSalida = horaSalida;
        this.paisProcedencia = paisProcedencia;
        this.idTaller = idTaller;
        this.disponible = disponible;
    }

    public Omnibus(String matricula, String marca, String modelo, String destino, int capacidad, Time horaSalida, String paisProcedencia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.destino = destino;
        this.capacidad = capacidad;
        this.horaSalida = horaSalida;
        this.paisProcedencia = paisProcedencia;
    }

    

    public Omnibus() {
    }
    
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }

    public int getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(int idTaller) {
        this.idTaller = idTaller;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    
    
}
