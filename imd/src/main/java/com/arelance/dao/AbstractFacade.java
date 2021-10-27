package com.arelance.dao;

import com.arelance.service.factory.Crud;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Pedro
 * @param <T>
 */
public abstract class AbstractFacade<T> implements Crud {

    private final Class<T> entityClass;

    protected AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getEntityManager();

    @Override
    public void createEntity(Object entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void updateEntity(Object entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void deleteEntity(Object entity) {
         getEntityManager().merge(entity);
        getEntityManager().remove(entity);
    }

    @Override
    public Object readEntity(Integer numberId) {
        return getEntityManager().find(entityClass, numberId);
    }

    @Override
    public List<T> readAllEntity() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();    
    }

    @Override
    public Object refreshEntity(Object entity) {
        getEntityManager().refresh(getEntityManager().merge(entity));
        return entity;
    }
}
