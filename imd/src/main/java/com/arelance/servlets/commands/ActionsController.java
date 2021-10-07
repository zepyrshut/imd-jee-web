package com.arelance.servlets.commands;

import java.io.IOException;
import javax.ejb.Local;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Pedro
 */
@Local
@FunctionalInterface
public interface ActionsController {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
}
