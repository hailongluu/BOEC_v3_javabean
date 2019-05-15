package entities.employee;

import entities.employee.Employee;
import entities.order.Bill;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T18:08:44")
@StaticMetamodel(Shipper.class)
public class Shipper_ { 

    public static volatile ListAttribute<Shipper, Bill> billList;
    public static volatile SingularAttribute<Shipper, Integer> employeeID;
    public static volatile SingularAttribute<Shipper, Employee> employee;
    public static volatile SingularAttribute<Shipper, String> transportation;

}