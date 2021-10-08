package com.arelance.service.impl;

import javax.inject.Inject;
import com.arelance.dao.UsuarioTieneActividadPKDAO;
import com.arelance.domain.UsuarioTieneActividadPK;
import com.arelance.service.UsuarioTieneActividadPKService;

/**
 *
 * @author Jorge
 */
public class UsuarioTieneActividadPKServiceImpl implements UsuarioTieneActividadPKService {
    
    @Inject
    UsuarioTieneActividadPKDAO usuarioTieneActividadPKDAO;

    @Override
    public void addUsuarioTieneActividadPK(UsuarioTieneActividadPK usuarioTieneActividadPK) {
         usuarioTieneActividadPKDAO.addUsuarioTieneActividadPK(usuarioTieneActividadPK);
    }
    
}
