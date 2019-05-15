/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.dao;

import entities.customer.Customer;
import entities.order.Cart;
import entities.order.CartProduct;
import entities.order.Order1;
import entities.product.Product;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBconnection;

/**
 *
 * @author hailongluu
 */
public class CustomerDAOImpl {

    Connection connection;

    public CustomerDAOImpl() {
        try {
            connection = new DBconnection().getConnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean addCustomer(Customer customer) {
        try {
            int id = getCusId();
            String sqlCus = "INSERT INTO customer (`ID`, `Account`, `Name`, `Address`, `Phone`) VALUES (?, ?, ?, ?, ?);";
            String sqlAcc = "INSERT INTO accountcustomer (`ID`, `Username`, `Password`) VALUES (?, ?, ?);";
            String sqlName = "INSERT INTO fullnamecustomer (`ID`, `Firstname`, `Lastname`) VALUES (?, ?, ?);";
            String sqlAdd = "INSERT INTO addresscustomer (`ID`, `Street`) VALUES (?, ?);";
            PreparedStatement preCus = connection.prepareStatement(sqlCus);
            PreparedStatement preAdd = connection.prepareStatement(sqlAdd);
            PreparedStatement preName = connection.prepareStatement(sqlName);
            PreparedStatement preAcc = connection.prepareStatement(sqlAcc);

            preAcc.setInt(1, id);
            preAcc.setString(2, customer.getAccount().getUsername());
            preAcc.setString(3, customer.getAccount().getPassword());

            preAdd.setInt(1, id);
            preAdd.setString(2, customer.getAddress().getStreet());

            preName.setInt(1, id);
            preName.setString(2, customer.getName().getFirstname());
            preName.setString(3, customer.getName().getLastname());

            preCus.setInt(1, id);
            preCus.setInt(2, id);
            preCus.setInt(3, id);
            preCus.setInt(4, id);
            preCus.setString(5, customer.getPhone());
            
            String s = preCus.toString();
            preAcc.executeUpdate();
            preAdd.executeUpdate();
            preName.executeUpdate();
            preCus.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public int getCusId() {
        try {
            String sql = "SELECT * FROM customer";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            return id + 1;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
}
