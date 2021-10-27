package com.arelance.service.impl;

import com.arelance.dao.facade.local.UserFacadeLocal;
import com.arelance.domain.UserImd;
import java.util.List;
import javax.inject.Inject;
import com.arelance.qualifiers.UserCrudQ;
import com.arelance.service.Crud;

/**
 *
 * @author Pedro
 */
@UserCrudQ
public class UserCrud implements Crud<UserImd> {

    @Inject
    private UserFacadeLocal facade;

    @Override
    public void createEntity(UserImd t) {
        facade.createEntity(t);
    }

    @Override
    public void updateEntity(UserImd t) {
        facade.updateEntity(t);
    }

    @Override
    public void deleteEntity(UserImd t) {
        facade.deleteEntity(t);
    }

    @Override
    public UserImd readEntity(Integer n) {
        return (UserImd) facade.readEntity(n);
    }

    @Override
    public List<UserImd> readAllEntity() {
        return facade.readAllEntity();
    }

    @Override
    public UserImd refreshEntity(UserImd t) {
        return (UserImd) facade.refreshEntity(t);
    }
    
    public UserImd findUserByEmail(UserImd user) {
        return facade.findUserByEmail(user);
    }
}
