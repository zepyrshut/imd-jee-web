/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arelance.service.factoryimpl;

import com.arelance.qualifiers.ActivityCrudQ;
import com.arelance.qualifiers.ActivityFactoryQ;
import com.arelance.service.ActivityCrud;
import com.arelance.service.factory.Factory;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
@ActivityFactoryQ
public class ActivityFactory implements Factory<ActivityCrud> {

    @Inject
    @ActivityCrudQ
    private ActivityCrud activityCrud;

    @Override
    public ActivityCrud buildCrud() {
        return activityCrud;
    }

}
