package com.arelance.service.impl;

import com.arelance.dao.PaymentMethodDAO;
import com.arelance.domain.MetodoPago;
import com.arelance.service.PaymentMethodService;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Inject
    private PaymentMethodDAO paymentMethodDAO;

    @Override
    public void addPaymentMethod(MetodoPago paymentMethod) {
        paymentMethodDAO.addPaymentMethod(paymentMethod);
    }

    @Override
    public void updatePaymentMethod(MetodoPago paymentMethod) {
        paymentMethodDAO.updatePaymentMethod(paymentMethod);
    }

    @Override
    public void removePaymentMethod(MetodoPago paymentMethod) {
        paymentMethodDAO.removePaymentMethod(paymentMethod);
    }

    @Override
    public MetodoPago refreshPaymentMethod(MetodoPago paymentMethod) {
        return paymentMethodDAO.refreshPaymentMethod(paymentMethod);
    }

    @Override
    public MetodoPago findMethodByDescription(String description) {
       return paymentMethodDAO.findMethodByDescription(description);
    }
    
}
