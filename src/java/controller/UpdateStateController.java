/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.order.Order1;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.dao.OrderDAOImpl;

/**
 *
 * @author hailongluu
 */
@WebServlet(name = "UpdateStateController", urlPatterns = {"/updatestate"}, initParams = {
    @WebInitParam(name = "index", value = "0")})
public class UpdateStateController extends HttpServlet {

    

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
        OrderDAOImpl oImpl = new OrderDAOImpl();
        int id = Integer.parseInt(request.getParameter("index"));
        List<Order1> listOrder = (List<Order1>) request.getSession().getAttribute("listEmOrders");
        for(Order1 o:listOrder ){
            if(id == o.getId()){
                o.updateDeliveryState();
                oImpl.updateOrder(o);
            }
        }
        request.getSession().setAttribute("listEmOrders", null);
        response.sendRedirect(request.getContextPath()+"/confirmOrder");
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
