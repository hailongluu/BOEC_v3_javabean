/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.employee.Fullnameemployee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface FullnameemployeeFacadeLocal {

    void create(Fullnameemployee fullnameemployee);

    void edit(Fullnameemployee fullnameemployee);

    void remove(Fullnameemployee fullnameemployee);

    Fullnameemployee find(Object id);

    List<Fullnameemployee> findAll();

    List<Fullnameemployee> findRange(int[] range);

    int count();
    
}
