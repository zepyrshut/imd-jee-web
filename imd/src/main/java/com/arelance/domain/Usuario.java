package com.arelance.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Pedro
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
   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")

       // private Set<UsuarioTieneActividad> usuarioTieneActividadCollection = new HashSet<>(); 
            @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
        private ArrayList<UsuarioTieneActividad> usuarioTieneActividadCollection;
            
            
            
            
       //   private ArrayList<UsuarioTieneActividad> usuarioTieneActividadCollection;
         //private List<UsuarioTieneActividad> usuarioTieneActividadCollection;
        
        
 
    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nombre, String apellidoA, String email) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoA = apellidoA;
        this.email = email;
    }

    public Usuario(Integer idUsuario, String nombre, String apellidoA, String apellidoB, String telefono, String email, DatosSesion datosSesion, ArrayList<UsuarioTieneActividad> usuarioTieneActividadCollection) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoA = apellidoA;
        this.apellidoB = apellidoB;
        this.telefono = telefono;
        this.email = email;
        this.datosSesion = datosSesion;
        this.usuarioTieneActividadCollection = usuarioTieneActividadCollection;
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

    @XmlTransient
    public DatosSesion getDatosSesion() {
        return datosSesion;
    }

    public void setDatosSesion(DatosSesion datosSesion) {
        this.datosSesion = datosSesion;
    }

    @XmlTransient
    public ArrayList<UsuarioTieneActividad> getUsuarioTieneActividadCollection() {
        return usuarioTieneActividadCollection;
    }

    public void setUsuarioTieneActividadCollection(ArrayList<UsuarioTieneActividad> usuarioTieneActividadCollection) {
        this.usuarioTieneActividadCollection = usuarioTieneActividadCollection;
    }


    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.domain.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
