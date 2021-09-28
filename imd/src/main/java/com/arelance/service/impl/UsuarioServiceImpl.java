package com.arelance.service.impl;

import com.arelance.dao.UsuarioDAO;
import com.arelance.domain.Usuario;
import com.arelance.service.UsuarioService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listarUsuarios();
    }

    @Override
    public Usuario findUsuarioByEmail(Usuario usuario) {
        return usuarioDAO.findUsuarioByEmail(usuario);
    }

    @Override
    public void addUsuario(Usuario usuario) {
        usuarioDAO.addUsuario(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        usuarioDAO.updateUsuario(usuario);
    }

    @Override
    public void removeUsuario(Usuario usuario) {
        usuarioDAO.removeUsuario(usuario);
    }
    
    @Override
    public Usuario refrescar(Usuario usuario) {
        usuarioDAO.refrescar(usuario);
        return usuario;
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        return usuarioDAO.findUsuarioByID(usuario);
    }

    @Override
    public Usuario findUsuarioById(Integer id) {
    return usuarioDAO.findUsuarioByID(id);
    }

}
