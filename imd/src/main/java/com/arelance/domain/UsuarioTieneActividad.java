package com.arelance.domain;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "usuario_tiene_actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioTieneActividad.findAll", query = "SELECT u FROM UsuarioTieneActividad u"),
    @NamedQuery(name = "UsuarioTieneActividad.findByIdUsuario", query = "SELECT u FROM UsuarioTieneActividad u WHERE u.usuarioTieneActividadPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuarioTieneActividad.findByIdActividad", query = "SELECT u FROM UsuarioTieneActividad u WHERE u.usuarioTieneActividadPK.idActividad = :idActividad")})
public class UsuarioTieneActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioTieneActividadPK usuarioTieneActividadPK;
    
    
    
    
    @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Actividad actividad;
    
    
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

        @JoinColumn(name = "id_paypal", referencedColumnName = "id_paypal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paypal paypal;
    
    
    public UsuarioTieneActividad() {
    }

    public UsuarioTieneActividad(UsuarioTieneActividadPK usuarioTieneActividadPK) {
        this.usuarioTieneActividadPK = usuarioTieneActividadPK;
    }

//     public UsuarioTieneActividad(int idUsuario, int idActividad) {
//        this.usuarioTieneActividadPK = new UsuarioTieneActividadPK(idUsuario, idActividad);
//    }
     
     public UsuarioTieneActividad(int idUsuario, int idActividad, int idPaypal) {
        this.usuarioTieneActividadPK = new UsuarioTieneActividadPK(idUsuario, idActividad, idPaypal);
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

    public Paypal getPaypal() {
        return paypal;
    }

    public void setPaypal(Paypal paypal) {
        this.paypal = paypal;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioTieneActividadPK != null ? usuarioTieneActividadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioTieneActividad)) {
            return false;
        }
        UsuarioTieneActividad other = (UsuarioTieneActividad) object;
        if ((this.usuarioTieneActividadPK == null && other.usuarioTieneActividadPK != null) || (this.usuarioTieneActividadPK != null && !this.usuarioTieneActividadPK.equals(other.usuarioTieneActividadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.domain.UsuarioTieneActividad[ usuarioTieneActividadPK=" + usuarioTieneActividadPK + " ]";
    }

}
