/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.servlets.commands;

import com.arelance.domain.MetodoPago;
import com.arelance.domain.Usuario;
import com.arelance.service.PaymentMethodService;
import com.arelance.service.UsuarioService;
import com.arelance.servlets.commands.qualifiers.DeleteUserQ;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
//@DeleteUserQ
@WebServlet(name = "deletedPaymentMethod", urlPatterns = {"/deletedPaymentMethod"})
public class DeletedPaymentMethod extends HttpServlet {

    @Inject
    private UsuarioService usuarioService;
    @Inject
    private PaymentMethodService paymentMethodService;
    
    @Inject
    private MetodoPago metodoPago;
    
    @Inject
    private Usuario usuario;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     usuario = (Usuario) request.getSession().getAttribute("usuario");
     
     

        String metodoPago1 = request.getParameter("metodoPago");
       MetodoPago metodofinal = paymentMethodService.findMethodByDescription(metodoPago1); // no vale find descripcion
       //a menos de que se eviten duplicados, usar ID
        paymentMethodService.removePaymentMethod(metodofinal); //LLAMADA OBJETO
        // EVITAR DRY, LLAMAR A METODO LogOut.
        // HttpSession sesion = request.getSession();
         //   sesion.invalidate();
     // CERRAR SESION  Y MANDAR A INDEX
        response.sendRedirect("./index.jsp");
       
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
