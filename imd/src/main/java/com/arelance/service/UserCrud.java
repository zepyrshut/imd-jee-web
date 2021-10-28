package com.arelance.service;

import com.arelance.dao.facade.local.UserFacadeLocal;
import com.arelance.domain.UserImd;
import javax.inject.Inject;
import com.arelance.qualifiers.UserCrudQ;

/**
 *
 * @author Pedro
 */
@UserCrudQ
public class UserCrud implements UserFacadeLocal {

    @Inject
    private UserFacadeLocal facade;

    @Override
    public void createEntity(UserImd userImd) {
        facade.createEntity(userImd);
    }

    @Override
    public void updateEntity(UserImd userImd) {
        facade.updateEntity(userImd);
    }

    @Override
    public void deleteEntity(UserImd userImd) {
        facade.deleteEntity(userImd);
    }

    @Override
    public UserImd findById(Object idEntity) {
        return facade.findById(idEntity);
    }

    @Override
    public UserImd findUserByEmail(UserImd userImd) {
        return facade.findUserByEmail(userImd);
    }

    @Override
    public UserImd refreshEntity(UserImd userImd) {
        return facade.refreshEntity(userImd);
    }
    
}
