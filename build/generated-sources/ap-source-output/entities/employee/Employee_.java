package entities.employee;

import entities.employee.Fullnameemployee;
import entities.employee.Manager;
import entities.employee.Seller;
import entities.employee.Shipper;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T20:44:48")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, Integer> address;
    public static volatile SingularAttribute<Employee, String> phone;
    public static volatile SingularAttribute<Employee, String> idnumber;
    public static volatile SingularAttribute<Employee, Integer> name;
    public static volatile ListAttribute<Employee, Manager> managerList;
    public static volatile ListAttribute<Employee, Shipper> shipperList;
    public static volatile SingularAttribute<Employee, Integer> id;
    public static volatile ListAttribute<Employee, Seller> sellerList;
    public static volatile SingularAttribute<Employee, Integer> account;
    public static volatile SingularAttribute<Employee, String> email;
    public static volatile ListAttribute<Employee, Fullnameemployee> fullnameemployeeList;

}