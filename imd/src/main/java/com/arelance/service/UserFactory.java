package com.arelance.service;

import com.arelance.domain.UserImd;
import com.arelance.qualifiers.UserCrudQ;
import com.arelance.service.impl.UserCrud;
import com.arelance.service.intefacescrud.BasicCrud;
import com.arelance.service.intefacescrud.Factory;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
public class UserFactory implements Factory<UserImd> {

    @Inject
    @UserCrudQ
    private BasicCrud<UserImd> userImd;

    @Override
    public UserCrud createCrud() {
        return (UserCrud) userImd;
    }
}
