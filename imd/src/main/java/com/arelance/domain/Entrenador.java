package com.arelance.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "entrenador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrenador.findAll", query = "SELECT e FROM Entrenador e"),
    @NamedQuery(name = "Entrenador.findByIdEntrenador", query = "SELECT e FROM Entrenador e WHERE e.idEntrenador = :idEntrenador"),
    @NamedQuery(name = "Entrenador.findByNombre", query = "SELECT e FROM Entrenador e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Entrenador.findByApellido", query = "SELECT e FROM Entrenador e WHERE e.apellido = :apellido")})
public class Entrenador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entrenador")
    private Integer idEntrenador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 20)
    @Column(name = "apellido")
    private String apellido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entrenador")
    private Collection<EntrenadorTieneActividad> entrenadorTieneActividadCollection;

    public Entrenador() {
    }

    public Entrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public Entrenador(Integer idEntrenador, String nombre) {
        this.idEntrenador = idEntrenador;
        this.nombre = nombre;
    }

    public Integer getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @XmlTransient
    public Collection<EntrenadorTieneActividad> getEntrenadorTieneActividadCollection() {
        return entrenadorTieneActividadCollection;
    }

    public void setEntrenadorTieneActividadCollection(Collection<EntrenadorTieneActividad> entrenadorTieneActividadCollection) {
        this.entrenadorTieneActividadCollection = entrenadorTieneActividadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrenador != null ? idEntrenador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrenador)) {
            return false;
        }
        Entrenador other = (Entrenador) object;
        if ((this.idEntrenador == null && other.idEntrenador != null) || (this.idEntrenador != null && !this.idEntrenador.equals(other.idEntrenador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.domain.Entrenador[ idEntrenador=" + idEntrenador + " ]";
    }
    
}
