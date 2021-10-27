package com.arelance.service.impl;

import com.arelance.dao.facade.UserFacade;
import com.arelance.domain.SessionData;
import com.arelance.domain.User;
import com.arelance.service.factory.Crud;
import java.util.List;
import javax.inject.Inject;
import com.arelance.servlets.commands.qualifiers.UserCrudQ;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Pedro
 */
@UserCrudQ
public class UserCrud implements Crud<User> {

    @Inject
    private UserFacade facade;

    @Override
    public void createEntity(User t) {
        facade.createEntity(t);
    }

    @Override
    public void updateEntity(User t) {
        facade.updateEntity(t);
    }

    @Override
    public void deleteEntity(User t) {
        facade.deleteEntity(t);
    }

    @Override
    public User readEntity(Integer n) {
        return (User) facade.readEntity(n);
    }

    @Override
    public List<User> readAllEntity() {
        return facade.readAllEntity();
    }

    @Override
    public User refreshEntity(User t) {
        return (User) facade.refreshEntity(t);
    }
    
}
