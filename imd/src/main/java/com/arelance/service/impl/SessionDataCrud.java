package com.arelance.service.impl;

import com.arelance.dao.facade.SessionDataFacade;
import com.arelance.domain.SessionData;
import com.arelance.service.factory.Crud;
import com.arelance.servlets.commands.qualifiers.SessionDataCrudQ;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
@SessionDataCrudQ
public class SessionDataCrud implements Crud<SessionData> {

    @Inject
    private SessionDataFacade facade;

    @Override
    public void createEntity(SessionData t) {
        facade.createEntity(t);
    }

    @Override
    public void updateEntity(SessionData t) {
        facade.updateEntity(t);
    }

    @Override
    public void deleteEntity(SessionData t) {
        facade.deleteEntity(t);
    }

    @Override
    public SessionData readEntity(Integer n) {
        return (SessionData) facade.readEntity(n);
    }

    @Override
    public List<SessionData> readAllEntity() {
        return facade.readAllEntity();
    }

    @Override
    public SessionData refreshEntity(SessionData t) {
        return (SessionData) facade.refreshEntity(t);
    }

    public SessionData logIn(SessionData sessionData) {
        return facade.logIn(sessionData);
    }

}
