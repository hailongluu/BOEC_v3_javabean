package util.dao;

import entities.order.Bill;
import entities.order.Cart;
import entities.order.Order1;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBconnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hailongluu
 */
public interface OrderDAO {

    int addCart(Cart cart);
    
    int addOrder(Order1 order);
    
    boolean addBill(Bill bill);
    boolean updateOrder(Order1 order);
}
