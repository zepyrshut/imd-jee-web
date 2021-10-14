/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitycontrol;

import com.arelance.domain.Paypal;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.arelance.domain.Usuario;
import entitycontrol.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author jorge
 */
public class PaypalJpaController implements Serializable {

    public PaypalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paypal paypal) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuarioid = paypal.getUsuario();
            if (usuarioid != null) {
                usuarioid = em.getReference(usuarioid.getClass(), usuarioid.getIdUsuario());
                paypal.setUsuario(usuarioid);
            }
            em.persist(paypal);
            if (usuarioid != null) {
                usuarioid.getMetodoPago().add(paypal);
                usuarioid = em.merge(usuarioid);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paypal paypal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paypal persistentPaypal = em.find(Paypal.class, paypal.getIdtp());
            Usuario usuarioidOld = persistentPaypal.getUsuario();
            Usuario usuarioidNew = paypal.getUsuario();
            if (usuarioidNew != null) {
                usuarioidNew = em.getReference(usuarioidNew.getClass(), usuarioidNew.getIdUsuario());
                paypal.setUsuario(usuarioidNew);
            }
            paypal = em.merge(paypal);
            if (usuarioidOld != null && !usuarioidOld.equals(usuarioidNew)) {
                usuarioidOld.getMetodoPago().remove(paypal);
                usuarioidOld = em.merge(usuarioidOld);
            }
            if (usuarioidNew != null && !usuarioidNew.equals(usuarioidOld)) {
                usuarioidNew.getMetodoPago().add(paypal);
                usuarioidNew = em.merge(usuarioidNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paypal.getIdtp();
                if (findPaypal(id) == null) {
                    throw new NonexistentEntityException("The paypal with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paypal paypal;
            try {
                paypal = em.getReference(Paypal.class, id);
                paypal.getIdtp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paypal with id " + id + " no longer exists.", enfe);
            }
            Usuario usuarioid = paypal.getUsuario();
            if (usuarioid != null) {
                usuarioid.getMetodoPago().remove(paypal);
                usuarioid = em.merge(usuarioid);
            }
            em.remove(paypal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paypal> findPaypalEntities() {
        return findPaypalEntities(true, -1, -1);
    }

    public List<Paypal> findPaypalEntities(int maxResults, int firstResult) {
        return findPaypalEntities(false, maxResults, firstResult);
    }

    private List<Paypal> findPaypalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paypal.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Paypal findPaypal(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paypal.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaypalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paypal> rt = cq.from(Paypal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
