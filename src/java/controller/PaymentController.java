/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.employee.Shipper;
import entities.order.Bill;
import entities.order.Cart;
import entities.order.Order1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.dao.OrderDAO;
import util.dao.OrderDAOImpl;

/**
 *
 * @author hailongluu
 */
@WebServlet(name = "PaymentController", urlPatterns = {"/payment"})
public class PaymentController extends HttpServlet {

 

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
         Order1 order = (Order1) request.getSession().getAttribute("order");
         String name = (String) request.getParameter("sender");
         String city = (String) request.getParameter("city");
         String add = (String) request.getParameter("address");
         String phone = (String) request.getParameter("phone");
         String shipment = (String) request.getParameter("shipment");
         String payment = (String) request.getParameter("payment");
         order.setShippingAddress(add);
         Bill bill =new Bill();
         bill.setAdd(add);
         bill.setCity(city);
         bill.setName(name);
         bill.setOrder1(order);
         bill.setPhone(phone);
         bill.setShippingMethood(shipment);
         bill.setPaymentmethod(payment);
         bill.setShipper(new Shipper(2));
         
         OrderDAO orderDAO = new OrderDAOImpl();
         
         orderDAO.addBill(bill);
         response.sendRedirect(request.getContextPath()+"/managerorder");
        System.out.println("");
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
