/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.customer.Accountcustomer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hailongluu
 */
@Stateless
public class AccountcustomerFacade extends AbstractFacade<Accountcustomer> implements AccountcustomerFacadeLocal {

    @PersistenceContext(unitName = "boecdemov3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountcustomerFacade() {
        super(Accountcustomer.class);
    }
    
}
