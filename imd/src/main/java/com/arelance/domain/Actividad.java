/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.domain;

import com.arelance.enums.CategoriasActividad;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a")
})
@Table(name = "actividad")
public class Actividad implements Serializable {
    private static Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private int IdActividad;
    @Column(name = "nombre_actividad")
    private String nombreActividad;
    @Column(name = "descripcion_actividad")
    private String descripcionActividad;
    @Column(name = "categoria_actividad") //CAMBIAR A CATEGORIA OBJETO
    private String categoriaActividad;
    @Column(name = "precio")
    private double precio;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Actividad() {
    }

    public Actividad(int IdActividad, String nombreActividad, String descripcionActividad, String categoriaActividad, double precio, Usuario usuario) {
        this.IdActividad = IdActividad;
        this.nombreActividad = nombreActividad;
        this.descripcionActividad = descripcionActividad;
        this.categoriaActividad = categoriaActividad;
        this.precio = precio;
        this.usuario = usuario;
    }



    public void setIdActividad(int IdActividad) {
        this.IdActividad = IdActividad;
    }

    
    
//    public Actividad(int IdActividad, String nombreActividad, String descripcionActividad, CategoriasActividad categoriaActividad, double precio) {
//        this.IdActividad = IdActividad;
//        this.nombreActividad = nombreActividad;
//        this.descripcionActividad = descripcionActividad;
//        this.categoriaActividad = categoriaActividad;
//        this.precio = precio;
//    }

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

    public String getCategoriaActividad() {
        return categoriaActividad;
    }

    public void setCategoriaActividad(String categoriaActividad) {
        this.categoriaActividad = categoriaActividad;
    }

   

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    

}
