/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jorge
 */


@Entity
@Table(name = "metodo_pago")
@Inheritance(strategy = InheritanceType.JOINED)
public class MetodoPago  implements  Serializable{
       private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Integer idtp;
    
    @Column(name = "nombre_pago")
    private String nombrepago;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public MetodoPago() {
    }

    public MetodoPago(Integer idtp, String nombrepago, Usuario usuarioid) {
        this.idtp = idtp;
        this.nombrepago = nombrepago;
        this.usuario = usuarioid;
    }

    public Integer getIdtp() {
        return idtp;
    }

    public void setIdtp(Integer idtp) {
        this.idtp = idtp;
    }

    public String getNombrepago() {
        return nombrepago;
    }

    public void setNombrepago(String nombrepago) {
        this.nombrepago = nombrepago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.idtp);
        hash = 17 * hash + Objects.hashCode(this.nombrepago);
        hash = 17 * hash + Objects.hashCode(this.usuario);
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
        final MetodoPago other = (MetodoPago) obj;
        if (!Objects.equals(this.nombrepago, other.nombrepago)) {
            return false;
        }
        if (!Objects.equals(this.idtp, other.idtp)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MetodoPago{" + "idtp=" + idtp + ", nombrepago=" + nombrepago + ", usuarioid=" + usuario + '}';
    }
    
    
    
    
    
    
    
}
