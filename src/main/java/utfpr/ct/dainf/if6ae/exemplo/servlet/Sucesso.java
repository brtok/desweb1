package utfpr.ct.dainf.if6ae.exemplo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Universidade Tecnológica Federal do Paraná IF6AE Desenvolvimento de
 * Aplicaçoões Web
 *
 * @author Bruno
 */
@WebServlet(name = "Sucesso", urlPatterns = {"/sucesso"})
public class Sucesso extends HttpServlet {

    /**
     * Processa requisições HTTP para os métodos <code>GET</code> e
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
            String login = request.getParameter("login");
            String perfil = request.getParameter("perfil");
            switch (Integer.valueOf(perfil)) {
                case 1:
                    perfil = "Cliente";
                    break;
                case 2:
                    perfil = "Gerente";
                    break;
                case 3:
                    perfil = "Administrador";
                    break;
                default:
                    response.sendRedirect("erro.xhtml");
                    break;
            }
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" "
                    + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sucesso</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Acesso a " + perfil + " " + login + " permitido</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Processa a requisição HTTP para o método <code>GET</code>.
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
     * Processa a requisição HTTP para o método <code>POST</code>.
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
     *
     * @return Uma descrição resumida.
     */
    @Override
    public String getServletInfo() {
        return "Exemplo de servlet simples";
    }// </editor-fold>
}
