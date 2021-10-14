/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author jorge
 */
@Entity
@Table(name="paypal")
public class Paypal extends MetodoPago{

    private static final long serialVersionUID = 1L;
  
    
    @Column(name = "correo")
    private String correo;

    public Paypal() {
    }

    public Paypal(String correo, Integer idtp, String nombrepago, Usuario usuarioid) {
        super(idtp, nombrepago, usuarioid);
        this.correo = correo;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Paypal(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.correo);
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
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Paypal{" + "correo=" + correo + '}';
    }
    
    
    
   
    
}
