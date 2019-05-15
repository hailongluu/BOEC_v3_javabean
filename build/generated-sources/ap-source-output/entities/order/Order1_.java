package entities.order;

import entities.customer.Customer;
import entities.employee.Seller;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T18:08:44")
@StaticMetamodel(Order1.class)
public class Order1_ { 

    public static volatile SingularAttribute<Order1, String> shippingStatus;
    public static volatile SingularAttribute<Order1, Seller> seller;
    public static volatile SingularAttribute<Order1, Date> dateCreated;
    public static volatile SingularAttribute<Order1, Integer> billID;
    public static volatile SingularAttribute<Order1, String> orderStatus;
    public static volatile SingularAttribute<Order1, String> shippingAddress;
    public static volatile SingularAttribute<Order1, Integer> id;
    public static volatile SingularAttribute<Order1, Integer> cart;
    public static volatile SingularAttribute<Order1, Integer> idCustomer;
    public static volatile SingularAttribute<Order1, Customer> customer;

}