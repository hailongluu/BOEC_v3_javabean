/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.product.electronic.Screen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface ScreenFacadeLocal {

    void create(Screen screen);

    void edit(Screen screen);

    void remove(Screen screen);

    Screen find(Object id);

    List<Screen> findAll();

    List<Screen> findRange(int[] range);

    int count();
    
}
