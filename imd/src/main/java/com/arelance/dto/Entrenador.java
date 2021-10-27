/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.dto;

import java.io.Serializable;

/**
 *
 * @author Jorge
 */
public class Entrenador implements Serializable {

    private int identrenador;
    private String nombre;

    public Entrenador() {
    }

    public Entrenador(int identrenador, String nombre) {
        this.identrenador = identrenador;
        this.nombre = nombre;
    }

    public int getIdentrenador() {
        return identrenador;
    }

    public void setIdentrenador(int identrenador) {
        this.identrenador = identrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
