package com.arelance.servlets;

import com.arelance.dao.DatosSesionDAO;
import com.arelance.domain.DatosSesion;
import com.arelance.domain.Usuario;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */ 
@WebServlet
public class LogIn extends HttpServlet implements ServletAction {

    @Inject
    private DatosSesionDAO datosSesionDAO;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatosSesion datosSesion = new DatosSesion();
        String nombre = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        datosSesion.setUsuario(nombre);
        datosSesion.setContrasena(contrasena);

        datosSesion = datosSesionDAO.inicioSesion(datosSesion);

        if (datosSesion == null) {
            String datoIncorrecto = "Datos de sesión incorrectos, inténtelo de nuevo.";
            request.setAttribute("datoIncorrecto", datoIncorrecto);
            request.getRequestDispatcher("/iniciosesion.jsp").forward(request, response);
            return "Success";
        } else {
            Usuario usuario = datosSesion.getUsuarioSocio();
            HttpSession sesionUsuario = request.getSession(true);
            sesionUsuario.setAttribute("usuario", usuario);
            response.sendRedirect("principal");
            return "Fail";
        }

    }
}
