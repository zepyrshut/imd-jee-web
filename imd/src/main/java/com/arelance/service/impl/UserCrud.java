package com.arelance.service.impl;

import com.arelance.dao.facade.local.UserFacadeLocal;
import com.arelance.domain.UserImd;
import javax.inject.Inject;
import com.arelance.qualifiers.UserCrudQ;
import com.arelance.service.intefacescrud.BasicCrud;

/**
 *
 * @author Pedro
 */
@UserCrudQ
public class UserCrud implements BasicCrud<UserImd> {

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
    public UserImd findById(Integer n) {
        return (UserImd) facade.findById(n);
    }
    
    @Override
    public UserImd refreshEntity(UserImd t) {
        return (UserImd) facade.refreshEntity(t);
    }
    
    public UserImd findUserByEmail(UserImd user) {
        return facade.findUserByEmail(user);
    }
}
