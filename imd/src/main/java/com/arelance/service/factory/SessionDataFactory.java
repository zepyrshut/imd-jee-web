/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arelance.service.factory;

import com.arelance.service.impl.SessionDataCrud;

/**
 *
 * @author model
 */
public class SessionDataFactory implements Factory {

    @Override
    public Crud createCrud() {
        return new SessionDataCrud();
    }

}
