package com.arelance.dao.impl;

import com.arelance.dao.EntrenadorDAO;
import com.arelance.domain.Entrenador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorge
 */
@Stateless
public class EntrenadorDAOImpl implements EntrenadorDAO {

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    public List<Entrenador> listarEntrenadores() {
        return em.createNamedQuery("Entrenador.findAll").getResultList();
    }

    @Override
    public Entrenador findEntrenadorByID(Entrenador entrenador) {
        return em.find(Entrenador.class, entrenador.getIdEntrenador());
    }

    @Override
    public void addEntrenador(Entrenador entrenador) {
        em.persist(entrenador);
    }

    @Override
    public void updateEntrenador(Entrenador entrenador) {
        em.merge(entrenador);
    }

    @Override
    public void removeEntrenador(Entrenador entrenador) {
        em.merge(entrenador);
        em.remove(entrenador);
    }

}
