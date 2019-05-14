/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.customer.Fullnamecustomer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface FullnamecustomerFacadeLocal {

    void create(Fullnamecustomer fullnamecustomer);

    void edit(Fullnamecustomer fullnamecustomer);

    void remove(Fullnamecustomer fullnamecustomer);

    Fullnamecustomer find(Object id);

    List<Fullnamecustomer> findAll();

    List<Fullnamecustomer> findRange(int[] range);

    int count();
    
}
