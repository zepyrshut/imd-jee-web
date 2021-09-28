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
public class EntrenadorTieneActividadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_entrenador")
    private int idEntrenador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_actividad")
    private int idActividad;

    public EntrenadorTieneActividadPK() {
    }

    public EntrenadorTieneActividadPK(int idEntrenador, int idActividad) {
        this.idEntrenador = idEntrenador;
        this.idActividad = idActividad;
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
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
        hash += (int) idEntrenador;
        hash += (int) idActividad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntrenadorTieneActividadPK)) {
            return false;
        }
        EntrenadorTieneActividadPK other = (EntrenadorTieneActividadPK) object;
        if (this.idEntrenador != other.idEntrenador) {
            return false;
        }
        if (this.idActividad != other.idActividad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.domain.EntrenadorTieneActividadPK[ idEntrenador=" + idEntrenador + ", idActividad=" + idActividad + " ]";
    }
    
}
