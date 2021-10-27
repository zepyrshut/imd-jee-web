package com.arelance.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "usuario_tiene_actividad")
@NamedQueries({
    @NamedQuery(name = "UsuarioTieneActividad.findAll", query = "SELECT u FROM UsuarioTieneActividad u")})
public class UsuarioTieneActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioTieneActividadPK usuarioTieneActividadPK;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad", insertable = false, updatable = false)
    @ManyToOne
    private Actividad actividad;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne
    private Usuario usuario;
    @JoinColumn(name = "id_pago", referencedColumnName = "id_pago", insertable = false, updatable = false)
    @ManyToOne
    private MetodoPago metodoPago;

    public UsuarioTieneActividad() {
    }

    public UsuarioTieneActividad(UsuarioTieneActividadPK usuarioTieneActividadPK) {
        this.usuarioTieneActividadPK = usuarioTieneActividadPK;
    }

    public UsuarioTieneActividad(int idUsuario, int idActividad, int idPago) {
        this.usuarioTieneActividadPK = new UsuarioTieneActividadPK(idUsuario, idActividad, idPago);
    }

    public UsuarioTieneActividadPK getUsuarioTieneActividadPK() {
        return usuarioTieneActividadPK;
    }

    public void setUsuarioTieneActividadPK(UsuarioTieneActividadPK usuarioTieneActividadPK) {
        this.usuarioTieneActividadPK = usuarioTieneActividadPK;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.usuarioTieneActividadPK);
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
        final UsuarioTieneActividad other = (UsuarioTieneActividad) obj;
        return Objects.equals(this.usuarioTieneActividadPK, other.usuarioTieneActividadPK);
    }

}
