/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.service.impl;

import com.arelance.dao.PaypalDAO;
import com.arelance.domain.MetodoPago;
import com.arelance.domain.PayPal;
import com.arelance.service.PaypalService;
import javax.inject.Inject;

/**
 *
 * @author jorge
 */

public class PaypalServiceImpl implements PaypalService{
     @Inject
     private PaypalDAO paypalDAO;
     
    @Override
    public PayPal findPaypalByEmail(PayPal payPal) {
        return paypalDAO.findPaypalByEmail(payPal);
    }

    @Override
    public PayPal findPaypalById(MetodoPago metodoPago) {
        return paypalDAO.findPaypalById(metodoPago);
    }
    
}
