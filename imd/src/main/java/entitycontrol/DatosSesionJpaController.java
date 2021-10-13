/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitycontrol;

import com.arelance.domain.DatosSesion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.arelance.domain.Usuario;
import entitycontrol.exceptions.IllegalOrphanException;
import entitycontrol.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author jorge
 */
public class DatosSesionJpaController implements Serializable {

    public DatosSesionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DatosSesion datosSesion) throws IllegalOrphanException {
        List<String> illegalOrphanMessages = null;
        Usuario usuarioSocioOrphanCheck = datosSesion.getUsuarioSocio();
        if (usuarioSocioOrphanCheck != null) {
            DatosSesion oldDatosSesionOfUsuarioSocio = usuarioSocioOrphanCheck.getDatosSesion();
            if (oldDatosSesionOfUsuarioSocio != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Usuario " + usuarioSocioOrphanCheck + " already has an item of type DatosSesion whose usuarioSocio column cannot be null. Please make another selection for the usuarioSocio field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuarioSocio = datosSesion.getUsuarioSocio();
            if (usuarioSocio != null) {
                usuarioSocio = em.getReference(usuarioSocio.getClass(), usuarioSocio.getIdUsuario());
                datosSesion.setUsuarioSocio(usuarioSocio);
            }
            em.persist(datosSesion);
            if (usuarioSocio != null) {
                usuarioSocio.setDatosSesion(datosSesion);
                usuarioSocio = em.merge(usuarioSocio);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DatosSesion datosSesion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DatosSesion persistentDatosSesion = em.find(DatosSesion.class, datosSesion.getIdDatosSesion());
            Usuario usuarioSocioOld = persistentDatosSesion.getUsuarioSocio();
            Usuario usuarioSocioNew = datosSesion.getUsuarioSocio();
            List<String> illegalOrphanMessages = null;
            if (usuarioSocioNew != null && !usuarioSocioNew.equals(usuarioSocioOld)) {
                DatosSesion oldDatosSesionOfUsuarioSocio = usuarioSocioNew.getDatosSesion();
                if (oldDatosSesionOfUsuarioSocio != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Usuario " + usuarioSocioNew + " already has an item of type DatosSesion whose usuarioSocio column cannot be null. Please make another selection for the usuarioSocio field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (usuarioSocioNew != null) {
                usuarioSocioNew = em.getReference(usuarioSocioNew.getClass(), usuarioSocioNew.getIdUsuario());
                datosSesion.setUsuarioSocio(usuarioSocioNew);
            }
            datosSesion = em.merge(datosSesion);
            if (usuarioSocioOld != null && !usuarioSocioOld.equals(usuarioSocioNew)) {
                usuarioSocioOld.setDatosSesion(null);
                usuarioSocioOld = em.merge(usuarioSocioOld);
            }
            if (usuarioSocioNew != null && !usuarioSocioNew.equals(usuarioSocioOld)) {
                usuarioSocioNew.setDatosSesion(datosSesion);
                usuarioSocioNew = em.merge(usuarioSocioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = datosSesion.getIdDatosSesion();
                if (findDatosSesion(id) == null) {
                    throw new NonexistentEntityException("The datosSesion with id " + id + " no longer exists.");
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
            DatosSesion datosSesion;
            try {
                datosSesion = em.getReference(DatosSesion.class, id);
                datosSesion.getIdDatosSesion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The datosSesion with id " + id + " no longer exists.", enfe);
            }
            Usuario usuarioSocio = datosSesion.getUsuarioSocio();
            if (usuarioSocio != null) {
                usuarioSocio.setDatosSesion(null);
                usuarioSocio = em.merge(usuarioSocio);
            }
            em.remove(datosSesion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DatosSesion> findDatosSesionEntities() {
        return findDatosSesionEntities(true, -1, -1);
    }

    public List<DatosSesion> findDatosSesionEntities(int maxResults, int firstResult) {
        return findDatosSesionEntities(false, maxResults, firstResult);
    }

    private List<DatosSesion> findDatosSesionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DatosSesion.class));
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

    public DatosSesion findDatosSesion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DatosSesion.class, id);
        } finally {
            em.close();
        }
    }

    public int getDatosSesionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DatosSesion> rt = cq.from(DatosSesion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
