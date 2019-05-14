/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.product;

import entities.product.electronic.Laptop;
import entities.product.clother.Hat;
import entities.product.clother.Shoes;
import entities.product.electronic.Electronics;
import entities.product.clother.Clothes;
import entities.product.clother.Pant;
import entities.product.electronic.Ram;
import entities.product.electronic.Disk;
import entities.product.electronic.Desktop;
import entities.product.electronic.Chip;
import entities.product.electronic.Screen;
import entities.product.electronic.Smartphone;
import entities.product.book.Book;
import entities.product.clother.Shirt;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hailongluu
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id")
    , @NamedQuery(name = "Product.findByBrand", query = "SELECT p FROM Product p WHERE p.brand = :brand")
    , @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price")
    , @NamedQuery(name = "Product.findByQuantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "Product.findByImageLink", query = "SELECT p FROM Product p WHERE p.imageLink = :imageLink")
    , @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name")})
public class Product implements Serializable {

    @Size(max = 255)
    @Column(name = "Brand")
    private String brand;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private long price;
    @Size(max = 255)
    @Column(name = "ImageLink")
    private String imageLink;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Id")
    private String id;
    @Column(name = "Quantity")
    private Integer quantity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Electronics electronics;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Pant pant;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Smartphone smartphone;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Book book;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Screen screen;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Laptop laptop;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Desktop desktop;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Hat hat;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Ram ram;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Chip chip;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Shoes shoes;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Clothes clothes;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Disk disk;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Shirt shirt;

    public Product() {
    }

    public Product(String id) {
        this.id = id;
    }

    public Product(String id, long price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Electronics getElectronics() {
        return electronics;
    }

    public void setElectronics(Electronics electronics) {
        this.electronics = electronics;
    }

    public Pant getPant() {
        return pant;
    }

    public void setPant(Pant pant) {
        this.pant = pant;
    }

    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Desktop getDesktop() {
        return desktop;
    }

    public void setDesktop(Desktop desktop) {
        this.desktop = desktop;
    }

    public Hat getHat() {
        return hat;
    }

    public void setHat(Hat hat) {
        this.hat = hat;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Chip getChip() {
        return chip;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public Shirt getShirt() {
        return shirt;
    }

    public void setShirt(Shirt shirt) {
        this.shirt = shirt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Product[ id=" + id + " ]";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
