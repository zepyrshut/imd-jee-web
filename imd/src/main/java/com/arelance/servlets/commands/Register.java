package com.arelance.servlets.commands;

import com.arelance.servlets.commands.qualifiers.RegisterQ;
import com.arelance.domain.SessionData;
import com.arelance.domain.User;
import com.arelance.service.factory.Crud;
import com.arelance.service.factory.SessionDataFactory;
import com.arelance.service.factory.UserFactory;
import com.arelance.servlets.commands.qualifiers.SessionDataCrudQ;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import com.arelance.servlets.commands.qualifiers.UserCrudQ;

/**
 *
 * @author Pedro
 */
@RegisterQ
public class Register implements ActionsController {
    
    @Inject
    @UserCrudQ
    private Crud<User> crudUser;
    
    @Inject
    @SessionDataCrudQ
    private Crud<SessionData> crudSessionData;
    
    @Inject
    private UserFactory userFactory;
    
    @Inject
    private SessionDataFactory sessionDataFactory;
    
    @Inject
    private User user;
    
    @Inject
    private SessionData sessionData;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        crudUser = userFactory.createCrud();
        crudSessionData = sessionDataFactory.createCrud();

        
        user.setNombre(request.getParameter("nombre"));
        user.setApellidoA(request.getParameter("apellido_a"));
        user.setApellidoB(request.getParameter("apellido_b"));
        user.setTelefono(request.getParameter("telefono"));
        user.setEmail(request.getParameter("email"));
        
        sessionData.setContrasena(request.getParameter("contrasena"));
        sessionData.setUsuario(request.getParameter("usuario"));
        sessionData.setUsuarioSocio(user);
        
        crudUser.createEntity(user);
        crudSessionData.createEntity(sessionData);

//        if (usuarioService.findUsuarioByEmail(usuario) != null) {
//            String emailRepetido = "Ya existe este correo electrónico, pruebe otro.";
//            request.setAttribute("emailRepetido", emailRepetido);
//
//        } else {
//
//            SessionData datosSesion = new SessionData();
//            datosSesion.setUsuario(request.getParameter("usuario"));
//
//            if (datosSesionService.findDatosSesionByUsuario(datosSesion) != null) {
//                String usuarioRepetido = "Ya existe este usuario, pruebe otro.";
//                request.setAttribute("usuarioRepetido", usuarioRepetido);
//                
//            } else {
//                datosSesion.setContrasena(request.getParameter("contrasena"));
//                datosSesion.setUsuarioSocio(usuario);
//                usuarioService.addUsuario(usuario);
//                datosSesionService.addDatosSesion(datosSesion);
//                String usuarioRegistrado = "Usuario registrado con éxito, ya puedes iniciar sesión.";
//                request.setAttribute("usuarioRegistrado", usuarioRegistrado);
//
//            }
//
//        }

        return "/registrousuario.jsp";

    }

}
