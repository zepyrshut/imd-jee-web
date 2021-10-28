package com.arelance.service.impl;

import com.arelance.dao.facade.local.SessionDataFacadeLocal;
import com.arelance.domain.SessionData;
import com.arelance.qualifiers.SessionDataCrudQ;
import javax.inject.Inject;
import com.arelance.service.intefacescrud.SessionDataCrudSpecific;

/**
 *
 * @author Pedro
 */
@SessionDataCrudQ
public class SessionDataCrud implements SessionDataCrudSpecific {

    @Inject
    private SessionDataFacadeLocal facade;

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
    public SessionData findById(Integer n) {
        return (SessionData) facade.findById(n);
    }

    @Override
    public SessionData refreshEntity(SessionData t) {
        return (SessionData) facade.refreshEntity(t);
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
