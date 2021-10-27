package com.arelance.service.impl;

import com.arelance.dao.facade.UsuarioFacade;
import com.arelance.domain.Usuario;
import com.arelance.service.factory.Crud;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
public class UsuarioCrud implements Crud<Usuario> {

    @Inject
    private UsuarioFacade usuarioFacade;

    @Override
    public void createEntity(Usuario t) {
        usuarioFacade.createEntity(t);
    }

    @Override
    public void updateEntity(Usuario t) {
        usuarioFacade.updateEntity(t);
    }

    @Override
    public void deleteEntity(Usuario t) {
        usuarioFacade.deleteEntity(t);
    }

    @Override
    public Usuario readEntity(Integer n) {
        return (Usuario) usuarioFacade.readEntity(n);
    }

    @Override
    public List<Usuario> readAllEntity() {
        return usuarioFacade.readAllEntity();
    }

    @Override
    public Usuario refreshEntity(Usuario t) {
        return (Usuario) usuarioFacade.refreshEntity(t);
    }

}
