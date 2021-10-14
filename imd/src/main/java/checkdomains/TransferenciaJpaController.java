/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkdomains;

import checkdomains.exceptions.NonexistentEntityException;
import com.arelance.domain.Transferencia;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.arelance.domain.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author jorge
 */
public class TransferenciaJpaController implements Serializable {

    public TransferenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Transferencia transferencia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario = transferencia.getUsuario();
            if (usuario != null) {
                usuario = em.getReference(usuario.getClass(), usuario.getIdUsuario());
                transferencia.setUsuario(usuario);
            }
            em.persist(transferencia);
            if (usuario != null) {
                usuario.getMetodoPago().add(transferencia);
                usuario = em.merge(usuario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Transferencia transferencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transferencia persistentTransferencia = em.find(Transferencia.class, transferencia.getIdtp());
            Usuario usuarioOld = persistentTransferencia.getUsuario();
            Usuario usuarioNew = transferencia.getUsuario();
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getIdUsuario());
                transferencia.setUsuario(usuarioNew);
            }
            transferencia = em.merge(transferencia);
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.getMetodoPago().remove(transferencia);
                usuarioOld = em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                usuarioNew.getMetodoPago().add(transferencia);
                usuarioNew = em.merge(usuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = transferencia.getIdtp();
                if (findTransferencia(id) == null) {
                    throw new NonexistentEntityException("The transferencia with id " + id + " no longer exists.");
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
            Transferencia transferencia;
            try {
                transferencia = em.getReference(Transferencia.class, id);
                transferencia.getIdtp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transferencia with id " + id + " no longer exists.", enfe);
            }
            Usuario usuario = transferencia.getUsuario();
            if (usuario != null) {
                usuario.getMetodoPago().remove(transferencia);
                usuario = em.merge(usuario);
            }
            em.remove(transferencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Transferencia> findTransferenciaEntities() {
        return findTransferenciaEntities(true, -1, -1);
    }

    public List<Transferencia> findTransferenciaEntities(int maxResults, int firstResult) {
        return findTransferenciaEntities(false, maxResults, firstResult);
    }

    private List<Transferencia> findTransferenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Transferencia.class));
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

    public Transferencia findTransferencia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Transferencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransferenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Transferencia> rt = cq.from(Transferencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
