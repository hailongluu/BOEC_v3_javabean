/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.order.CartProduct;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface CartProductFacadeLocal {

    void create(CartProduct cartProduct);

    void edit(CartProduct cartProduct);

    void remove(CartProduct cartProduct);

    CartProduct find(Object id);

    List<CartProduct> findAll();

    List<CartProduct> findRange(int[] range);

    int count();
    
}
