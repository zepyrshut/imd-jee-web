package com.arelance.service.factoryimpl;

import com.arelance.qualifiers.ActivityCrudQ;
import com.arelance.service.ActivityCrud;
import com.arelance.service.factory.Factory;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
public class ActivityFactory implements Factory<ActivityCrud> {

    @Inject
    @ActivityCrudQ
    private ActivityCrud activityCrud;

    @Override
    public ActivityCrud buildCrud() {
        return activityCrud;
    }

}
