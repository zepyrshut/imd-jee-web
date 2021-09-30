package com.arelance.service;

import com.arelance.domain.UsuarioTieneActividadPK;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
public interface UsuarioTieneActividadPKService {
    
    public void addUsuarioTieneActividadPK(UsuarioTieneActividadPK usuarioTieneActividadPK);
    
}
