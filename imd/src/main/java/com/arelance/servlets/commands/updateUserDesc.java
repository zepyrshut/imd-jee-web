/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.servlets.commands;

import com.arelance.domain.Usuario;
import com.arelance.service.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "updateUserDesc", urlPatterns = {"/updateUserDesc"})
public class updateUserDesc extends HttpServlet {

    @Inject
    private UsuarioService usuarioService;

    @Inject
    private Usuario usuario;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        response.sendRedirect("./perfilusuario.jsp");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
