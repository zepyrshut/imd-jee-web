/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.beans;

/**
 *
 * @author jorge
 */
public class Entrenador2 {
    private int identrenador;
    private String nombre;

    public Entrenador2() {
    }

    public Entrenador2(int identrenador, String nombre) {
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
