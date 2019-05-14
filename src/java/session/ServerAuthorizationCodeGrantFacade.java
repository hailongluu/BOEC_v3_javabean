/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.cxf.rs.security.oauth2.grants.code.ServerAuthorizationCodeGrant;

/**
 *
 * @author hailongluu
 */
@Stateless
public class ServerAuthorizationCodeGrantFacade extends AbstractFacade<ServerAuthorizationCodeGrant> implements ServerAuthorizationCodeGrantFacadeLocal {

    @PersistenceContext(unitName = "boecdemov3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServerAuthorizationCodeGrantFacade() {
        super(ServerAuthorizationCodeGrant.class);
    }
    
}
