package com.arelance.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "datos_sesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosSesion.findAll", query = "SELECT d FROM DatosSesion d"),
    @NamedQuery(name = "DatosSesion.findByIdDatosSesion", query = "SELECT d FROM DatosSesion d WHERE d.idDatosSesion = :idDatosSesion"),
    @NamedQuery(name = "DatosSesion.findByUsuario", query = "SELECT d FROM DatosSesion d WHERE d.usuario = :usuario"),
    @NamedQuery(name = "DatosSesion.validarSesion", query = "SELECT d FROM DatosSesion d WHERE d.usuario = :usuario AND d.contrasena = :contrasena"),
    @NamedQuery(name = "DatosSesion.findByContrasena", query = "SELECT d FROM DatosSesion d WHERE d.contrasena = :contrasena")}
)
public class DatosSesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_datos_sesion")
    private Integer idDatosSesion;
    @Size(min = 1, max = 20)
    @Column(name = "usuario")
    private String usuario;
    @Size(min = 1, max = 50)
    @Column(name = "contrasena")
    private String contrasena;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @OneToOne(optional = false)
    private Usuario usuarioSocio;

    public DatosSesion() {
    }

    public DatosSesion(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Integer getIdDatosSesion() {
        return idDatosSesion;
    }

    public void setIdDatosSesion(Integer idDatosSesion) {
        this.idDatosSesion = idDatosSesion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuario getUsuarioSocio() {
        return usuarioSocio;
    }

    public void setUsuarioSocio(Usuario usuario1) {
        this.usuarioSocio = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDatosSesion != null ? idDatosSesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosSesion)) {
            return false;
        }
        DatosSesion other = (DatosSesion) object;
        if ((this.idDatosSesion == null && other.idDatosSesion != null) || (this.idDatosSesion != null && !this.idDatosSesion.equals(other.idDatosSesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.domain.DatosSesion[ idDatosSesion=" + idDatosSesion + " ]";
    }

}
