/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.service;

import com.arelance.domain.Entrenador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface EntrenadorService {
        public List<Entrenador> listarEntrenadores();
 
    public Entrenador findEntrenadorByID(Entrenador entrenador);
    public void addEntrenador(Entrenador entrenador);
    public void updateEntrenador(Entrenador entrenador);
    public void removeEntrenador(Entrenador entrenador);
}
