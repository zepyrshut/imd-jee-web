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
public class UserHasActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserHasActivityPK usuarioTieneActividadPK;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad", insertable = false, updatable = false)
    @ManyToOne
    private Activity actividad;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne
    private User usuario;
    @JoinColumn(name = "id_pago", referencedColumnName = "id_pago", insertable = false, updatable = false)
    @ManyToOne
    private PaymentMethod metodoPago;

    public UserHasActivity() {
    }

    public UserHasActivity(UserHasActivityPK usuarioTieneActividadPK) {
        this.usuarioTieneActividadPK = usuarioTieneActividadPK;
    }

    public UserHasActivity(int idUsuario, int idActividad, int idPago) {
        this.usuarioTieneActividadPK = new UserHasActivityPK(idUsuario, idActividad, idPago);
    }

    public UserHasActivityPK getUsuarioTieneActividadPK() {
        return usuarioTieneActividadPK;
    }

    public void setUsuarioTieneActividadPK(UserHasActivityPK usuarioTieneActividadPK) {
        this.usuarioTieneActividadPK = usuarioTieneActividadPK;
    }

    public Activity getActividad() {
        return actividad;
    }

    public void setActividad(Activity actividad) {
        this.actividad = actividad;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public PaymentMethod getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(PaymentMethod metodoPago) {
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
        final UserHasActivity other = (UserHasActivity) obj;
        return Objects.equals(this.usuarioTieneActividadPK, other.usuarioTieneActividadPK);
    }

}
