package com.arelance.service.factory;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 * @param <T>
 */
@Local
public interface Crud<T> {

    void createEntity(T t);

    void updateEntity(T t);

    void deleteEntity(T t);

    T readEntity(Integer n);

    List<T> readAllEntity();

    T refreshEntity(T t);

}
