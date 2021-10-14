/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "transferencia")
public class Transferencia extends MetodoPago{

    private static final long serialVersionUID = 1L;
  
    
    @Column(name = "iban")
    private String iban;
     
    

    

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }



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
        if (!Objects.equals(this.iban, other.iban)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "iban=" + iban + '}';
    }

    
}
