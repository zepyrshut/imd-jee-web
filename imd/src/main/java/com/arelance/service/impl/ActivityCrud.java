package com.arelance.service.impl;

import com.arelance.dao.facade.local.ActivityFacadeLocal;
import com.arelance.domain.Activity;
import com.arelance.qualifiers.ActivityCrudQ;
import com.arelance.service.Crud;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
@ActivityCrudQ
public class ActivityCrud implements Crud<Activity> {

    @Inject
    private ActivityFacadeLocal facade;

    @Override
    public void createEntity(Activity t) {
        facade.createEntity(t);
    }

    @Override
    public void updateEntity(Activity t) {
        facade.updateEntity(t);
    }

    @Override
    public void deleteEntity(Activity t) {
        facade.deleteEntity(t);
    }

    @Override
    public Activity readEntity(Integer n) {
        return (Activity) facade.readEntity(n);
    }

    @Override
    public List<Activity> readAllEntity() {
        return facade.readAllEntity();
    }

    @Override
    public Activity refreshEntity(Activity t) {
        return (Activity) facade.refreshEntity(t);
    }

}
