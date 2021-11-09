/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.dao.impl;

import com.arelance.dao.MetodoPagoDAO;
import com.arelance.domain.MetodoPago;
import com.arelance.domain.PayPal;
import com.arelance.domain.Tarjeta;
import com.arelance.domain.Transferencia;
import com.arelance.domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jorge
 */
@Stateless
public class MetodoPagoDAOImpl implements MetodoPagoDAO {

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;
//actions?action=paymentmethod&metodopago=paypal
//    @Override
//    public void addMetodo(MetodoPago metodoPago) {
//        em.persist(metodoPago);

//    }

    @Override
    public List<MetodoPago> listarMetodosPagos() {
        return em.createNamedQuery("MetodoPago.findAll").getResultList();
    }

    @Override
    public void addMetodo(MetodoPago metodoPago) {
        em.persist(metodoPago);
    }

    @Override
    public void addMetodo(PayPal paypal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addMetodo(Tarjeta tarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addMetodo(Transferencia transferencia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PayPal> findPayPalsByUser(Usuario usuario) {
        return null;
        
    }

}
