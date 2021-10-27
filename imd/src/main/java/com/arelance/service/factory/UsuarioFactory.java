package com.arelance.service.factory;

import com.arelance.service.impl.UsuarioCrud;

/**
 *
 * @author Pedro
 */
public class UsuarioFactory implements Factory {

    @Override
    public Crud createCrud() {
        return new UsuarioCrud();
    }
    
}
