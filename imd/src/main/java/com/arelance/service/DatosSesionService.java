/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
