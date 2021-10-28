package com.arelance.dao.facade.local;

import com.arelance.domain.SessionData;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
public interface SessionDataFacadeLocal {

    public void createEntity(SessionData sessionData);

    public void updateEntity(SessionData sessionData);

    public void deleteEntity(SessionData sessionData);

    public SessionData findById(Object id);

    public SessionData refreshEntity(SessionData sessionData);

    public SessionData logIn(SessionData sessionData);

    public SessionData findSessionDataByUser(SessionData sessionData);

}
