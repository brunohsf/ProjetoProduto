package br.com.projetoproduto.controller;

import br.com.projetoproduto.dao.GenericDAO;
import br.com.projetoproduto.dao.CarroDAOImpl;
import br.com.projetoproduto.model.Carro;
import br.com.projetoproduto.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarProduto", urlPatterns = {"/AlterarProduto"})
public class AlterarProduto extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
            Integer idProduto = Integer.parseInt(request.getParameter("idProduto"));
            String descProduto = request.getParameter("descProduto");
            String marcaProduto = request.getParameter("marcaProduto");
            String modeloProduto = request.getParameter("modeloProduto");
            Double valorProduto = Double.parseDouble(request.getParameter("valorProduto"));
            Integer anoCarro = Integer.parseInt(request.getParameter("anoCarro"));
            Integer modeloCarro = Integer.parseInt(request.getParameter("modeloCarro"));
            Integer nrportasCarro = Integer.parseInt(request.getParameter("nrportasCarro"));

            String mensagem = null;

            Carro produto = new Carro();
            produto.setIdProduto(idProduto);
            produto.setDescProduto(descProduto);
            produto.setMarcaProduto(marcaProduto);
            produto.setModeloProduto(modeloProduto);
            produto.setValorProduto(valorProduto);
            produto.setAnoCarro(anoCarro);
            produto.setModeloCarro(modeloCarro);
            produto.setNrportasCarro(nrportasCarro);

            try {
                GenericDAO dao = new CarroDAOImpl();
                if (dao.alterar(produto)) {
                    mensagem = "Produto alterado com sucesso!";
                } else {
                    mensagem = "Problemas ao alterar Produto. "
                            + "Verifique os dados informados e tente novamente!";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("ListarProduto").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Problemas no Servlet ao alterar Produto! Erro: "
                        + ex.getMessage());
                ex.printStackTrace();
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
