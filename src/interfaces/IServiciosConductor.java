/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import domain.Conductor;

/**
 *
 * @author PC
 */
public interface IServiciosConductor {
    public int agregarConductor(Conductor conductor);
    public boolean eliminarConductor(Conductor conductor);
    public boolean actualizarConductor(Conductor conductor);
}
