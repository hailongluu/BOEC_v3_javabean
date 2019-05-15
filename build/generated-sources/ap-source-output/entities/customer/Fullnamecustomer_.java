package entities.customer;

import entities.customer.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T20:44:48")
@StaticMetamodel(Fullnamecustomer.class)
public class Fullnamecustomer_ { 

    public static volatile SingularAttribute<Fullnamecustomer, String> firstname;
    public static volatile SingularAttribute<Fullnamecustomer, String> middlename;
    public static volatile ListAttribute<Fullnamecustomer, Customer> customerList;
    public static volatile SingularAttribute<Fullnamecustomer, Integer> id;
    public static volatile SingularAttribute<Fullnamecustomer, String> lastname;

}