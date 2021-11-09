/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.dao;

import com.arelance.domain.MetodoPago;
import com.arelance.domain.PayPal;
import com.arelance.domain.Tarjeta;
import com.arelance.domain.Transferencia;
import com.arelance.domain.Usuario;
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
     public void addMetodo(PayPal paypal);
     public void addMetodo(Tarjeta tarjeta);
     public void addMetodo(Transferencia transferencia);
     public List<PayPal> findPayPalsByUser(Usuario usuario);
     
     
}
