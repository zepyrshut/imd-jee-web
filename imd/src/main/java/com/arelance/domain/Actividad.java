package com.arelance.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "actividad")
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findByIdActividad", query = "SELECT a FROM Actividad a WHERE a.idActividad = :idActividad")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Integer idActividad;
    @Column(name = "nombre_actividad")
    private String nombreActividad;
    @Column(name = "descripcion_actividad")
    private String descripcionActividad;
    @Column(name = "categoria_actividad")
    private String categoriaActividad;
    @Column(name = "precio_actividad")
    private Double precioActividad;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "actividad")
    private EntrenadorTieneActividad entrenadorTieneActividad;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuario_tiene_actividad",
            joinColumns = {
                @JoinColumn(name = "id_actividad")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_usuario")}
    )
    private List<Usuario> listaUsuarios = new ArrayList<>();

    public Actividad() {
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

    public Double getPrecioActividad() {
        return precioActividad;
    }

    public void setPrecioActividad(Double precioActividad) {
        this.precioActividad = precioActividad;
    }

    public EntrenadorTieneActividad getEntrenadorTieneActividad() {
        return entrenadorTieneActividad;
    }

    public void setEntrenadorTieneActividad(EntrenadorTieneActividad entrenadorTieneActividad) {
        this.entrenadorTieneActividad = entrenadorTieneActividad;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void eliminarUsuario(Usuario usuario) {
        listaUsuarios.remove(usuario);
        usuario.getActividadesUsuario().remove(this);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idActividad);
        hash = 97 * hash + Objects.hashCode(this.nombreActividad);
        hash = 97 * hash + Objects.hashCode(this.descripcionActividad);
        hash = 97 * hash + Objects.hashCode(this.categoriaActividad);
        hash = 97 * hash + Objects.hashCode(this.precioActividad);
        hash = 97 * hash + Objects.hashCode(this.entrenadorTieneActividad);
        hash = 97 * hash + Objects.hashCode(this.listaUsuarios);
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
        final Actividad other = (Actividad) obj;
        if (!Objects.equals(this.nombreActividad, other.nombreActividad)) {
            return false;
        }
        if (!Objects.equals(this.descripcionActividad, other.descripcionActividad)) {
            return false;
        }
        if (!Objects.equals(this.categoriaActividad, other.categoriaActividad)) {
            return false;
        }
        if (!Objects.equals(this.idActividad, other.idActividad)) {
            return false;
        }
        if (!Objects.equals(this.precioActividad, other.precioActividad)) {
            return false;
        }
        if (!Objects.equals(this.entrenadorTieneActividad, other.entrenadorTieneActividad)) {
            return false;
        }
        return Objects.equals(this.listaUsuarios, other.listaUsuarios);
    }

}
