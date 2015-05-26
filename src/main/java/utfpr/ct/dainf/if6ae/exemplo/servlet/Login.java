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
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

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
        if (request.getMethod().equalsIgnoreCase("post")) {
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            String perfil = request.getParameter("perfil");
            if (login == null || login.trim().isEmpty() || senha == null || senha.trim().isEmpty()) {
                response.sendRedirect("erro.xhtml");
            } else {
                if (login.trim().equals(senha)) {
                    response.sendRedirect("sucesso?login=" + login + "&perfil=" + perfil);
                } else {
                    response.sendRedirect("erro.xhtml");
                }
            }
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
