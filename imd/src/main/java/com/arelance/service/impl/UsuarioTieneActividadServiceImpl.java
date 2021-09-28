/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.service.impl;

import com.arelance.dao.UsuarioTieneActividadDAO;
import javax.inject.Inject;
import com.arelance.domain.UsuarioTieneActividad;
import com.arelance.service.UsuarioTieneActividadService;

/**
 *
 * @author Admin
 */
public class UsuarioTieneActividadServiceImpl implements UsuarioTieneActividadService {
    
    @Inject
    UsuarioTieneActividadDAO usuarioTieneActividadDAO;

    @Override
    public void addUsuarioTieneActividad(UsuarioTieneActividad usuarioTieneActividad) {
         usuarioTieneActividadDAO.addUsuarioTieneActividad(usuarioTieneActividad);
    }
    
}
