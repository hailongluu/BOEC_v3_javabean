package entities.product.book;

import entities.product.Product;
import entities.product.book.Publisher;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T14:42:49")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Product> product;
    public static volatile SingularAttribute<Book, Publisher> publisherId;
    public static volatile SingularAttribute<Book, String> author;
    public static volatile SingularAttribute<Book, Integer> numOfPage;
    public static volatile SingularAttribute<Book, String> productIdproduct;
    public static volatile SingularAttribute<Book, String> category;

}