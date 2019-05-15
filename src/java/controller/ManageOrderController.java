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
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.Order1FacadeLocal;
import session.ProductFacadeLocal;
import util.TimeConvert;
import util.dao.OrderDAOImpl;

/**
 *
 * @author hailongluu
 */
@WebServlet(name = "ManageOrderController", urlPatterns = {"/managerorder"})
public class ManageOrderController extends HttpServlet {

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
        List<Order1> listOrder1s1 = new ArrayList<>();
        List<Order1> listOrder1s2 = new ArrayList<>();
        List<Order1> listOrder1s3 = new ArrayList<>();
        List<Product> listProduct = new ArrayList<>();
        listProduct.addAll(productFacade.findAll());
        
        
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        OrderDAOImpl oImpl = new OrderDAOImpl();
        listOrder1s = oImpl.findOrderByCusId(customer.getId());

        for(Order1 o:listOrder1s){
            for(CartProduct c:o.getCart().getCartProductList()){
                for(Product p:listProduct){
                    if(p.getId().equals(c.getProductId().getId()))c.setProductId(p);
                }
            }
        }
        for (Order1 o : listOrder1s) {
            switch (o.getShippingStatus()) {
                case "Packaged": {
                    listOrder1s1.add(o);
                    break;
                }
                case "Shipped": {
                    listOrder1s2.add(o);
                    break;
                }
                case "OutForDelivery": {
                    listOrder1s2.add(o);
                    break;
                }
                case "Delivered": {
                    listOrder1s3.add(o);
                    break;
                }
                default:
                    break;
            }
        }
        
                Order1 o = new Order1();
                o.getShippingAddress();
        request.getSession().setAttribute("listOrders", listOrder1s);
        request.getSession().setAttribute("listOrders1", listOrder1s1);
        request.getSession().setAttribute("listOrders2", listOrder1s2);
        request.getSession().setAttribute("listOrders3", listOrder1s3);

        request.getRequestDispatcher("manage.jsp").forward(request, response);
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
