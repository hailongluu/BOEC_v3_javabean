package entities.employee;

import entities.employee.Employee;
import entities.order.Order1;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T14:42:50")
@StaticMetamodel(Seller.class)
public class Seller_ { 

    public static volatile SingularAttribute<Seller, Integer> employeeID;
    public static volatile ListAttribute<Seller, Order1> order1List;
    public static volatile SingularAttribute<Seller, String> position;
    public static volatile SingularAttribute<Seller, Employee> employee;

}