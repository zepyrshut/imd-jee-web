package com.arelance.servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Pedro
 */
@FunctionalInterface
public interface ServletAction {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
}
