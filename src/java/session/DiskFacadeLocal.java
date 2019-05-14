/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.product.electronic.Disk;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface DiskFacadeLocal {

    void create(Disk disk);

    void edit(Disk disk);

    void remove(Disk disk);

    Disk find(Object id);

    List<Disk> findAll();

    List<Disk> findRange(int[] range);

    int count();
    
}
