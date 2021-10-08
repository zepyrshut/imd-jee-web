package com.arelance.servlets.commands;

import com.arelance.servlets.commands.qualifiers.LogOutQ;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
@LogOutQ
public class LogOut implements ActionsController {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        sesion.invalidate();
        return "/preindex";
        
    }
}
