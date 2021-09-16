package com.arelance.dao;

import com.arelance.domain.Actividad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorge
 */
@Local
public interface ActividadDAO {

    public List<Actividad> listarActividades();

    public Actividad findActividadById(Actividad actividad);

    public void addActividad(Actividad actividad);

    public void updateActividad(Actividad actividad);

    public void removeActividad(Actividad actividad);
}
