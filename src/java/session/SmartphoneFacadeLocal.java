/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.product.electronic.Smartphone;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface SmartphoneFacadeLocal {

    void create(Smartphone smartphone);

    void edit(Smartphone smartphone);

    void remove(Smartphone smartphone);

    Smartphone find(Object id);

    List<Smartphone> findAll();

    List<Smartphone> findRange(int[] range);

    int count();
    
}
