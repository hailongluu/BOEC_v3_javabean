/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.cxf.rs.security.oauth2.common.UserSubject;

/**
 *
 * @author hailongluu
 */
@Stateless
public class UserSubjectFacade extends AbstractFacade<UserSubject> implements UserSubjectFacadeLocal {

    @PersistenceContext(unitName = "boecdemov3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserSubjectFacade() {
        super(UserSubject.class);
    }
    
}
