package utfpr.ct.dainf.if6ae.exemplo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Universidade Tecnológica Federal do Paraná
 * IF6AE Desenvolvimento de Aplicaçoões Web
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
@WebServlet(name = "Ola Servlet", urlPatterns = {"/ola"})
public class OlaServlet extends HttpServlet {

    /**
     * Processa requisições HTTP para os métodos
     * <code>GET</code> e
     * <code>POST</code>.
     *
     * @param request Requisição
     * @param response Resposta
     * @throws ServletException Se ocorrer um exceção específica de Servlet
     * @throws IOException Se ocorrer uma exceção de E/S
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" "
                    + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Modelo de Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Exemplo de Servlet Simples em " + request.getContextPath() + "</h1>");
            out.println("<form action='ola' method='post'>");
            out.println("Nome: <input type='text' name='nome'/><br/>");
            out.println("<input type='submit' value='Enviar'/><br/>");
            out.println("</form>");
            String nome = request.getParameter("nome");
            if  (request.getMethod().equalsIgnoreCase("post")) {
                if (nome == null || nome.trim().isEmpty()) {
                    out.println("<h2 style='color: red'>Informe o nome!</h2>");
                } else {
                    out.println("<h2>Olá, " + nome + "</h2>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Processa a requisição HTTP para o método
     * <code>GET</code>.
     *
     * @param request Requisição
     * @param response Resposta
     * @throws ServletException Se ocorrer um exceção específica de Servlet
     * @throws IOException Se ocorrer uma exceção de E/S
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Processa a requisição HTTP para o método
     * <code>POST</code>.
     *
     * @param request Requisição
     * @param response Resposta
     * @throws ServletException Se ocorrer um exceção específica de Servlet
     * @throws IOException Se ocorrer uma exceção de E/S
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Retorna uma descrição resumida do servlet.
     * @return Uma descrição resumida.
     */
    @Override
    public String getServletInfo() {
        return "Exemplo de servlet simples";
    }// </editor-fold>
}
