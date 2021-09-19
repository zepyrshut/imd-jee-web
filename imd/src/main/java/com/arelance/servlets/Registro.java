/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        usuario.setNombreUsuario(request.getParameter("nombre"));
        usuario.setApellidoUsuarioA(request.getParameter("apellido_a"));
        usuario.setApellidoUsuarioB(request.getParameter("apellido_b"));
        usuario.setTelefonoUsuario(request.getParameter("telefono"));
        usuario.setEmailUsuario(request.getParameter("email"));
       usuarioService.addUsuario(usuario);
        DatosSesion datosSesion = new DatosSesion();
        datosSesion.setUsuario(request.getParameter("usuario"));
        datosSesion.setContrasena(request.getParameter("contrasena"));  
        datosSesionService.addDatosSesion(datosSesion);
        
        
          request.getRequestDispatcher("/principal").forward(request, response);       
        
        
        
        
        
        
        
        
        
        
        
        

    }

}
