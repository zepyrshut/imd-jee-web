package com.arelance.servlets.commands;

import com.arelance.qualifiers.LogOutQ;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The {@code LogOut} class is an implementation of the logout command pattern.
 * 
 * The {@code execute} method retrieves the current session on request and 
 * invalidates it with the {@code invalidate} method.
 * 
 * It returns a {@code String} type data, always is "/preindex".
 *
 * @author Pedro
 * @since 1.0
 */
@LogOutQ
public class LogOut implements ActionsController {

    /**
     * 
     * @param request
     * @param response
     * @return String "/preindex"
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();
        return "/preindex";
        
    }
}
