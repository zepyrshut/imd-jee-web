package com.arelance.dao;

import com.arelance.domain.DatosSesion;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
public interface DatosSesionDAO {

    public DatosSesion findDatosSesionByID(DatosSesion datosSesion);
    
    public DatosSesion findDatosSesionByUsuario(DatosSesion datosSesion);

    public void addDatosSesion(DatosSesion datosSesion);

    public void updatePersona(DatosSesion datosSesion);

    public void removePersona(DatosSesion datosSesion);

    public DatosSesion inicioSesion(DatosSesion datosSesion);

}
