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
@Table(name = "debit_card")
public class DebitCard extends PaymentMethod implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "number")
    private String number;

    @Column(name = "cvv")
    private String cvv;

    public DebitCard() {
        super();
    }

    public DebitCard(String number, String cvv, String paymentName) {
        super(paymentName);
        this.number = number;
        this.cvv = cvv;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getNombrePago() {
        return getNombrePago();
    }

    public void setNombrePago(String nombrePago) {
        this.setNombrePago(nombrePago);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.number);
        hash = 17 * hash + Objects.hashCode(this.cvv);
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
        final DebitCard other = (DebitCard) obj;
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        return Objects.equals(this.cvv, other.cvv);
    }

}
