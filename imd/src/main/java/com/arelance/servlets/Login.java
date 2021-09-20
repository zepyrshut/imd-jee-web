/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.servlets;

import com.arelance.dao.DatosSesionDAO;
import com.arelance.domain.DatosSesion;
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
 * @author jorge
 */
 @WebServlet("/loginServlet")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
  private DatosSesionDAO datosSesionDAO; //añadir metodo comprobarsesion en dao (pasar todo a capa servicio y usarla)
        

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
      DatosSesion datosSesion = new DatosSesion();
     String nombre = request.getParameter("username");
     String password = request.getParameter("password");
    //  String contrasena = request.getParameter("contrasena");
 
     datosSesion.setUsuario(nombre);
     datosSesion.setContrasena(password);
     
        if (datosSesionDAO.validarSesionBueno(datosSesion)) {
            
        }
     
     
     
     
     
     
     //--------------------------------------
//        try { verificar este , ver por que no deja convertir void a boolean
//            if (datosSesionDAO.validarSesion(datosSesion)) {
//                response.sendRedirect("index.jsp");
//            } else {
//                  HttpSession session = request.getSession();
//                  
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//--------------------------------------

//
//--------------------------------------
//        try {
//            datosSesionDAO.validarSesion(datosSesion);
//             HttpSession session = request.getSession();
//      
//            response.sendRedirect("index.jsp"); //si es true, manda a index con sesion iniciada, si es false, donde compruebo el error?
//        } catch (Exception e) { //pillar el error que salga cuando el login sea incorrecto y redirecciona a login.jsp con dicho error.
//            e.printStackTrace();
//        }
//        
  //--------------------------------------      
//--------------------------------------
//        if (datosSesionDAO.validarSesion1(datosSesion.getUsuario(),datosSesion.getContrasena())) {
//            response.sendRedirect("index.jsp");
//        } else {
//             response.sendRedirect("indasdsaex.jsp");
//        }
   //--------------------------------------
    }


}
