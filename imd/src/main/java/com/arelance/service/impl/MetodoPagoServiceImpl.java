/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.service.impl;

import com.arelance.dao.MetodoPagoDAO;
import com.arelance.domain.MetodoPago;
import com.arelance.service.MetodoPagoService;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jorge
 */
public class MetodoPagoServiceImpl implements MetodoPagoService {

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Inject
    MetodoPagoDAO metodoPagoDAO;

    @Override
    public List<MetodoPago> listarMetodosPagos() {
        return metodoPagoDAO.listarMetodosPagos();
    }

    @Override
    public void addMetodo(MetodoPago metodoPago) {
       metodoPagoDAO.addMetodo(metodoPago);
    }

}
