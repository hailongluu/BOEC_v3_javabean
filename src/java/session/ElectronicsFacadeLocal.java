/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.product.electronic.Electronics;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface ElectronicsFacadeLocal {

    void create(Electronics electronics);

    void edit(Electronics electronics);

    void remove(Electronics electronics);

    Electronics find(Object id);

    List<Electronics> findAll();

    List<Electronics> findRange(int[] range);

    int count();
    
}
