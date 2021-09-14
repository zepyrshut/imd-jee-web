/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jorge
 */
//@Entity
public class ActividadTieneEntrenador { //Tenemos doble PK ; PENDIENTE
     @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "id_actividad")
      private int idActividad; //PK en actividad_tiene_entrenador; FK para actividad
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "id_entrenador")
      private String idEntrenador;//PK en actividad_tiene_entrenador; FK para entrenador

}
