package com.arelance.service.factoryimpl;

import com.arelance.qualifiers.SessionDataCrudQ;
import com.arelance.service.SessionDataCrud;
import com.arelance.service.factory.Factory;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
public class SessionDataFactory implements Factory<SessionDataCrud> {

    @Inject
    @SessionDataCrudQ
    private SessionDataCrud sessionDataCrud;

    @Override
    public SessionDataCrud buildCrud() {
        return sessionDataCrud;
    }

}
