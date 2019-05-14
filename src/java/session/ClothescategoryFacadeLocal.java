/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.product.clother.Clothescategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface ClothescategoryFacadeLocal {

    void create(Clothescategory clothescategory);

    void edit(Clothescategory clothescategory);

    void remove(Clothescategory clothescategory);

    Clothescategory find(Object id);

    List<Clothescategory> findAll();

    List<Clothescategory> findRange(int[] range);

    int count();
    
}
