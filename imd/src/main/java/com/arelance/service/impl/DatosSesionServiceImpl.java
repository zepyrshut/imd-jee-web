/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public DatosSesion findUsuarioByID(DatosSesion datosSesion) {
        return datosSesionDAO.findUsuarioByID(datosSesion);
    }

    @Override
    public void addUsuario(DatosSesion datosSesion) {
        datosSesionDAO.addUsuario(datosSesion);
    }

    @Override
    public void updatePersona(DatosSesion datosSesion) {
        datosSesionDAO.updatePersona(datosSesion);
    }

    @Override
    public void removePersona(DatosSesion datosSesion) {
        datosSesionDAO.removePersona(datosSesion);
    }

}
