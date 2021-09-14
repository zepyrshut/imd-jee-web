/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.beans;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class usuario implements Serializable {
    
    private int idUsuario;
    private String nombre;
    private String apellidoA;
    private String apellidoB;
    private String telefono;
    private String email;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
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
    
    
    
}
