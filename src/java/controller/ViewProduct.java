package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entities.customer.Accountcustomer;
import entities.customer.Customer;
import entities.product.Product;
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
import session.AccountcustomerFacadeLocal;
import session.BookFacadeLocal;
import session.ClothesFacadeLocal;
import session.CustomerFacadeLocal;
import session.ElectronicsFacadeLocal;
import session.ProductFacadeLocal;

/**
 *
 * @author hailongluu
 */
@WebServlet(urlPatterns = {"/view"})
public class ViewProduct extends HttpServlet {

    @EJB
    private ClothesFacadeLocal clothesFacade;

    @EJB
    private ElectronicsFacadeLocal electronicsFacade;

    @EJB
    private BookFacadeLocal bookFacade;

    @EJB
    private AccountcustomerFacadeLocal accountcustomerFacade;

    @EJB
    private CustomerFacadeLocal customerFacade;

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
        List<Product> products = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Accountcustomer> ac = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        List<Clothes> listClothers =new ArrayList<>();
        List<Electronics> listElectronicses = new ArrayList<>();
        listClothers.addAll(clothesFacade.findAll());
        listElectronicses.addAll(electronicsFacade.findAll());
        books = bookFacade.findAll();
        
        customers.addAll(customerFacade.findAll());
        products.addAll(productFacade.findAll());
        ac.addAll(accountcustomerFacade.findAll());
        products.add(productFacade.find("C0001"));
        request.getSession().setAttribute("listProducts", products);
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
