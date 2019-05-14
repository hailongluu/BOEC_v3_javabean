/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.employee.Seller;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface SellerFacadeLocal {

    void create(Seller seller);

    void edit(Seller seller);

    void remove(Seller seller);

    Seller find(Object id);

    List<Seller> findAll();

    List<Seller> findRange(int[] range);

    int count();
    
}
