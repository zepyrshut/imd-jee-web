package com.arelance.service.factory;

import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
@FunctionalInterface
public interface Factory {

    Crud createCrud();

}
