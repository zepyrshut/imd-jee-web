package com.arelance.servlets.commands;

import com.arelance.domain.MetodoPago;
import com.arelance.domain.Paypal;
import com.arelance.domain.Usuario;
import com.arelance.service.UsuarioService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "PaymentMethod", urlPatterns = {"/PaymentMethod"})
public class PaymentMethodServlet extends HttpServlet {


    @Inject
    private UsuarioService usuarioService;

    @Inject
    private Usuario usuario;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String metodopago = request.getParameter("metodopago");
        String correopaypal = request.getParameter("correopaypal");
        usuario = (Usuario) request.getSession().getAttribute("usuario");
        String stringKey = request.getParameter("stringkey");
        


        MetodoPago mp = new Paypal(correopaypal);
        mp.setNombrepago("paypal");
        mp.setUsuario(usuario);

        List<MetodoPago> metodoPago = new ArrayList<>();
        metodoPago.add(mp);        
        //usuario.getMetodoPago().add(mp);

        usuarioService.updateUsuario(usuario);
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
