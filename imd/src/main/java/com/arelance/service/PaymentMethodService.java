package com.arelance.service;

import com.arelance.domain.MetodoPago;

/**
 *
 * @author Pedro
 */
public interface PaymentMethodService {

    public void addPaymentMethod(MetodoPago paymentMethod);

    public void updatePaymentMethod(MetodoPago paymentMethod);

    public void removePaymentMethod(MetodoPago paymentMethod);

    public MetodoPago refreshPaymentMethod(MetodoPago paymentMethod);

}
