package com.arelance.servlets;

import com.arelance.domain.DatosSesion;
import com.arelance.domain.Usuario;
import com.arelance.service.DatosSesionService;
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
@WebServlet("/registro")
public class Registro extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioService usuarioService;

    @Inject
    private DatosSesionService datosSesionService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  

        Usuario usuario = new Usuario();
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setApellidoA(request.getParameter("apellido_a"));
        usuario.setApellidoB(request.getParameter("apellido_b"));
        usuario.setTelefono(request.getParameter("telefono"));
        usuario.setEmail(request.getParameter("email"));

        DatosSesion datosSesion = new DatosSesion();
        datosSesion.setUsuario(request.getParameter("usuario"));
        datosSesion.setContrasena(request.getParameter("contrasena"));
        datosSesion.setUsuario1(usuario);
      
        usuarioService.addUsuario(usuario);
        datosSesionService.addDatosSesion(datosSesion);
        
        request.getRequestDispatcher("/principal").forward(request, response);

    }

}
