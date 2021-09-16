package com.arelance.servlets;

import com.arelance.domain.Actividad;
import com.arelance.domain.Usuario;
import com.arelance.service.ActividadService;
import com.arelance.service.UsuarioService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@WebServlet("/cargadescripcionactividades")
public class CargaDescripcionActividades extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private ActividadService actividadService;
    @Inject
    private UsuarioService usuarioService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       Usuario usuario (Usuario) request.getSession().getAttribute("usuario");
       
       

        actividad.setNombreActividad(request.getParameter("param1"));
        actividad.setCategoriaActividad(request.getParameter("apellido"));
        actividad.set(request.getParameter("email"));
        actividad.setTelefono(request.getParameter("telefono"));
        request.getSession().setAttribute("persona", persona);
        request.getRequestDispatcher("MainServlet").forward(request,
        
        
    }

}