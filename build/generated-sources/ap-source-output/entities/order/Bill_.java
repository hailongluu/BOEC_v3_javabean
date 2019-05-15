package entities.order;

import entities.employee.Shipper;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T14:42:50")
@StaticMetamodel(Bill.class)
public class Bill_ { 

    public static volatile SingularAttribute<Bill, String> shippingMethood;
    public static volatile SingularAttribute<Bill, Integer> shipper;
    public static volatile SingularAttribute<Bill, Integer> idOrder;
    public static volatile SingularAttribute<Bill, Shipper> shipper1;
    public static volatile SingularAttribute<Bill, Integer> id;
    public static volatile SingularAttribute<Bill, String> paymentmethod;

}