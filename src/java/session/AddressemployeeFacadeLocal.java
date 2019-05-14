/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.employee.Addressemployee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface AddressemployeeFacadeLocal {

    void create(Addressemployee addressemployee);

    void edit(Addressemployee addressemployee);

    void remove(Addressemployee addressemployee);

    Addressemployee find(Object id);

    List<Addressemployee> findAll();

    List<Addressemployee> findRange(int[] range);

    int count();
    
}
