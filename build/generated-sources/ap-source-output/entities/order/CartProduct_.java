package entities.order;

import entities.order.Cart;
import entities.product.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T20:44:48")
@StaticMetamodel(CartProduct.class)
public class CartProduct_ { 

    public static volatile SingularAttribute<CartProduct, Integer> quantity;
    public static volatile SingularAttribute<CartProduct, Product> productId;
    public static volatile SingularAttribute<CartProduct, Cart> cartID;
    public static volatile SingularAttribute<CartProduct, Integer> id;

}