package com.arelance.service.intefacescrud;

import com.arelance.service.intefacescrud.BasicCrud;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 * @param <T>
 */
@Local
@FunctionalInterface
public interface Factory<T> {

    BasicCrud<T> createCrud();

}
