/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jorge
 */
@Entity
@Table(name="tarjeta")
public class Tarjeta extends MetodoPago{

    private static final long serialVersionUID = 1L;
   
    @Column(name = "numero")
    private String numero;
    
    @Column(name = "cvv")
    private String cvv;
//    
//    @Column(name = "caducidad")
//@Temporal(TemporalType.DATE)
//private java.util.Date caducidad;

//    public Tarjeta(String numero, String cvv, Date caducidad) {
//        this.numero = numero;
//        this.cvv = cvv;
//        this.caducidad = caducidad;
//    }

    public Tarjeta(String numero, String cvv, Integer idtp, String nombrepago, Usuario usuarioid) {
        super(idtp, nombrepago, usuarioid);
        this.numero = numero;
        this.cvv = cvv;
    }

    public Tarjeta(String numero, String cvv) {
        this.numero = numero;
        this.cvv = cvv;
    }

    
    
    
    public Tarjeta() {
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
//
//    public Date getCaducidad() {
//        return caducidad;
//    }
//
//    public void setCaducidad(Date caducidad) {
//        this.caducidad = caducidad;
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.numero);
        hash = 29 * hash + Objects.hashCode(this.cvv);
//        hash = 29 * hash + Objects.hashCode(this.caducidad);
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
        final Tarjeta other = (Tarjeta) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.cvv, other.cvv)) {
            return false;
        }
//        if (!Objects.equals(this.caducidad, other.caducidad)) {
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "numero=" + numero + ", cvv=" + cvv + '}';
    }


    
}
