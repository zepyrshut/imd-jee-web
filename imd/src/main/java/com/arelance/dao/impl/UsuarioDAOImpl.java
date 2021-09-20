package com.arelance.dao.impl;

import com.arelance.dao.UsuarioDAO;
import com.arelance.domain.DatosSesion;
import com.arelance.domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Pedro
 */
@Stateless
public class UsuarioDAOImpl implements UsuarioDAO {

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    public List<Usuario> listarUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findUsuarioByID(Usuario usuario) {
        return em.find(Usuario.class, usuario.getIdUsuario());
    }

    @Override
    public Usuario findUsuarioByEmail(Usuario usuario) {
        Query query = em.createNamedQuery("Usuario.findByEmail");
        query.setParameter("email", usuario.getEmail());
        try {
            return (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public void addUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void removeUsuario(Usuario usuario) {
        em.merge(usuario);
        em.remove(usuario);
    }

    @Override
    public Usuario refrescar(Usuario usuario) {
        em.refresh(em.merge(usuario));
        return usuario;
    }

}
