package com.arelance.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findByIdActividad", query = "SELECT a FROM Actividad a WHERE a.idActividad = :idActividad"),
    @NamedQuery(name = "Actividad.findByNombreActividad", query = "SELECT a FROM Actividad a WHERE a.nombreActividad = :nombreActividad"),
    @NamedQuery(name = "Actividad.findByDescripcionActividad", query = "SELECT a FROM Actividad a WHERE a.descripcionActividad = :descripcionActividad"),
    @NamedQuery(name = "Actividad.findByCategoriaActividad", query = "SELECT a FROM Actividad a WHERE a.categoriaActividad = :categoriaActividad"),
    @NamedQuery(name = "Actividad.findByPrecioActividad", query = "SELECT a FROM Actividad a WHERE a.precioActividad = :precioActividad")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_actividad")
    private Integer idActividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_actividad")
    private String nombreActividad;
    @Size(max = 255)
    @Column(name = "descripcion_actividad")
    private String descripcionActividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "categoria_actividad")
    private String categoriaActividad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_actividad")
    private BigDecimal precioActividad;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "actividad")
    private EntrenadorTieneActividad entrenadorTieneActividad;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "actividad")
    private UsuarioTieneActividad usuarioTieneActividad;

    
    
    public Actividad() {
    }

    public Actividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Actividad(Integer idActividad, String nombreActividad, String categoriaActividad, BigDecimal precioActividad) {
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.categoriaActividad = categoriaActividad;
        this.precioActividad = precioActividad;
    }

    public Actividad(Integer idActividad, String nombreActividad, String descripcionActividad, String categoriaActividad, BigDecimal precioActividad, EntrenadorTieneActividad entrenadorTieneActividad, UsuarioTieneActividad usuarioTieneActividad) {
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.descripcionActividad = descripcionActividad;
        this.categoriaActividad = categoriaActividad;
        this.precioActividad = precioActividad;
        this.entrenadorTieneActividad = entrenadorTieneActividad;
        this.usuarioTieneActividad = usuarioTieneActividad;
    }


    
    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public String getCategoriaActividad() {
        return categoriaActividad;
    }

    public void setCategoriaActividad(String categoriaActividad) {
        this.categoriaActividad = categoriaActividad;
    }

    public BigDecimal getPrecioActividad() {
        return precioActividad;
    }

    public void setPrecioActividad(BigDecimal precioActividad) {
        this.precioActividad = precioActividad;
    }

    public EntrenadorTieneActividad getEntrenadorTieneActividad() {
        return entrenadorTieneActividad;
    }

    public void setEntrenadorTieneActividad(EntrenadorTieneActividad entrenadorTieneActividad) {
        this.entrenadorTieneActividad = entrenadorTieneActividad;
    }

    public UsuarioTieneActividad getUsuarioTieneActividad() {
        return usuarioTieneActividad;
    }

    public void setUsuarioTieneActividad(UsuarioTieneActividad usuarioTieneActividad) {
        this.usuarioTieneActividad = usuarioTieneActividad;
    }


    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividad != null ? idActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.idActividad == null && other.idActividad != null) || (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.domain.Actividad[ idActividad=" + idActividad + " ]";
    }
    
}
