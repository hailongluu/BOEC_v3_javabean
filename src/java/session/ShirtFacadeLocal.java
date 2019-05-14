/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.product.clother.Shirt;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface ShirtFacadeLocal {

    void create(Shirt shirt);

    void edit(Shirt shirt);

    void remove(Shirt shirt);

    Shirt find(Object id);

    List<Shirt> findAll();

    List<Shirt> findRange(int[] range);

    int count();
    
}
