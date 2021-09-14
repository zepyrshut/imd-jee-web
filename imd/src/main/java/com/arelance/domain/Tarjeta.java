/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jorge
 */
public class Tarjeta implements Serializable{
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "id_tarjeta")
      private int idTarjeta;
      @Column(name = "numero")
      private String numero;
      @Column(name = "cvv")
      private String cvv;
      @Column(name = "caducidad")
      private String caducidad; //DATETIME EN BBD
              // FK idUsuario (tarjeta.id_usuario en bbdd)

    public Tarjeta() {
    }

    public Tarjeta(int idTarjeta, String numero, String cvv, String caducidad) {
        this.idTarjeta = idTarjeta;
        this.numero = numero;
        this.cvv = cvv;
        this.caducidad = caducidad;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

   
      
      
      
      
      
      
}
