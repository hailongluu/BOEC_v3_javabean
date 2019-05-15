/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.dao;

import entities.order.Bill;
import entities.order.Cart;
import entities.order.CartProduct;
import entities.order.Order1;
import entities.product.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBconnection;
import util.TimeConvert;

/**
 *
 * @author hailongluu
 */
public class OrderDAOImpl implements OrderDAO {

    Connection connection;

    public OrderDAOImpl() {
        try {
            connection = new DBconnection().getConnect();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public int addCart(Cart cart) {
        try {
            String addCart = "INSERT INTO cart (`ID`, `TotalPrice`) VALUES (?, ?);";
            String addCartProduct = "INSERT INTO cart_product (`CartID`, `ProductId`, `quantity`) VALUES ";
            cart.setId(getCartId());
            PreparedStatement pre = connection.prepareStatement(addCart);
            pre.setInt(1, cart.getId());
            pre.setLong(2, cart.getTotalPrice().longValue());
            StringBuilder sb = new StringBuilder(addCartProduct);
            for (CartProduct c : cart.getCartProductList()) {
                sb.append("(").append(cart.getId()).append(",").append("'").append(c.getProductId().getId()).append("'").append(",").append(c.getQuantity()).append("),");
            }
            sb.deleteCharAt(sb.length() - 1);

            PreparedStatement pre2 = connection.prepareStatement(sb.toString());
            String q = pre.toString();
            pre.executeUpdate();
            pre2.executeUpdate();
            return cart.getId();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getCartId() {
        try {
            String sql = "SELECT * FROM cart;";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            return id + 1;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public boolean addOrder(Order1 order) {
        try {
            String sql = "INSERT INTO order1 (`Id`, `SellerEmployeeID`, `CustomerID`, `DateCreated`, `OrderStatus`, `ShippingStatus`, `ShippingAddress`)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pre = connection.prepareStatement(sql);
            int id = addCart(order.getCart());
            pre.setInt(1, id);
            pre.setInt(2, order.getSeller().getEmployeeID());
            pre.setInt(3, order.getCustomer().getId());
            pre.setString(4, TimeConvert.convertToString(new Date()));
            pre.setString(5, order.getOrderState().getName());
            pre.setString(6, order.getDeliveryState().getName());
            pre.setString(7, order.getShippingAddress());
            String s = pre.toString();
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean addBill(Bill bill) {
        return false;
    }

    @Override
    public boolean updateOrder(Order1 order) {
        try {
            String sql = "UPDATE order1 SET `OrderStatus` = ?, `ShippingStatus` = ? WHERE (`Id` = ?);";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, order.getOrderState().getName());
            pre.setString(2, order.getDeliveryState().getName());
            pre.setInt(3, order.getCart().getId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
