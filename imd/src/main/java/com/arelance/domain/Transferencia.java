/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.domain;

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
public class Transferencia implements Serializable {

    private static Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transferencia")
    private int idTransferencia;
    @Column(name = "iban")
    private String iban;
    @Column(name = "usuario_id_usuario")
    private int idUsuario;

    public Transferencia() {
    }

    public Transferencia(int idTransferencia, String iban, int idUsuario) {
        this.idTransferencia = idTransferencia;
        this.iban = iban;
        this.idUsuario = idUsuario;
    }

    public int getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
