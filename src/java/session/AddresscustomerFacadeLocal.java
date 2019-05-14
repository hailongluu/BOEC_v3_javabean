/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.customer.Addresscustomer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface AddresscustomerFacadeLocal {

    void create(Addresscustomer addresscustomer);

    void edit(Addresscustomer addresscustomer);

    void remove(Addresscustomer addresscustomer);

    Addresscustomer find(Object id);

    List<Addresscustomer> findAll();

    List<Addresscustomer> findRange(int[] range);

    int count();
    
}
