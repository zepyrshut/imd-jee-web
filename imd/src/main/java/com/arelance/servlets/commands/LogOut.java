package com.arelance.servlets.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author Pedro
 */
@Stateless
@Named(value = "logout")
public class LogOut implements ActionsController {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        sesion.invalidate();
        return "/preindex";
        
    }
}
