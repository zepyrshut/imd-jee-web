/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arelance.service.factory;

import com.arelance.service.impl.ActividadCrud;

/**
 *
 * @author model
 */
public class ActivityFactory implements Factory {

    @Override
    public Crud createCrud() {
        return new ActividadCrud();
    }

}
