/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.product.clother.Shoes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface ShoesFacadeLocal {

    void create(Shoes shoes);

    void edit(Shoes shoes);

    void remove(Shoes shoes);

    Shoes find(Object id);

    List<Shoes> findAll();

    List<Shoes> findRange(int[] range);

    int count();
    
}
