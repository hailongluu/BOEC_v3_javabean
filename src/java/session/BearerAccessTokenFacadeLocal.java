/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;
import javax.ejb.Local;
import org.apache.cxf.rs.security.oauth2.tokens.bearer.BearerAccessToken;

/**
 *
 * @author hailongluu
 */
@Local
public interface BearerAccessTokenFacadeLocal {

    void create(BearerAccessToken bearerAccessToken);

    void edit(BearerAccessToken bearerAccessToken);

    void remove(BearerAccessToken bearerAccessToken);

    BearerAccessToken find(Object id);

    List<BearerAccessToken> findAll();

    List<BearerAccessToken> findRange(int[] range);

    int count();
    
}
