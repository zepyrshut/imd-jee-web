package com.arelance.service;

import com.arelance.domain.UsuarioTieneActividad;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
public interface UsuarioTieneActividadService {

    public void addUsuarioTieneActividad(UsuarioTieneActividad usuarioTieneActividad);

}
