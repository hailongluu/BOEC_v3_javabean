/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;
import javax.ejb.Local;
import org.apache.cxf.rs.security.oauth2.tokens.refresh.RefreshToken;

/**
 *
 * @author hailongluu
 */
@Local
public interface RefreshTokenFacadeLocal {

    void create(RefreshToken refreshToken);

    void edit(RefreshToken refreshToken);

    void remove(RefreshToken refreshToken);

    RefreshToken find(Object id);

    List<RefreshToken> findAll();

    List<RefreshToken> findRange(int[] range);

    int count();
    
}
