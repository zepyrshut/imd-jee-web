package com.arelance.servlets;

import com.arelance.dao.DatosSesionDAO;
import com.arelance.domain.DatosSesion;
import com.arelance.domain.Usuario;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jorge
 */
@WebServlet("/iniciosesion")
public class InicioSesion extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private DatosSesionDAO datosSesionDAO;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
            return;
        } else {
            Usuario usuario = datosSesion.getUsuarioSocio();
            HttpSession sesionUsuario = request.getSession(true);
            sesionUsuario.setAttribute("usuario", usuario);
            response.sendRedirect("principal");
        }

    }

}
