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
public class Paypal extends MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "correo")
    private String correoPayPal;

    public Paypal() {
        super();
    }

    public Paypal(String correoPayPal) {
        super();
        this.correoPayPal = correoPayPal;
    }

    public String getCorreoPayPal() {
        return correoPayPal;
    }

    public void setCorreoPayPal(String correoPayPal) {
        this.correoPayPal = correoPayPal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.correoPayPal);
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
        final Paypal other = (Paypal) obj;
        if (!Objects.equals(this.correoPayPal, other.correoPayPal)) {
            return false;
        }
        return true;
    }    
    
}
