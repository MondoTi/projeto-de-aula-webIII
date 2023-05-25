
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

@WebServlet(name = "CadastroTuristico", urlPatterns = {"/CadastroTuristico"})
public class CadastroTuristico extends HttpServlet {
    private int id;
    private String ponto;
    private String historia;
    private String regiao;
    private int praca;
    private int monumento;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Verificar se há um ID
        if(request.getParameter("id")!=null){
            this.id = Integer.parseInt(request.getParameter("id"));
            
        }
        
        
        //Recebendo valores formulario de cadastro
        this.ponto = request.getParameter("ponto");
        this.historia = request.getParameter("historia");
        this.regiao = request.getParameter("regiao");
        if(request.getParameter("praca")!=null){
            this.praca =1;
        }else {
            this.praca =0;
        }
         if(request.getParameter("monumento")!=null){
            this.monumento =1;
        }else {
            this.monumento =0;
        }
        
        //Criando objeto da classe Artista para salvar no B.D 
        Turistico turistico = new Turistico(
                this.ponto,
                this.historia,
                this.regiao,
                this.praca,
                this.monumento
        );
        
        
        
        //Instanciar a Classe Dao para usar o metodo
        //De inserção enviando o objeto criado acima
        try{
            TuristicoDAO adao = new TuristicoDAO();
            
            //se tivermos um ID, atualizaremos o registro
            //se não salvaremos como um novo registro
            if(request.getParameter("id")!=null){
                turistico.setIdTuristico(this.id);
                adao.updateTuristico(turistico);
            }else{
                adao.insertTuristico(turistico);
            }
                response.sendRedirect("lista.jsp");
            
        }catch(ClassNotFoundException | SQLException erro) {
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroTuristico</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Deu Ruim " + erro + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        }
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
