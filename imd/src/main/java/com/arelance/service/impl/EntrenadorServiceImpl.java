/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.service.impl;

import com.arelance.dao.EntrenadorDAO;
import com.arelance.domain.Entrenador;
import com.arelance.service.EntrenadorService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author jorge
 */
public class EntrenadorServiceImpl implements EntrenadorService{
    @Inject
    private EntrenadorDAO entrenadorDAO;
    @Override
    public List<Entrenador> listarEntrenadores() {
     return entrenadorDAO.listarEntrenadores();
    }

    @Override
    public Entrenador findEntrenadorByID(Entrenador entrenador) {
       return entrenadorDAO.findEntrenadorByID(entrenador);
    }

    @Override
    public void addEntrenador(Entrenador entrenador) {
        entrenadorDAO.addEntrenador(entrenador);
    }

    @Override
    public void updateEntrenador(Entrenador entrenador) {
        entrenadorDAO.updateEntrenador(entrenador);
    }

    @Override
    public void removeEntrenador(Entrenador entrenador) {
      entrenadorDAO.removeEntrenador(entrenador);
    }
    
}
