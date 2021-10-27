package com.arelance.service.impl;

import com.arelance.dao.facade.ActivityFacade;
import com.arelance.domain.Activity;
import com.arelance.service.factory.Crud;
import com.arelance.servlets.commands.qualifiers.ActivityCrudQ;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
@ActivityCrudQ
public class ActividadCrud implements Crud<Activity> {

    @Inject
    private ActivityFacade facade;

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
