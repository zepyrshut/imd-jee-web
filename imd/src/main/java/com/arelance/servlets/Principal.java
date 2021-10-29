package com.arelance.servlets;

import com.arelance.domain.Actividad;
import com.arelance.service.ActividadService;
import java.io.IOException;
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
@WebServlet("/principal")
public class Principal extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private ActividadService actividadService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean bandera = false;
       int page = 1;
       int recordsPerPage = 6;
       List<List<Actividad>> listaCompleta = null;
       // if (request.getParameter("page") != null) {
        //    page = Integer.parseInt(request.getParameter("page"));
       // }
        while (!bandera) {            
              List<Actividad> list = actividadService.allPaginatedActivities((page) * recordsPerPage, recordsPerPage);
            page = page + 1;
            recordsPerPage = recordsPerPage + 6; 
              if (list.size() < 6) {
                bandera = true;
            }
            
            listaCompleta.add(list);
            
         
        } 
      
               
        int noOfRecords = actividadService.getNoOfRecords();
        int noOfPages = (int) (noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("actividadesPaginacion", listaCompleta);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        
        

        request.setAttribute("listaActividad", actividadService.listarActividades());
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

}
