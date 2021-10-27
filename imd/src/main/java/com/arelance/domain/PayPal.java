package com.arelance.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "paypal")
public class PayPal extends PaymentMethod implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "email")
    private String payPalEmail;

    public PayPal() {
        super();
    }

    public PayPal(String payPalEmail, String paymentName) {
        super(paymentName);
        this.payPalEmail = payPalEmail;
    }

    public String getPayPalEmail() {
        return payPalEmail;
    }

    public void setPayPalEmail(String payPalEmail) {
        this.payPalEmail = payPalEmail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.payPalEmail);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PayPal other = (PayPal) obj;
        return Objects.equals(this.payPalEmail, other.payPalEmail);
    }

}
