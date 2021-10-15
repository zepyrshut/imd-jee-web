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
@Table(name = "transferencia")
public class Transferencia extends MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "iban")
    private String iban;

    public Transferencia() {
        super();
    }

    public Transferencia(String iban) {
        super();
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.iban);
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
        final Transferencia other = (Transferencia) obj;
        return Objects.equals(this.iban, other.iban);
    }
    
}
