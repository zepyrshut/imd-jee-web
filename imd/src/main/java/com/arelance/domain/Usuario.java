package com.arelance.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
import javax.xml.bind.annotation.XmlTransient;

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
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellido_a")
    private String apellidoA;
    @Size(max = 20)
    @Column(name = "apellido_b")
    private String apellidoB;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarioSocio")
    private DatosSesion datosSesion;
 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<MetodoPago> metodoPago;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombre, String apellidoA, String apellidoB, String telefono, String email, DatosSesion datosSesion, List<MetodoPago> metodoPago) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoA = apellidoA;
        this.apellidoB = apellidoB;
        this.telefono = telefono;
        this.email = email;
        this.datosSesion = datosSesion;
        this.metodoPago = metodoPago;
    }

    public Usuario(Integer idUsuario, String nombre, String apellidoA, String apellidoB, String telefono, String email, List<MetodoPago> metodoPago) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoA = apellidoA;
        this.apellidoB = apellidoB;
        this.telefono = telefono;
        this.email = email;
        this.metodoPago = metodoPago;
    }

    public Usuario(Integer idUsuario, String nombre, String apellidoA, String apellidoB, String telefono, String email) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoA = apellidoA;
        this.apellidoB = apellidoB;
        this.telefono = telefono;
        this.email = email;
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

    public List<MetodoPago> getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(List<MetodoPago> metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idUsuario);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.apellidoA);
        hash = 97 * hash + Objects.hashCode(this.apellidoB);
        hash = 97 * hash + Objects.hashCode(this.telefono);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.datosSesion);
        hash = 97 * hash + Objects.hashCode(this.metodoPago);
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
        if (!Objects.equals(this.metodoPago, other.metodoPago)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidoA=" + apellidoA + ", apellidoB=" + apellidoB + ", telefono=" + telefono + ", email=" + email + ", datosSesion=" + datosSesion + ", metodoPago=" + metodoPago + '}';
    }
    
    
    
    
}