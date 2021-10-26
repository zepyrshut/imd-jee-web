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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro, Jorge
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellidoA", query = "SELECT u FROM Usuario u WHERE u.apellidoA = :apellidoA"),
    @NamedQuery(name = "Usuario.findByApellidoB", query = "SELECT u FROM Usuario u WHERE u.apellidoB = :apellidoB"),
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido_a")
    private String apellidoA;
    @Column(name = "apellido_b")
    private String apellidoB;
    @Column(name = "telefono")
    private String telefono;
    //@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarioSocio")
    private DatosSesion datosSesion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<UsuarioTieneActividad> usuarioTieneActividad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<MetodoPago> metodoPago;

    public Usuario() {
        this.usuarioTieneActividad = new ArrayList<>();
        this.metodoPago = new ArrayList<>();
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoA() {
        return apellidoA;
    }

    public void setApellidoA(String apellidoA) {
        this.apellidoA = apellidoA;
    }

    public String getApellidoB() {
        return apellidoB;
    }

    public void setApellidoB(String apellidoB) {
        this.apellidoB = apellidoB;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DatosSesion getDatosSesion() {
        return datosSesion;
    }

    public void setDatosSesion(DatosSesion datosSesion) {
        this.datosSesion = datosSesion;
    }

    public List<UsuarioTieneActividad> getUsuarioTieneActividad() {
        return usuarioTieneActividad;
    }

    public void setUsuarioTieneActividad(List<UsuarioTieneActividad> usuarioTieneActividad) {
        this.usuarioTieneActividad = usuarioTieneActividad;
    }

    public List<MetodoPago> getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(List<MetodoPago> metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.idUsuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidoA, other.apellidoA)) {
            return false;
        }
        if (!Objects.equals(this.apellidoB, other.apellidoB)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        if (!Objects.equals(this.datosSesion, other.datosSesion)) {
            return false;
        }
        if (!Objects.equals(this.usuarioTieneActividad, other.usuarioTieneActividad)) {
            return false;
        }
        return Objects.equals(this.metodoPago, other.metodoPago);
    }

}
