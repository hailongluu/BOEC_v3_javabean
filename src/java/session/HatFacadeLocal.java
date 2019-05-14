/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.product.clother.Hat;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface HatFacadeLocal {

    void create(Hat hat);

    void edit(Hat hat);

    void remove(Hat hat);

    Hat find(Object id);

    List<Hat> findAll();

    List<Hat> findRange(int[] range);

    int count();
    
}
