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
    @Column(name = "id_pago")
    private int idPago;
    
    
    

    public UsuarioTieneActividadPK() {
    }

    public UsuarioTieneActividadPK(int idUsuario, int idActividad, int idPago) {
        this.idUsuario = idUsuario;
        this.idActividad = idActividad;
        this.idPago = idPago;
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

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.idUsuario;
        hash = 31 * hash + this.idActividad;
        hash = 31 * hash + this.idPago;
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
        if (this.idPago != other.idPago) {
            return false;
        }
        return true;
    }

    
    
}