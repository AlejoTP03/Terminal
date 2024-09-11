/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import domain.Omnibus;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author PC
 */
public interface IServiciosOmnibus {
    public boolean agregarOmnibus(Omnibus omnibus);
    public boolean eliminarOmnibus(String matricula);
    public boolean actualizarOmnibus(Omnibus omnibus, String matriculaAntigua);
    public boolean matriculaAsociadaAConductor(String matricula);
    public String obtenerMarcaPorMatricula(String matricula);
    public String obtenerModeloPorMatricula(String matricula);
    public String obtenerDestinoPorMatricula(String matricula);
    public int obtenerCapacidadPorMatricula(String matricula);
    public String obtenerHoraSalidaPorMatricula(String matricula);
    public String obtenerPaisProcedenciaPorMatricula(String matricula);
}
