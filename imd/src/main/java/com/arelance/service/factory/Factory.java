package com.arelance.service.factory;

import javax.ejb.Local;

/**
 *
 * @author Pedro
 * @param <T>
 */
@Local
@FunctionalInterface
public interface Factory<T> {

    T buildCrud();

}
