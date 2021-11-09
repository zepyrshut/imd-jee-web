/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.service;

import com.arelance.domain.MetodoPago;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface MetodoPagoService {
        public List<MetodoPago> listarMetodosPagos();
     public void addMetodo(MetodoPago metodoPago);
}
