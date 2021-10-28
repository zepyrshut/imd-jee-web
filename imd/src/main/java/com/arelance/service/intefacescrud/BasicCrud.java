package com.arelance.service.intefacescrud;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 * @param <T>
 */
@Local
public interface BasicCrud<T> {

    void createEntity(T t);

    void updateEntity(T t);

    void deleteEntity(T t);

    T findById(Integer n);

    T refreshEntity(T t);

}
