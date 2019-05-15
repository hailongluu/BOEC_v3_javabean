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
import entities.order.state.*;
import entities.order.state.Shipped;
import entities.product.Product;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    public int addOrder(Order1 order) {
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
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public boolean addBill(Bill bill) {
        try {
            String sql = "INSERT INTO bill (`ID`, `ShipperEmployeeID`, `ShippingMethood`, `Paymentmethod`, `name`, `city`, `add`, `phone`)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pre = connection.prepareStatement(sql);
            int id = addOrder(bill.getOrder1());
            pre.setInt(1, id);
            pre.setInt(2, bill.getShipper().getEmployeeID());
            pre.setString(3, bill.getShippingMethood());
            pre.setString(4, bill.getPaymentmethod());
            pre.setString(5, bill.getName());
            pre.setString(6, bill.getCity());
            pre.setString(7, bill.getAdd());
            pre.setString(8, bill.getPhone());
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateOrder(Order1 order) {
        try {
            String sql = "UPDATE order1 SET `ShippingStatus` = ? WHERE (`Id` = ?);";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, order.getDeliveryState().getName());
            pre.setInt(2, order.getId());
            String s=pre.toString();
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<CartProduct> findCartProducts(int id) {
        try {
            List<CartProduct> list = new ArrayList<>();
            String sql = "SELECT * FROM cart_product WHERE CartID =?;";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CartProduct cartProduct = new CartProduct();
                cartProduct.setProductId(new Product(rs.getString(3)));
                cartProduct.setQuantity(rs.getInt(4));
                list.add(cartProduct);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Cart findCartById(int id) {
        try {
            Cart cart = new Cart(id);
            String sql = "SELECT * FROM cart WHERE ID =?;";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                cart.setTotalPrice(new BigInteger(rs.getString(2)));
                List<CartProduct> list = new ArrayList<>();
                list = findCartProducts(id);
                cart.setCartProductList(list);
            }
            return cart;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Order1> findOrderByCusId(int id) {
        try {
            List<Order1> list = new ArrayList<>();
            String sql = "SELECT * FROM order1 WHERE CustomerID = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Order1 order = new Order1(rs.getInt(1));
                order.setShippingAddress(rs.getString(7));
                order.setOrderStatus(rs.getString(5));
                order.setDateCreated(TimeConvert.converToDate(rs.getString(4)));
                order.setShippingStatus(rs.getString(6));
                Cart cart = findCartById(rs.getInt(1));
                order.setCart(cart);
                list.add(order);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public List<Order1> findOrderByEmId(int id) {
        try {
            List<Order1> list = new ArrayList<>();
            String sql = "SELECT * FROM order1 WHERE SellerEmployeeID = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Order1 order = new Order1(rs.getInt(1));
                order.setShippingAddress(rs.getString(7));
                order.setOrderStatus(rs.getString(5));
                order.setDateCreated(TimeConvert.converToDate(rs.getString(4)));
                order.setShippingStatus(rs.getString(6));
                order.setDeliveryState(getShippingState(order.getShippingStatus()));
                Cart cart = findCartById(rs.getInt(1));
                order.setCart(cart);
                list.add(order);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public DeliveryState getShippingState(String state){
        switch (state) {
                case "Packaged": {
                    return Packaged.getInstance();
                }
                case "Shipped": {
                    return Shipped.getInstance();
                }
                case "OutForDelivery": {
                    return OutForDelivery.getInstance();
                }
                case "Delivered": {
                   return Delivered.getInstance();
                }
                default:
                    return null;
            }
    }

}
