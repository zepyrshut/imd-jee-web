/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.service.impl;

import javax.inject.Inject;
import com.arelance.dao.UsuarioTieneActividadPKDAO;
import com.arelance.domain.UsuarioTieneActividadPK;
import com.arelance.service.UsuarioTieneActividadPKService;

/**
 *
 * @author Admin
 */
public class UsuarioTieneActividadPKServiceImpl implements UsuarioTieneActividadPKService {
    
    @Inject
    UsuarioTieneActividadPKDAO usuarioTieneActividadPKDAO;

    @Override
    public void addUsuarioTieneActividadPK(UsuarioTieneActividadPK usuarioTieneActividadPK) {
         usuarioTieneActividadPKDAO.addUsuarioTieneActividadPK(usuarioTieneActividadPK);
    }
    
}
