/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author jorge
 */
@Entity(name = "usuario_tiene_actividad")
public class RegistroActividad implements Serializable {

    @Id
    @Column(name = "id_user_actividad")
    Long idUserActividad;
    
     @ManyToOne
    @JoinColumn(name = "id_usuario")
    Usuario usuario;
    
    
    @ManyToOne
    @JoinColumn(name = "id_actividad")
    Actividad actividad;

    public RegistroActividad() {
    }

    public RegistroActividad(Usuario usuario, Actividad actividad) {
        this.usuario = usuario;
        this.actividad = actividad;
    }

    public RegistroActividad(Long idUserActividad, Usuario usuario, Actividad actividad) {
        this.idUserActividad = idUserActividad;
        this.usuario = usuario;
        this.actividad = actividad;
    }

    public Long getIdUserActivity() {
        return idUserActividad;
    }

    public void setIdUserActivity(Long idUserActivity) {
        this.idUserActividad = idUserActivity;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idUserActividad);
        hash = 53 * hash + Objects.hashCode(this.usuario);
        hash = 53 * hash + Objects.hashCode(this.actividad);
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
        final RegistroActividad other = (RegistroActividad) obj;
        if (!Objects.equals(this.idUserActividad, other.idUserActividad)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.actividad, other.actividad)) {
            return false;
        }
        return true;
    }
    
    
    
}
