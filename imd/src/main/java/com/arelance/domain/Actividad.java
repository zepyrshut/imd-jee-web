/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.domain;

import com.arelance.enums.CategoriasActividad;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Pedro
 */
@Entity
//@NamedQueries({
//    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a ORDER BY a.idActividad")
//})
public class Actividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int IdActividad;
    private String nombreActividad;
    private String descripcionActividad;
    private CategoriasActividad categoriaActividad;
    private double precio;

    public Actividad() {
    }

    public Actividad(int IdActividad, String nombreActividad, String descripcionActividad, CategoriasActividad categoriaActividad, double precio) {
        this.IdActividad = IdActividad;
        this.nombreActividad = nombreActividad;
        this.descripcionActividad = descripcionActividad;
        this.categoriaActividad = categoriaActividad;
        this.precio = precio;
    }

    public int getIdActividad() {
        return IdActividad;
    }

    public void setIactividad(int IdActividad) {
        this.IdActividad = IdActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public CategoriasActividad getCategoriaActividad() {
        return categoriaActividad;
    }

    public void setCategoriaActividad(CategoriasActividad categoriaActividad) {
        this.categoriaActividad = categoriaActividad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
