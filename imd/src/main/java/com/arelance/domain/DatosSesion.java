package com.arelance.domain;

import java.io.Serializable;
import java.util.Objects;
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

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "datos_sesion")
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
    @Column(name = "id_datos_sesion")
    private Integer idDatosSesion;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contrasena")
    private String contrasena;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @OneToOne(optional = false)
    private Usuario usuarioSocio;

    public DatosSesion() {
        super();
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
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.idDatosSesion);
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
        final DatosSesion other = (DatosSesion) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        if (!Objects.equals(this.idDatosSesion, other.idDatosSesion)) {
            return false;
        }
        return Objects.equals(this.usuarioSocio, other.usuarioSocio);
    }

}
