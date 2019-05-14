/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.product.electronic.Ram;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface RamFacadeLocal {

    void create(Ram ram);

    void edit(Ram ram);

    void remove(Ram ram);

    Ram find(Object id);

    List<Ram> findAll();

    List<Ram> findRange(int[] range);

    int count();
    
}
