package com.arelance.service.intefacescrud;

import com.arelance.domain.Activity;
import java.util.List;

/**
 *
 * @author Pedro
 */
public interface ActivityCrudSpecific extends BasicCrud<Activity> {
    
    List<Activity> readAllEntities();
    
}
