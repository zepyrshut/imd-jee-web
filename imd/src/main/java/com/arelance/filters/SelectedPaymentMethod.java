package com.arelance.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Pedro
 */
public class SelectedPaymentMethod implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String selectedPaymentMethod = request.getParameter("metodopago");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        httpRequest.getSession().setAttribute("metodopago", selectedPaymentMethod);

        chain.doFilter(request, response);
    }

}
