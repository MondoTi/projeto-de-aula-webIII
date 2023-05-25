package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import model.Turistico;
import model.TuristicoDAO;



@WebServlet(name = "TuristicoUpdate", urlPatterns = {"/TuristicoUpdate"})
public class TuristicoUpdate extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Recebendo o ID
        int id = Integer.parseInt(request.getParameter("id"));
        
        //Pegando registro BD
        try{
            TuristicoDAO adao = new TuristicoDAO();
            Turistico tur = adao.listById(id);
            request.setAttribute("turistico", tur);
            request.getRequestDispatcher("edit-turistico.jsp").forward(request, response);
            } catch(SQLException | ClassNotFoundException erro){
        
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TuristicoUpdate</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Fudeu Bahia" + erro+ "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
