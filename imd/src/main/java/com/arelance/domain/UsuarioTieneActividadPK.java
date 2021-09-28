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

    public UsuarioTieneActividadPK() {
    }

    public UsuarioTieneActividadPK(int idUsuario, int idActividad) {
        this.idUsuario = idUsuario;
        this.idActividad = idActividad;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (int) idActividad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UsuarioTieneActividadPK)) {
            return false;
        }
        UsuarioTieneActividadPK other = (UsuarioTieneActividadPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idActividad != other.idActividad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.domain.UsuarioTieneActividadPK[ idUsuario=" + idUsuario + ", idActividad=" + idActividad + " ]";
    }
    
}
