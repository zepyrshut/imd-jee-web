package com.arelance.dao.facade.local;

import com.arelance.domain.UserImd;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
public interface UserFacadeLocal {

    public void createEntity(UserImd user);

    public void updateEntity(UserImd user);

    public void deleteEntity(UserImd user);

    public UserImd readEntity(Object id);

    public List<UserImd> readAllEntity();

    public UserImd refreshEntity(UserImd user);
    
    public UserImd findUserByEmail(UserImd user);

}
