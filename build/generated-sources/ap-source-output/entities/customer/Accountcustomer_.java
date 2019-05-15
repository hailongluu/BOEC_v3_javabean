package entities.customer;

import entities.customer.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T17:21:54")
@StaticMetamodel(Accountcustomer.class)
public class Accountcustomer_ { 

    public static volatile SingularAttribute<Accountcustomer, String> password;
    public static volatile ListAttribute<Accountcustomer, Customer> customerList;
    public static volatile SingularAttribute<Accountcustomer, Integer> id;
    public static volatile SingularAttribute<Accountcustomer, String> username;

}