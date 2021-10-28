/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arelance.service;

import com.arelance.domain.Activity;
import com.arelance.qualifiers.ActivityCrudQ;
import com.arelance.qualifiers.ActivityFactoryQ;
import com.arelance.service.impl.ActivityCrud;
import com.arelance.service.impl.UserCrud;
import com.arelance.service.intefacescrud.ActivityCrudSpecific;
import com.arelance.service.intefacescrud.BasicCrud;
import com.arelance.service.intefacescrud.Factory;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
@ActivityFactoryQ
public class ActivityFactory implements Factory<Activity> {

    @Inject
    @ActivityCrudQ
    private ActivityCrudSpecific activityCrud;

    @Override
    public BasicCrud<Activity> createCrud() {
        return (ActivityCrud) activityCrud;
    }

}
