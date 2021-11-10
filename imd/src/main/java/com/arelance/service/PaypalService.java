/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.service;

import com.arelance.domain.MetodoPago;
import com.arelance.domain.PayPal;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface PaypalService {
    public PayPal findPaypalByEmail(PayPal payPal);
      public PayPal findPaypalById(MetodoPago metodoPago);
}
