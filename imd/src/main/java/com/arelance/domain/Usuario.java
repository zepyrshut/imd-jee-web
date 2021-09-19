/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pedro
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT p FROM Usuario p ORDER BY p.idUsuario")
}
)
@Table(name = "usuario")
public class Usuario implements Serializable {
    
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;
    @Column(name = "nombre")
    private String nombreUsuario;
    @Column(name = "apellido_a")
    private String apellidoUsuarioA;
    @Column(name = "apellido_b")
    private String apellidoUsuarioB;
    @Column(name = "telefono")
    private String telefonoUsuario;
    @Column(name = "email")
    private String emailUsuario;
    @OneToMany(cascade = {CascadeType.REMOVE})
    private List<Actividad> actividades;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String apellidoUsuarioA, String apellidoUsuarioB, String telefonoUsuario, String emailUsuario, List<Actividad> actividades) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuarioA = apellidoUsuarioA;
        this.apellidoUsuarioB = apellidoUsuarioB;
        this.telefonoUsuario = telefonoUsuario;
        this.emailUsuario = emailUsuario;
        this.actividades = actividades;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuarioA() {
        return apellidoUsuarioA;
    }

    public void setApellidoUsuarioA(String apellidoUsuarioA) {
        this.apellidoUsuarioA = apellidoUsuarioA;
    }

    public String getApellidoUsuarioB() {
        return apellidoUsuarioB;
    }

    public void setApellidoUsuarioB(String apellidoUsuarioB) {
        this.apellidoUsuarioB = apellidoUsuarioB;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

}
