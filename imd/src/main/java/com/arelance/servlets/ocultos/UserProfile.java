package com.arelance.servlets.ocultos;

import com.arelance.domain.Usuario;
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
@WebServlet("/userprofile")
public class UserProfile extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    UsuarioService usuarioService;

    @Inject
    Usuario usuario;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        usuario = (Usuario) request.getSession().getAttribute("usuario");
        //usuario = usuarioService.refrescar(usuario);
        //usuario = usuarioService.findUsuarioById(usuario.getIdUsuario());
        request.getSession().setAttribute("usuario", usuario);
        request.getRequestDispatcher("./perfilusuario.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
