package com.arelance.service.impl;

import com.arelance.dao.facade.local.ActivityFacadeLocal;
import com.arelance.domain.Activity;
import com.arelance.qualifiers.ActivityCrudQ;
import com.arelance.service.intefacescrud.ActivityCrudSpecific;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
@ActivityCrudQ
public class ActivityCrud implements ActivityCrudSpecific {

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
    public Activity findById(Integer n) {
        return (Activity) facade.findById(n);
    }

    @Override
    public List<Activity> readAllEntities() {
        return facade.readAllEntities();
    }

    @Override
    public Activity refreshEntity(Activity t) {
        return (Activity) facade.refreshEntity(t);
    }

}
