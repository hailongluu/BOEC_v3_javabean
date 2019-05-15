/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.customer.Customer;
import entities.employee.Seller;
import entities.order.Cart;
import entities.order.Order1;
import entities.order.state.Confirmed;
import entities.order.state.DeliveryState;
import entities.order.state.OrderState;
import entities.order.state.Packaged;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hailongluu
 */
@WebServlet(name = "MakeOrderController", urlPatterns = {"/makeorder"})
public class MakeOrderController extends HttpServlet {

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
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        OrderState orderState = new Confirmed();
        DeliveryState deliveryState = new Packaged();
        Seller seller = new Seller(1);
        Order1 order1 = new Order1();
        order1.setCart(cart);
        order1.setCustomer(customer);
        order1.setSeller(seller);
        order1.setOrderState(orderState);
        order1.setDeliveryState(deliveryState);
        request.getSession().setAttribute("order", order1);
        request.getRequestDispatcher("payment.jsp").forward(request, response);
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
