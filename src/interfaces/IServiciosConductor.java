/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import domain.Conductor;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IServiciosConductor {
    public boolean agregarConductor(Conductor conductor);
    public boolean eliminarConductor(Object idConductor);
    public void actualizarConductor(int idConductor, String nombreColumna, Object dato);
    public List<String> obtenerMatriculasDisponibles();
}
