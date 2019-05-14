/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.product.electronic.Ram;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hailongluu
 */
@Stateless
public class RamFacade extends AbstractFacade<Ram> implements RamFacadeLocal {

    @PersistenceContext(unitName = "boecdemov3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RamFacade() {
        super(Ram.class);
    }
    
}
