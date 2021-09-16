package com.arelance.service;

import com.arelance.domain.DatosSesion;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
public interface DatosSesionService {

    public DatosSesion findUsuarioByID(DatosSesion datosSesion);

    public void addUsuario(DatosSesion datosSesion);

    public void updatePersona(DatosSesion datosSesion);

    public void removePersona(DatosSesion datosSesion);

}
