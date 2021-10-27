package com.arelance.service.factory;

import com.arelance.service.impl.UserCrud;

/**
 *
 * @author Pedro
 */
public class UserFactory implements Factory {

    @Override
    public Crud createCrud() {
        return new UserCrud();
    }
    
}
