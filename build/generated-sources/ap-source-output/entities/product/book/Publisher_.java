package entities.product.book;

import entities.product.book.Book;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T14:42:50")
@StaticMetamodel(Publisher.class)
public class Publisher_ { 

    public static volatile SingularAttribute<Publisher, String> address;
    public static volatile SingularAttribute<Publisher, String> phone;
    public static volatile SingularAttribute<Publisher, String> name;
    public static volatile SingularAttribute<Publisher, Integer> id;
    public static volatile ListAttribute<Publisher, Book> bookList;

}