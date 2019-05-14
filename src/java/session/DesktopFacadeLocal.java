/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.product.electronic.Desktop;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface DesktopFacadeLocal {

    void create(Desktop desktop);

    void edit(Desktop desktop);

    void remove(Desktop desktop);

    Desktop find(Object id);

    List<Desktop> findAll();

    List<Desktop> findRange(int[] range);

    int count();
    
}
