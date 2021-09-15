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
 * @author Jorge
 */
public class Paypal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paypal")
    private int idPaypal;
    @Column(name = "correo")
    private String numero;
    @Column(name = "correo")
    private String cvv;

    public Paypal(int idPaypal, String numero, String cvv) {
        this.idPaypal = idPaypal;
        this.numero = numero;
        this.cvv = cvv;
    }

    public int getIdPaypal() {
        return idPaypal;
    }

    public void setIdPaypal(int idPaypal) {
        this.idPaypal = idPaypal;
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

    // FK idUsuario (paypal.usuario_id_usuario en bbdd)
    public Paypal() {
    }
}
