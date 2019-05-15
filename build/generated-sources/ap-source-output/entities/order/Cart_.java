package entities.order;

import entities.order.CartProduct;
import entities.order.Order1;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-16T01:27:26")
@StaticMetamodel(Cart.class)
public class Cart_ { 

    public static volatile SingularAttribute<Cart, BigInteger> totalPrice;
    public static volatile ListAttribute<Cart, CartProduct> cartProductList;
    public static volatile SingularAttribute<Cart, Integer> id;
    public static volatile SingularAttribute<Cart, Order1> order1;

}