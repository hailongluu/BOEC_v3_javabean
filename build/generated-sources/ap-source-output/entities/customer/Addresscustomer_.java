package entities.customer;

import entities.customer.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-16T01:27:26")
@StaticMetamodel(Addresscustomer.class)
public class Addresscustomer_ { 

    public static volatile SingularAttribute<Addresscustomer, String> city;
    public static volatile SingularAttribute<Addresscustomer, String> street;
    public static volatile SingularAttribute<Addresscustomer, String> district;
    public static volatile ListAttribute<Addresscustomer, Customer> customerList;
    public static volatile SingularAttribute<Addresscustomer, Integer> id;

}