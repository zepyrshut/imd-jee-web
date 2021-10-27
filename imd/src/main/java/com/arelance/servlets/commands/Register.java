package com.arelance.servlets.commands;

import com.arelance.qualifiers.RegisterQ;
import com.arelance.domain.SessionData;
import com.arelance.domain.UserImd;
import com.arelance.service.impl.SessionDataCrud;
import com.arelance.service.impl.UserCrud;
import com.arelance.qualifiers.SessionDataCrudQ;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import com.arelance.qualifiers.UserCrudQ;

/**
 *
 * @author Pedro
 */
@RegisterQ
public class Register implements ActionsController {

    @Inject
    @UserCrudQ
    private UserCrud userCrud;

    @Inject
    @SessionDataCrudQ
    private SessionDataCrud sessionDataCrud;

    @Inject
    private UserImd userImd;

    @Inject
    private SessionData sessionData;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        userImd.setName(request.getParameter("nombre"));
        userImd.setSurnameA(request.getParameter("apellido_a"));
        userImd.setSurnameB(request.getParameter("apellido_b"));
        userImd.setPhone(request.getParameter("telefono"));
        userImd.setEmail(request.getParameter("email"));

        sessionData.setPassword(request.getParameter("contrasena"));
        sessionData.setUser(request.getParameter("usuario"));
        sessionData.setUserSessionData(userImd);

        userCrud.createEntity(userImd);
        sessionDataCrud.createEntity(sessionData);

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
