package com.arelance.servlets.commands;

import com.arelance.domain.Actividad;
import com.arelance.service.ActividadService;
import com.arelance.service.impl.ActividadServiceImpl;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.arelance.servlets.MainCommand;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Pedro
 */
public class IndexLoader implements MainCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ActividadService actividadService = new ActividadServiceImpl();
        
        List<Actividad> listaActividades = actividadService.listarActividades();
        request.setAttribute("listaActividad", listaActividades);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
        return "indexLoader";
    }
}
