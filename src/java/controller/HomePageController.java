/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.product.book.Book;
import entities.product.clother.Clothes;
import entities.product.electronic.Electronics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.apache.webbeans.jsf.JSFUtil.getSession;
import session.BookFacadeLocal;
import session.ClothesFacadeLocal;
import session.ElectronicsFacade;
import session.ElectronicsFacadeLocal;
import session.ProductFacadeLocal;

/**
 *
 * @author hailongluu
 */
@WebServlet(name = "HomePageController", urlPatterns = {"/home"})
public class HomePageController extends HttpServlet {
    
    @EJB
//    private ProductFacadeLocal productFacade;
    private BookFacadeLocal bookFacade;
    @EJB
    private ElectronicsFacadeLocal electronicsFacade;
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
        
//        List<Product> listProducts = new ArrayList<>();
//        listProducts.addAll(productFacade.findAll());
        List<Book> listBooks = new ArrayList<>();
        List<Electronics> listElectronics = new ArrayList<>();
        List<Clothes> listClothes = new ArrayList<>();
        listBooks.addAll(bookFacade.findAll());
        listElectronics.addAll(electronicsFacade.findAll());
        listClothes.addAll(clothesFacade.findAll());
//        request.getSession().setAttribute("listProducts", listProducts);
        request.getSession().setAttribute("listBooks", listBooks);
        request.getSession().setAttribute("listElectronics", listElectronics);
        request.getSession().setAttribute("listClothes", listClothes);

        request.getRequestDispatcher("index.jsp").forward(request, response);
        
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