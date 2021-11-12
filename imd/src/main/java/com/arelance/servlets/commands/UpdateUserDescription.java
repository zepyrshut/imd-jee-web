package com.arelance.servlets.commands;

import com.arelance.domain.Usuario;
import com.arelance.service.UsuarioService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge
 */
@WebServlet("/updateuserdescription")
public class UpdateUserDescription implements ActionsController {

    @Inject
    private UsuarioService usuarioService;

    @Inject
    private Usuario usuario;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        usuario = (Usuario) request.getSession().getAttribute("usuario");

        String name = request.getParameter("name");
        String middlename = request.getParameter("profilemiddlename");
        String lastname = request.getParameter("profilelastname");
        String mail = request.getParameter("profilemail");
        String phone = request.getParameter("profilephone");
        
        if (!usuario.getNombre().equals(name)) {
            usuario.setNombre(name);
        }
        if (!usuario.getApellidoA().equals(middlename)) {
            usuario.setApellidoA(middlename);
        }
        if (!usuario.getApellidoB().equals(lastname)) {
            usuario.setApellidoB(lastname);
        }
        if (!usuario.getEmail().equals(mail)) {
            usuario.setEmail(mail);
        }
        if (!usuario.getTelefono().equals(phone)) {
            usuario.setTelefono(phone);
        }

        usuarioService.updateUsuario(usuario);
        return "/perfilusuario.jsp";
    }

}
