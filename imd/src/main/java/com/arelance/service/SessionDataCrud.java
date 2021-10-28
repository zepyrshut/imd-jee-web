package com.arelance.service;

import com.arelance.dao.facade.local.SessionDataFacadeLocal;
import com.arelance.domain.SessionData;
import com.arelance.qualifiers.SessionDataCrudQ;
import com.arelance.qualifiers.SessionDataFacadeQ;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
@SessionDataCrudQ
public class SessionDataCrud implements SessionDataFacadeLocal {

    @Inject
    @SessionDataFacadeQ
    private SessionDataFacadeLocal facade;

    @Override
    public void createEntity(SessionData sessionData) {
        facade.createEntity(sessionData);
    }

    @Override
    public void updateEntity(SessionData sessionData) {
        facade.updateEntity(sessionData);
    }

    @Override
    public void deleteEntity(SessionData sessionData) {
        facade.deleteEntity(sessionData);
    }

    @Override
    public SessionData findById(Object id) {
        return facade.findById(id);
    }

    @Override
    public SessionData refreshEntity(SessionData sessionData) {
        return facade.refreshEntity(sessionData);
    }

    @Override
    public SessionData logIn(SessionData sessionData) {
        return facade.logIn(sessionData);
    }

    @Override
    public SessionData findSessionDataByUser(SessionData sessionData) {
        return facade.findSessionDataByUser(sessionData);
    }

}
