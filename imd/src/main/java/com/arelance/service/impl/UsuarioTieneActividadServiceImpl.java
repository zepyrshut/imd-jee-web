package com.arelance.service.impl;

import com.arelance.dao.UsuarioTieneActividadDAO;
import javax.inject.Inject;
import com.arelance.domain.UsuarioTieneActividad;
import com.arelance.service.UsuarioTieneActividadService;

/**
 *
 * @author Jorge
 */
public class UsuarioTieneActividadServiceImpl implements UsuarioTieneActividadService {
    
    @Inject
    UsuarioTieneActividadDAO usuarioTieneActividadDAO;

    @Override
    public void addUsuarioTieneActividad(UsuarioTieneActividad usuarioTieneActividad) {
         usuarioTieneActividadDAO.addUsuarioTieneActividad(usuarioTieneActividad);
    }
    
}
