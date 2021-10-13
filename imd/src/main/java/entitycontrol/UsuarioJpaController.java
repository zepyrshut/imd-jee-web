/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitycontrol;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.arelance.domain.DatosSesion;
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
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DatosSesion datosSesion = usuario.getDatosSesion();
            if (datosSesion != null) {
                datosSesion = em.getReference(datosSesion.getClass(), datosSesion.getIdDatosSesion());
                usuario.setDatosSesion(datosSesion);
            }
            em.persist(usuario);
            if (datosSesion != null) {
                Usuario oldUsuarioSocioOfDatosSesion = datosSesion.getUsuarioSocio();
                if (oldUsuarioSocioOfDatosSesion != null) {
                    oldUsuarioSocioOfDatosSesion.setDatosSesion(null);
                    oldUsuarioSocioOfDatosSesion = em.merge(oldUsuarioSocioOfDatosSesion);
                }
                datosSesion.setUsuarioSocio(usuario);
                datosSesion = em.merge(datosSesion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdUsuario());
            DatosSesion datosSesionOld = persistentUsuario.getDatosSesion();
            DatosSesion datosSesionNew = usuario.getDatosSesion();
            List<String> illegalOrphanMessages = null;
            if (datosSesionOld != null && !datosSesionOld.equals(datosSesionNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain DatosSesion " + datosSesionOld + " since its usuarioSocio field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (datosSesionNew != null) {
                datosSesionNew = em.getReference(datosSesionNew.getClass(), datosSesionNew.getIdDatosSesion());
                usuario.setDatosSesion(datosSesionNew);
            }
            usuario = em.merge(usuario);
            if (datosSesionNew != null && !datosSesionNew.equals(datosSesionOld)) {
                Usuario oldUsuarioSocioOfDatosSesion = datosSesionNew.getUsuarioSocio();
                if (oldUsuarioSocioOfDatosSesion != null) {
                    oldUsuarioSocioOfDatosSesion.setDatosSesion(null);
                    oldUsuarioSocioOfDatosSesion = em.merge(oldUsuarioSocioOfDatosSesion);
                }
                datosSesionNew.setUsuarioSocio(usuario);
                datosSesionNew = em.merge(datosSesionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getIdUsuario();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            DatosSesion datosSesionOrphanCheck = usuario.getDatosSesion();
            if (datosSesionOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the DatosSesion " + datosSesionOrphanCheck + " in its datosSesion field has a non-nullable usuarioSocio field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
