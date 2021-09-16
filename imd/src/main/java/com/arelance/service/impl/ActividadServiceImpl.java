package com.arelance.service.impl;

import com.arelance.dao.ActividadDAO;
import com.arelance.domain.Actividad;
import com.arelance.service.ActividadService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Jorge
 */
public class ActividadServiceImpl implements ActividadService {

    @Inject
    private ActividadDAO actividadDAO;

    @Override
    public List<Actividad> listarActividades() {
        return actividadDAO.listarActividades();
    }

    @Override
    public Actividad findEntrenadorByID(Actividad actividad) {
        return actividadDAO.findEntrenadorByID(actividad);
    }

    @Override
    public void addActividad(Actividad actividad) {
        actividadDAO.addActividad(actividad);
    }

    @Override
    public void updateActividad(Actividad actividad) {
        actividadDAO.updateActividad(actividad);
    }

    @Override
    public void removeActividad(Actividad actividad) {
        actividadDAO.removeActividad(actividad);
    }

}
