/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;
import javax.ejb.Local;
import org.apache.cxf.rs.security.oauth2.common.UserSubject;

/**
 *
 * @author hailongluu
 */
@Local
public interface UserSubjectFacadeLocal {

    void create(UserSubject userSubject);

    void edit(UserSubject userSubject);

    void remove(UserSubject userSubject);

    UserSubject find(Object id);

    List<UserSubject> findAll();

    List<UserSubject> findRange(int[] range);

    int count();
    
}
