package com.arelance.dao.facade;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Pedro
 * @param <T>
 */
public abstract class AbstractFacade<T> {

    private final Class<T> entityClass;

    protected AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void createEntity(T entity) {
        getEntityManager().persist(entity);
    }

    public void updateEntity(T entity) {
        getEntityManager().merge(entity);
    }

    public void deleteEntity(T entity) {
        getEntityManager().merge(entity);
        getEntityManager().remove(entity);
    }

    public T readEntity(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> readAllEntity() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public T refreshEntity(T entity) {
        getEntityManager().refresh(getEntityManager().merge(entity));
        return entity;
    }
    
}
