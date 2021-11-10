/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.dao;

import com.arelance.domain.MetodoPago;
import com.arelance.domain.PayPal;

/**
 *
 * @author jorge
 */
public interface PaypalDAO {
    public PayPal findPaypalByEmail(PayPal payPal);
    public PayPal findPaypalById(MetodoPago metodoPago);
}
