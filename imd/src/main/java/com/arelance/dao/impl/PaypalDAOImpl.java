/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.dao.impl;

import com.arelance.dao.PaypalDAO;
import com.arelance.domain.MetodoPago;
import com.arelance.domain.PayPal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jorge
 */
@Stateless
public class PaypalDAOImpl implements PaypalDAO{
    @PersistenceContext(unitName = "imdPU")
    EntityManager em;
    
    @Override
    public PayPal findPaypalByEmail(PayPal payPal) {
         Query query = em.createNamedQuery("Paypal.findByEmail");
        query.setParameter("correoPayPal", payPal.getCorreoPayPal());
        try {
            return (PayPal) query.getSingleResult();
        } catch (NoResultException e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public PayPal findPaypalById(MetodoPago metodoPago) {
               Query query = em.createNamedQuery("Paypal.findByEmail");
        query.setParameter("idMetodoPago", metodoPago.getIdMetodoPago());
        try {
            return (PayPal) query.getSingleResult();
        } catch (NoResultException e) {
            e.getMessage();
            return null;
        }
    }
    
}
