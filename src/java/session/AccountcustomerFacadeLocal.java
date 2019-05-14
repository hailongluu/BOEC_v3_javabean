/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.customer.Accountcustomer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface AccountcustomerFacadeLocal {

    void create(Accountcustomer accountcustomer);

    void edit(Accountcustomer accountcustomer);

    void remove(Accountcustomer accountcustomer);

    Accountcustomer find(Object id);

    List<Accountcustomer> findAll();

    List<Accountcustomer> findRange(int[] range);

    int count();
    
}
