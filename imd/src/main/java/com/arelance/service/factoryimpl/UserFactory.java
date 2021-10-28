package com.arelance.service.factoryimpl;

import com.arelance.qualifiers.UserCrudQ;
import com.arelance.qualifiers.UserFactoryQ;
import com.arelance.service.UserCrud;
import com.arelance.service.factory.Factory;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
@UserFactoryQ
public class UserFactory implements Factory<UserCrud> {

    @Inject
    @UserCrudQ
    private UserCrud userCrud;

    @Override
    public UserCrud buildCrud() {
        return userCrud;
    }
}
