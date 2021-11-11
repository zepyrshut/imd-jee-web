package com.arelance.dao;

import com.arelance.domain.MetodoPago;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
public interface PaymentMethodDAO {

    public void addPaymentMethod(MetodoPago paymentMethod);

    public void updatePaymentMethod(MetodoPago paymentMethod);

    public void removePaymentMethod(MetodoPago paymentMethod);

    public MetodoPago refreshPaymentMethod(MetodoPago paymentMethod);

}
