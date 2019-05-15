/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.customer.Customer;
import entities.order.CartProduct;
import entities.order.Order1;
import entities.product.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ProductFacadeLocal;
import util.TimeConvert;
import util.dao.OrderDAOImpl;

/**
 *
 * @author hailongluu
 */
@WebServlet(name = "ConfirmOrder", urlPatterns = {"/confirmOrder"})
public class ConfirmOrder extends HttpServlet {

    
    @EJB
    private ProductFacadeLocal productFacade;
   

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
        List<Order1> listOrder1s = new ArrayList<>();
        List<Product> listProduct = new ArrayList<>();
//        listProduct.addAll(productFacade.findAll());
        
     
        OrderDAOImpl oImpl = new OrderDAOImpl();
        listOrder1s = oImpl.findOrderByEmId(1);

//        for(Order1 o:listOrder1s){
//            for(CartProduct c:o.getCart().getCartProductList()){
//                for(Product p:listProduct){
//                    if(p.getId().equals(c.getProductId().getId()))c.setProductId(p);
//                }
//            }
//        }
        request.getSession().setAttribute("listEmOrders", listOrder1s);
        request.getRequestDispatcher("view.jsp").forward(request, response);
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
