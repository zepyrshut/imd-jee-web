package com.arelance.dao.impl;

import com.arelance.dao.DatosSesionDAO;
import com.arelance.domain.DatosSesion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Pedro
 */
@Stateless
public class DatosSesionDAOImpl implements DatosSesionDAO {

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;
    EntityManagerFactory emf;

    @Override
    public DatosSesion findDatosSesionByID(DatosSesion datosSesion) {
        return em.find(DatosSesion.class, datosSesion.getIdDatosSesion());
    }

    @Override
    public void addDatosSesion(DatosSesion datosSesion) {
        em.persist(datosSesion);
    }

    @Override
    public void updatePersona(DatosSesion datosSesion) {
        em.merge(datosSesion);
    }

    @Override
    public void removePersona(DatosSesion datosSesion) {
        em.merge(datosSesion);
        em.remove(datosSesion);
    }

    @Override
    public void validarSesion(DatosSesion datosSesion) {
        //String sql = "SELECT * FROM datos_sesion WHERE usuario = ? and contrasena = ?";
        //  (DatosSesion) em.createNamedQuery("DatosSesion.validarSession").getSingleResult(); 
      // em.createNamedQuery("DatosSesion.validarSesion").getSingleResult();
//o void o que retorne true o false
    //Si la query devuelve algun resultado. la sesion es buena, si no, no es buena.
    
    }

    @Override
    public boolean validarSesionBueno(DatosSesion datosSesion) {
        boolean estado = false;
        try {
            em.createNamedQuery("DatosSesion.validarSesion").getSingleResult();
            
        } catch (Exception e) {
            
            
        }
        return estado;
    }
    
    
    
    @Override
   public DatosSesion validarSesion1(String username, String password)
    {
        DatosSesion datosSesion;
        EntityManager em = emf.createEntityManager();
    String sql=    (String) em.createNamedQuery("DatosSesion.validarSesion").getSingleResult();
        //Query query = 
        Query query = em.createQuery(sql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return datosSesion;
   

    }

    @Override
    public boolean validarSesion2(DatosSesion datosSesion) {
        em.createNamedQuery("DatosSesion.validarSesion").getSingleResult();
        return false;
        
    }

}
