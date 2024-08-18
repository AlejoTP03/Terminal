/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;

/**
 *
 * @author PC
 */
public class Taller {
    private int idTaller;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Omnibus> listadoOmnibus;

    public Taller() {
        this.idTaller = 2430;
        this.nombre = "Mechanical Solution";
        this.direccion = "Carretera Central #500";
        this.telefono = "41331211";
    }

    public Taller(List<Omnibus> listadoOmnibus) {
        this.idTaller = 2430;
        this.nombre = "Mechanical Solution";
        this.direccion = "Carretera Central #500";
        this.telefono = "41331211";
        this.listadoOmnibus = listadoOmnibus;
    }
    
    
    public int getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(int idTaller) {
        this.idTaller = idTaller;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Omnibus> getListadoOmnibus() {
        return listadoOmnibus;
    }

    public void setListadoOmnibus(List<Omnibus> listadoOmnibus) {
        this.listadoOmnibus = listadoOmnibus;
    }
    
    
}
