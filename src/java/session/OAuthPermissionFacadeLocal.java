/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;
import javax.ejb.Local;
import org.apache.cxf.rs.security.oauth2.common.OAuthPermission;

/**
 *
 * @author hailongluu
 */
@Local
public interface OAuthPermissionFacadeLocal {

    void create(OAuthPermission oAuthPermission);

    void edit(OAuthPermission oAuthPermission);

    void remove(OAuthPermission oAuthPermission);

    OAuthPermission find(Object id);

    List<OAuthPermission> findAll();

    List<OAuthPermission> findRange(int[] range);

    int count();
    
}
