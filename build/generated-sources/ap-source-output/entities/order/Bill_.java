package entities.order;

import entities.employee.Shipper;
import entities.order.Order1;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T20:44:48")
@StaticMetamodel(Bill.class)
public class Bill_ { 

    public static volatile SingularAttribute<Bill, String> shippingMethood;
    public static volatile SingularAttribute<Bill, Shipper> shipper;
    public static volatile SingularAttribute<Bill, Integer> id;
    public static volatile SingularAttribute<Bill, Order1> order1;
    public static volatile SingularAttribute<Bill, String> paymentmethod;

}