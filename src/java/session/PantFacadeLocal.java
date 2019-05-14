/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.product.clother.Pant;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface PantFacadeLocal {

    void create(Pant pant);

    void edit(Pant pant);

    void remove(Pant pant);

    Pant find(Object id);

    List<Pant> findAll();

    List<Pant> findRange(int[] range);

    int count();
    
}
