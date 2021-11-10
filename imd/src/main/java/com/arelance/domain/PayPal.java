package com.arelance.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "paypal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findById", query = "SELECT p FROM PayPal p WHERE p.idMetodoPago  = :idMetodoPago"),
    @NamedQuery(name = "Paypal.findByEmail", query = "SELECT p FROM PayPal p WHERE p.correoPayPal  = :correoPayPal")})
public class PayPal extends MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "correo")
    private String correoPayPal;

    public PayPal() {
       super();
    }      

    public PayPal(String correoPayPal, String nombrePago) {
        super(nombrePago);
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
        final PayPal other = (PayPal) obj;
        return Objects.equals(this.correoPayPal, other.correoPayPal);
    }

}
