/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.cxf.rs.security.oauth2.tokens.refresh.RefreshToken;

/**
 *
 * @author hailongluu
 */
@Stateless
public class RefreshTokenFacade extends AbstractFacade<RefreshToken> implements RefreshTokenFacadeLocal {

    @PersistenceContext(unitName = "boecdemov3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RefreshTokenFacade() {
        super(RefreshToken.class);
    }
    
}
