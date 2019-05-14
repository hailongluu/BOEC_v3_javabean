/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.product.electronic.Chip;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hailongluu
 */
@Local
public interface ChipFacadeLocal {

    void create(Chip chip);

    void edit(Chip chip);

    void remove(Chip chip);

    Chip find(Object id);

    List<Chip> findAll();

    List<Chip> findRange(int[] range);

    int count();
    
}
