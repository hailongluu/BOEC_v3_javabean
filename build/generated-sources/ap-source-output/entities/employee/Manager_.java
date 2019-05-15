package entities.employee;

import entities.employee.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T20:44:48")
@StaticMetamodel(Manager.class)
public class Manager_ { 

    public static volatile SingularAttribute<Manager, String> role;
    public static volatile SingularAttribute<Manager, Integer> employeeID;
    public static volatile SingularAttribute<Manager, String> position;
    public static volatile SingularAttribute<Manager, Employee> employee;

}