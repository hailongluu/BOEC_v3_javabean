/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.cxf.rs.security.oauth2.common.OAuthPermission;

/**
 *
 * @author hailongluu
 */
@Stateless
public class OAuthPermissionFacade extends AbstractFacade<OAuthPermission> implements OAuthPermissionFacadeLocal {

    @PersistenceContext(unitName = "boecdemov3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OAuthPermissionFacade() {
        super(OAuthPermission.class);
    }
    
}
