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
<<<<<<< HEAD
public class Transferencia extends MetodoPago implements Serializable {
=======
public class Transferencia extends MetodoPago {
>>>>>>> c7c0f92aa72d4af614b8c10b7ea8e3e1450455d5

    private static final long serialVersionUID = 1L;

    @Column(name = "iban")
    private String iban;
<<<<<<< HEAD

    public Transferencia() {
        super();
    }

    public Transferencia(String iban) {
        super();
        this.iban = iban;
    }
=======
>>>>>>> c7c0f92aa72d4af614b8c10b7ea8e3e1450455d5

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

<<<<<<< HEAD
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.iban);
=======
    public Transferencia(String iban) {
        this.iban = iban;
    }

    public Transferencia(String iban, Integer idtp, String nombrepago, Usuario usuarioid) {
        super(idtp, nombrepago, usuarioid);
        this.iban = iban;
    }

    public Transferencia() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.iban);
>>>>>>> c7c0f92aa72d4af614b8c10b7ea8e3e1450455d5
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
<<<<<<< HEAD
            return false;
        }
        final Transferencia other = (Transferencia) obj;
        return Objects.equals(this.iban, other.iban);
=======
            return false;
        }
        final Transferencia other = (Transferencia) obj;
        if (!Objects.equals(this.iban, other.iban)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "iban=" + iban + '}';
>>>>>>> c7c0f92aa72d4af614b8c10b7ea8e3e1450455d5
    }

}
