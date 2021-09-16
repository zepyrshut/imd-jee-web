package com.arelance.service;

import com.arelance.domain.Actividad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorge
 */
@Local
public interface ActividadService {

    public List<Actividad> listarActividades();

    public Actividad findEntrenadorByID(Actividad actividad);

    public void addActividad(Actividad actividad);

    public void updateActividad(Actividad actividad);

    public void removeActividad(Actividad actividad);
}
