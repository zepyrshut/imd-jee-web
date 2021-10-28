package com.arelance.service;

import com.arelance.domain.SessionData;
import com.arelance.qualifiers.SessionDataCrudQ;
import com.arelance.service.impl.SessionDataCrud;
import com.arelance.service.intefacescrud.Factory;
import com.arelance.service.intefacescrud.SessionDataCrudSpecific;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
public class SessionDataFactory implements Factory<SessionData> {

    @Inject
    @SessionDataCrudQ
    private SessionDataCrudSpecific sessionDataCrud;

    @Override
    public SessionDataCrud createCrud() {
        return (SessionDataCrud) sessionDataCrud;

    }

}
