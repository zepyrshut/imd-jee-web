/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.dao.impl;

import com.arelance.dao.MetodoPagoDAO;
import com.arelance.domain.MetodoPago;
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
//        switch (metodoPago.g) {
//
//            case valor1:
//
//                break;
//
//            case valor2:
//
//                break;
//
//            default:
//            // Declaraciones
//        }
//    }

    @Override
    public List<MetodoPago> listarMetodosPagos() {
        return em.createNamedQuery("MetodoPago.findAll").getResultList();
    }

    @Override
    public void addMetodo(MetodoPago metodoPago) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
