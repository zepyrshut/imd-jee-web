package com.arelance.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Pedro
 */
@Embeddable
public class UsuarioTieneActividadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_actividad")
    private int idActividad;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_paypal")
    private int idPaypal;
    
    
    
    public UsuarioTieneActividadPK() {
    }

    public UsuarioTieneActividadPK(int idUsuario, int idActividad) {
        this.idUsuario = idUsuario;
        this.idActividad = idActividad;
    }

    
    
    public UsuarioTieneActividadPK(int idUsuario, int idActividad, int idPaypal) {
        this.idUsuario = idUsuario;
        this.idActividad = idActividad;
        this.idPaypal = idPaypal;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getIdPaypal() {
        return idPaypal;
    }

    public void setIdPaypal(int idPaypal) {
        this.idPaypal = idPaypal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idUsuario;
        hash = 47 * hash + this.idActividad;
        hash = 47 * hash + this.idPaypal;
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
        final UsuarioTieneActividadPK other = (UsuarioTieneActividadPK) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idActividad != other.idActividad) {
            return false;
        }
        if (this.idPaypal != other.idPaypal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioTieneActividadPK{" + "idUsuario=" + idUsuario + ", idActividad=" + idActividad + ", idPaypal=" + idPaypal + '}';
    }
    
    
}
