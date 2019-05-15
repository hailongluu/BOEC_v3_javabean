/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.order.Cart;
import entities.order.CartProduct;
import entities.product.Product;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.BookFacadeLocal;
import session.ClothesFacadeLocal;
import session.ElectronicsFacadeLocal;
import session.ProductFacadeLocal;
import util.CalculateCartTotalPrice;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "DetailAddedController", urlPatterns = {"/detailAdded"})
public class ProductDetailDetailAddedController extends HttpServlet {

    @EJB
    private ElectronicsFacadeLocal electronicsFacade;

    @EJB
    private ProductFacadeLocal productFacade;
    
    @EJB
    private BookFacadeLocal bookFacade;
    
    @EJB
    private ClothesFacadeLocal clothesFacade;
    
    

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
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        Product product = productFacade.find(id);
        // check cart
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            cart.setTotalPrice(new BigInteger("0"));
            session.setAttribute("cart", cart);
        }
        ArrayList<CartProduct> listCartProduct = new ArrayList<>();
        if (cart.getCartProductList() != null)
            listCartProduct.addAll(cart.getCartProductList());
        
        boolean alreadyExist = false;
        for (CartProduct cp : listCartProduct) {
            if (cp.getProductId().getId().equals(id)) {
                cp.setQuantity(cp.getQuantity() + quantity);
                alreadyExist = true;
                break;
            }
        }
        if (!alreadyExist) {
            CartProduct cartProduct = new CartProduct();
            cartProduct.setProductId(product);
            cartProduct.setQuantity(quantity);
            listCartProduct.add(cartProduct);
        }
        cart.setCartProductList(listCartProduct);
        cart.setTotalPrice(CalculateCartTotalPrice.calculate(cart));
        checkType(id, request);
        request.getRequestDispatcher("detail_added.jsp").forward(request, response);
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
        //get request params
        
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

    private void checkType(String id, HttpServletRequest request) {
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
        request.setAttribute("type", type);
        request.setAttribute("product", product);
    }
}
