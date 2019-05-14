/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.product.electronic.Laptop;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface LaptopFacadeLocal {

    void create(Laptop laptop);

    void edit(Laptop laptop);

    void remove(Laptop laptop);

    Laptop find(Object id);

    List<Laptop> findAll();

    List<Laptop> findRange(int[] range);

    int count();
    
}
