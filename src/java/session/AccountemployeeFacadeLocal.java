/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.employee.Accountemployee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface AccountemployeeFacadeLocal {

    void create(Accountemployee accountemployee);

    void edit(Accountemployee accountemployee);

    void remove(Accountemployee accountemployee);

    Accountemployee find(Object id);

    List<Accountemployee> findAll();

    List<Accountemployee> findRange(int[] range);

    int count();
    
}
