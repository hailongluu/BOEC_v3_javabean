package entities.customer;

import entities.customer.Accountcustomer;
import entities.customer.Addresscustomer;
import entities.customer.Fullnamecustomer;
import entities.order.Order1;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T14:42:49")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile ListAttribute<Customer, Fullnamecustomer> fullnamecustomerList;
    public static volatile SingularAttribute<Customer, Integer> address;
    public static volatile SingularAttribute<Customer, String> phone;
    public static volatile SingularAttribute<Customer, String> idnumber;
    public static volatile SingularAttribute<Customer, Integer> name;
    public static volatile ListAttribute<Customer, Accountcustomer> accountcustomerList;
    public static volatile ListAttribute<Customer, Order1> order1List;
    public static volatile SingularAttribute<Customer, Integer> id;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, Integer> account;
    public static volatile ListAttribute<Customer, Addresscustomer> addresscustomerList;

}