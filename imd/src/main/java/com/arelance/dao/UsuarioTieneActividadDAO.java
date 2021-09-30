package com.arelance.dao;

import com.arelance.domain.UsuarioTieneActividad;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
public interface UsuarioTieneActividadDAO {
    
      public void addUsuarioTieneActividad(UsuarioTieneActividad usuarioTieneActividad);
    
}
