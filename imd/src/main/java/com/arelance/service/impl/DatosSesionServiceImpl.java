package com.arelance.service.impl;

import com.arelance.dao.DatosSesionDAO;
import com.arelance.domain.DatosSesion;
import com.arelance.service.DatosSesionService;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
public class DatosSesionServiceImpl implements DatosSesionService {

    @Inject
    private DatosSesionDAO datosSesionDAO;

    @Override
    public DatosSesion findDatosSesionByID(DatosSesion datosSesion) {
        return datosSesionDAO.findDatosSesionByID(datosSesion);
    }
    
        @Override
    public DatosSesion findDatosSesionByUsuario(DatosSesion datosSesion) {
        return datosSesionDAO.findDatosSesionByUsuario(datosSesion);
    }
    

    @Override
    public void addDatosSesion(DatosSesion datosSesion) {
        datosSesionDAO.addDatosSesion(datosSesion);
    }

    @Override
    public void updatePersona(DatosSesion datosSesion) {
        datosSesionDAO.updatePersona(datosSesion);
    }

    @Override
    public void removePersona(DatosSesion datosSesion) {
        datosSesionDAO.removePersona(datosSesion);
    }  
    
    @Override
    public DatosSesion inicioSesion(DatosSesion datosSesion) {
       return datosSesionDAO.inicioSesion(datosSesion);
    }


    
    

}
