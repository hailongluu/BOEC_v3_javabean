package entities.product;

import entities.order.CartProduct;
import entities.product.book.Book;
import entities.product.clother.Clothes;
import entities.product.clother.Hat;
import entities.product.clother.Pant;
import entities.product.clother.Shirt;
import entities.product.clother.Shoes;
import entities.product.electronic.Chip;
import entities.product.electronic.Desktop;
import entities.product.electronic.Disk;
import entities.product.electronic.Electronics;
import entities.product.electronic.Laptop;
import entities.product.electronic.Ram;
import entities.product.electronic.Screen;
import entities.product.electronic.Smartphone;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-16T01:27:26")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Electronics> electronics;
    public static volatile SingularAttribute<Product, Chip> chip;
    public static volatile SingularAttribute<Product, Integer> quantity;
    public static volatile SingularAttribute<Product, Pant> pant;
    public static volatile SingularAttribute<Product, Smartphone> smartphone;
    public static volatile SingularAttribute<Product, Book> book;
    public static volatile SingularAttribute<Product, Screen> screen;
    public static volatile SingularAttribute<Product, Laptop> laptop;
    public static volatile SingularAttribute<Product, Shoes> shoes;
    public static volatile SingularAttribute<Product, Clothes> clothes;
    public static volatile SingularAttribute<Product, String> imageLink;
    public static volatile SingularAttribute<Product, Disk> disk;
    public static volatile SingularAttribute<Product, Desktop> desktop;
    public static volatile SingularAttribute<Product, Shirt> shirt;
    public static volatile ListAttribute<Product, CartProduct> cartProductList;
    public static volatile SingularAttribute<Product, BigInteger> price;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Hat> hat;
    public static volatile SingularAttribute<Product, String> id;
    public static volatile SingularAttribute<Product, String> brand;
    public static volatile SingularAttribute<Product, Ram> ram;

}