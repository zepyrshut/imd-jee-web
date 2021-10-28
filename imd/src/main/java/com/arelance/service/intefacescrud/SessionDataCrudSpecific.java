package com.arelance.service.intefacescrud;

import com.arelance.domain.SessionData;

/**
 *
 * @author Pedro
 */
public interface SessionDataCrudSpecific extends BasicCrud<SessionData> {
    
    public SessionData logIn(SessionData sessionData);
    
    public SessionData findSessionDataByUser(SessionData sessionData);
    
}
