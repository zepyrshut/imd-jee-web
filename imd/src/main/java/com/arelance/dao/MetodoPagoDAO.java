/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.dao;

import com.arelance.domain.MetodoPago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface MetodoPagoDAO {
     public List<MetodoPago> listarMetodosPagos();
     public void addMetodo(MetodoPago metodoPago);
     
     
}
