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
@Table(name = "tarjeta")
public class DebitCard extends PaymentMethod implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "numero")
    private String numero;

    @Column(name = "cvv")
    private String cvv;

    public DebitCard() {
super();
    }
    
    

    public DebitCard(String numero, String cvv, String nombrePago) {
        super(nombrePago);
        this.numero = numero;
        this.cvv = cvv;
    }   

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.numero);
        hash = 67 * hash + Objects.hashCode(this.cvv);
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
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return Objects.equals(this.cvv, other.cvv);
    }

}
