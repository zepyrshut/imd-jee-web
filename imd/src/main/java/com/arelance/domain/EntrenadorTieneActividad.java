package com.arelance.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "entrenador_tiene_actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntrenadorTieneActividad.findAll", query = "SELECT e FROM EntrenadorTieneActividad e"),
    @NamedQuery(name = "EntrenadorTieneActividad.findByIdEntrenador", query = "SELECT e FROM EntrenadorTieneActividad e WHERE e.entrenadorTieneActividadPK.idEntrenador = :idEntrenador"),
    @NamedQuery(name = "EntrenadorTieneActividad.findByIdActividad", query = "SELECT e FROM EntrenadorTieneActividad e WHERE e.entrenadorTieneActividadPK.idActividad = :idActividad")})
public class EntrenadorTieneActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EntrenadorTieneActividadPK entrenadorTieneActividadPK;
    @JoinColumns({
        @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad", insertable = false, updatable = false),
        @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Activity actividad;
    @JoinColumn(name = "id_entrenador", referencedColumnName = "id_entrenador", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Trainer entrenador;

    public EntrenadorTieneActividad() {
    }

    public EntrenadorTieneActividad(EntrenadorTieneActividadPK entrenadorTieneActividadPK) {
        this.entrenadorTieneActividadPK = entrenadorTieneActividadPK;
    }

    public EntrenadorTieneActividad(int idEntrenador, int idActividad) {
        this.entrenadorTieneActividadPK = new EntrenadorTieneActividadPK(idEntrenador, idActividad);
    }

    public EntrenadorTieneActividadPK getEntrenadorTieneActividadPK() {
        return entrenadorTieneActividadPK;
    }

    public void setEntrenadorTieneActividadPK(EntrenadorTieneActividadPK entrenadorTieneActividadPK) {
        this.entrenadorTieneActividadPK = entrenadorTieneActividadPK;
    }

    public Activity getActividad() {
        return actividad;
    }

    public void setActividad(Activity actividad) {
        this.actividad = actividad;
    }

    public Trainer getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Trainer entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entrenadorTieneActividadPK != null ? entrenadorTieneActividadPK.hashCode() : 0);
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
        final EntrenadorTieneActividad other = (EntrenadorTieneActividad) obj;
        if (!Objects.equals(this.entrenadorTieneActividadPK, other.entrenadorTieneActividadPK)) {
            return false;
        }
        if (!Objects.equals(this.actividad, other.actividad)) {
            return false;
        }
        if (!Objects.equals(this.entrenador, other.entrenador)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.domain.EntrenadorTieneActividad[ entrenadorTieneActividadPK=" + entrenadorTieneActividadPK + " ]";
    }

}
