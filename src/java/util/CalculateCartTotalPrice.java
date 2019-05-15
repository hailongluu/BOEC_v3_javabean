/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entities.order.Cart;
import entities.order.CartProduct;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class CalculateCartTotalPrice {
    
    public static BigInteger calculate(Cart cart) {
        BigInteger totalPrice = new BigInteger("0");
        ArrayList<CartProduct> listCartProducts = new ArrayList<>();
        listCartProducts.addAll(cart.getCartProductList());
        for (CartProduct cp : listCartProducts) {
            BigInteger price = cp.getProductId().getPrice();
            totalPrice = totalPrice.add(price.multiply(new BigInteger(Integer.toString(cp.getQuantity()))));
        }
        return totalPrice;
    }
}
