/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.dao;

import com.arelance.domain.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
public interface UsuarioDAO {

    public List<Usuario> listarUsuarios();

    public Usuario findUsuarioByEmail(Usuario usuario);

    public Usuario findUsuarioByID(Usuario usuario);

    public void addUsuario(Usuario usuario);

    public void updateUsuario(Usuario usuario);

    public void removeUsuario(Usuario usuario);

}
