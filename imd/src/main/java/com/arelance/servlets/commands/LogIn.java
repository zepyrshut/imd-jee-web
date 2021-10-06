package com.arelance.servlets.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.arelance.servlets.MainCommand;

/**
 *
 * @author Pedro
 */
public class LogIn implements MainCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        return "successLogIn";
    }
}
