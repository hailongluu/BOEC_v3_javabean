/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.customer.Customer;
import entities.employee.Seller;
import entities.order.Cart;
import entities.order.CartProduct;
import entities.order.Order1;
import entities.order.state.Confirmed;
import entities.order.state.DeliveryState;
import entities.order.state.OrderState;
import entities.order.state.Packaged;
import entities.product.Product;
import entities.product.book.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.BookFacadeLocal;
import session.Order1FacadeLocal;
import util.dao.OrderDAO;
import util.dao.OrderDAOImpl;

/**
 *
 * @author hailongluu
 */
@WebServlet(name = "TestDAOController", urlPatterns = {"/test"})
public class TestDAOController extends HttpServlet {


    @EJB
    private BookFacadeLocal bookFacade;

 
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderDAO orderDAO = new OrderDAOImpl();
        List<Book> listProducts = bookFacade.findAll();
        Cart cart = new Cart();
        List<CartProduct> listCartProducts = new ArrayList<>();
        for (Book b : listProducts) {
            CartProduct cartProduct = new CartProduct();
            Product p = b.getProduct();
            cartProduct.setProductId(p);
            cartProduct.setQuantity(10);
            listCartProducts.add(cartProduct);
        }
        cart.setCartProductList(listCartProducts);
        cart.setTotalPrice(new BigInteger("123"));
        
        OrderState orderState = new Confirmed();
        DeliveryState deliveryState = new Packaged();
        Customer customer =new Customer(1);
        Seller seller = new Seller(1);
        
        Order1 order1 = new Order1();
        order1.setCart(cart);
        order1.setCustomer(customer);
        order1.setSeller(seller);
        order1.setOrderState(orderState);
        order1.setDeliveryState(deliveryState);
        order1.setShippingAddress("Ha noi");
        
        orderDAO.addOrder(order1);
        order1.updateDeliveryState();
        order1.updateOrderState();
        System.out.println("");
        orderDAO.updateOrder(order1);
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
