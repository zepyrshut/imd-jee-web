package com.arelance.dao.facade.local;

import com.arelance.domain.UserImd;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
public interface UserFacadeLocal {

    public void createEntity(UserImd userImd);

    public void updateEntity(UserImd userImd);

    public void deleteEntity(UserImd userImd);

    public UserImd findById(Object idEntity);

    public UserImd findUserByEmail(UserImd userImd);

    public UserImd refreshEntity(UserImd userImd);

}
