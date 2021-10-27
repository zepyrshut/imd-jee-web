package com.arelance.dao.facade.local;

import com.arelance.domain.SessionData;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
public interface SessionDataFacadeLocal {

    public void createEntity(SessionData sessionData);

    public void updateEntity(SessionData user);

    public void deleteEntity(SessionData user);
    
    public List<SessionData> readAllEntity();

    public SessionData readEntity(Object id);

    public SessionData refreshEntity(SessionData sessionData);

    public SessionData logIn(SessionData sessionData);

    public SessionData findSessionDataByUser(SessionData sessionData);

}
