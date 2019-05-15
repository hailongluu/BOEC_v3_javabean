/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.product.Product;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.BookFacadeLocal;
import session.ClothesFacadeLocal;
import session.ElectronicsFacadeLocal;
import session.ProductFacadeLocal;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "ProductDetaiController", urlPatterns = {"/detail"})
public class ProductDetaiController extends HttpServlet {
    
    @EJB
    BookFacadeLocal bookFacade;
    @EJB
    ElectronicsFacadeLocal electronicsFacade;
    @EJB
    ClothesFacadeLocal clothesFacade;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
        String id = request.getParameter("id");
        int type = 0;
        Product product = null;
        if (id.charAt(0) == 'B')
            product = bookFacade.find(id).getProduct();
        else if (id.charAt(0) == 'E') {
            type = 1;
            product = clothesFacade.find(id).getProduct();
        }
        else if (id.charAt(0) == 'C') {
            type = 2;
            product = electronicsFacade.find(id).getProduct();
        }
        request.getSession().setAttribute("type", type);
        request.getSession().setAttribute("product", product);
        request.getRequestDispatcher("detail.jsp").forward(request, response);
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
