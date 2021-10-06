package com.arelance.servlets.commands;

import com.arelance.service.ActividadService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.arelance.servlets.MainCommand;

/**
 *
 * @author Pedro
 */
public class IndexLoader implements MainCommand {

    @Inject
    private ActividadService actividadService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
        request.setAttribute("listaActividad", actividadService.listarActividades()); 
        return "/index.jsp";
        
    }
}
