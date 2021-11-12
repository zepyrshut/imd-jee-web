package com.arelance.dao.impl;

import com.arelance.dao.PaymentMethodDAO;
import com.arelance.domain.MetodoPago;
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
public class PaymentMethodImpl implements PaymentMethodDAO {

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    public void addPaymentMethod(MetodoPago paymentMethod) {
        em.persist(paymentMethod);
    }

    @Override
    public void updatePaymentMethod(MetodoPago paymentMethod) {
        em.merge(paymentMethod);
    }

    @Override
    public void removePaymentMethod(MetodoPago paymentMethod) {
        em.merge(paymentMethod);
        em.remove(paymentMethod);
    }

    @Override
    public MetodoPago refreshPaymentMethod(MetodoPago paymentMethod) {
        em.refresh(paymentMethod);
        return paymentMethod;
    }

    @Override
    public MetodoPago findMethodByDescription(String description) {
        Query query = em.createNamedQuery("MetodoPago.findByDescription");
        query.setParameter("nombrePago", description);
        try {
            return (MetodoPago) query.getSingleResult();
        } catch (NoResultException e) {
            e.getMessage();
            return null;
        }
    }

}
