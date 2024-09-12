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
    public boolean actualizarConductor(Conductor conductor, int idConductor);
    public List<String> obtenerMatriculasDisponibles();
    public String obtenerNombrePorIdConductor(int idConductor);
    public String obtenerApellidoPorIdConductor(int idConductor);
    public String obtenerDireccionPorIdConductor(int idConductor);
    public String obtenerTelefonoPorIdConductor(int idConductor);
    public String obtenerMatriculaPorIdConductor(int idConductor);
}
