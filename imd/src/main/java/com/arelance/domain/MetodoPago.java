package com.arelance.domain;

import java.io.Serializable;
import java.util.Objects;
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
 * @author Jorge
 */
@Entity
@Table(name = "metodo_pago")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    protected Integer idMetodoPago;
    @Column(name = "nombre_pago")
    protected String nombrepago;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    protected Usuario usuario;

    public MetodoPago() {
    }

    public Integer getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Integer idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
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
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.idMetodoPago);
        hash = 31 * hash + Objects.hashCode(this.nombrepago);
        hash = 31 * hash + Objects.hashCode(this.usuario);
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
        if (!Objects.equals(this.idMetodoPago, other.idMetodoPago)) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }
    
}
