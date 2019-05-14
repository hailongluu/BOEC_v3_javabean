/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;
import javax.ejb.Local;
import org.apache.cxf.rs.security.oauth2.grants.code.ServerAuthorizationCodeGrant;

/**
 *
 * @author hailongluu
 */
@Local
public interface ServerAuthorizationCodeGrantFacadeLocal {

    void create(ServerAuthorizationCodeGrant serverAuthorizationCodeGrant);

    void edit(ServerAuthorizationCodeGrant serverAuthorizationCodeGrant);

    void remove(ServerAuthorizationCodeGrant serverAuthorizationCodeGrant);

    ServerAuthorizationCodeGrant find(Object id);

    List<ServerAuthorizationCodeGrant> findAll();

    List<ServerAuthorizationCodeGrant> findRange(int[] range);

    int count();
    
}
