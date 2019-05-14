/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.order;

import entities.employee.Seller;
import entities.customer.Customer;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hailongluu
 */
@Entity
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o")
    , @NamedQuery(name = "Order1.findById", query = "SELECT o FROM Order1 o WHERE o.id = :id")
    , @NamedQuery(name = "Order1.findByBillID", query = "SELECT o FROM Order1 o WHERE o.billID = :billID")
    , @NamedQuery(name = "Order1.findByCart", query = "SELECT o FROM Order1 o WHERE o.cart = :cart")
    , @NamedQuery(name = "Order1.findByIdCustomer", query = "SELECT o FROM Order1 o WHERE o.idCustomer = :idCustomer")
    , @NamedQuery(name = "Order1.findByDateCreated", query = "SELECT o FROM Order1 o WHERE o.dateCreated = :dateCreated")
    , @NamedQuery(name = "Order1.findByOrderStatus", query = "SELECT o FROM Order1 o WHERE o.orderStatus = :orderStatus")
    , @NamedQuery(name = "Order1.findByShippingStatus", query = "SELECT o FROM Order1 o WHERE o.shippingStatus = :shippingStatus")
    , @NamedQuery(name = "Order1.findByShippingAddress", query = "SELECT o FROM Order1 o WHERE o.shippingAddress = :shippingAddress")})
public class Order1 implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "BillID")
    private int billID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdCustomer")
    private int idCustomer;
    @Size(max = 255)
    @Column(name = "OrderStatus")
    private String orderStatus;
    @Size(max = 255)
    @Column(name = "ShippingStatus")
    private String shippingStatus;
    @Size(max = 255)
    @Column(name = "ShippingAddress")
    private String shippingAddress;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Cart")
    private Integer cart;
    @Column(name = "DateCreated")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @JoinColumns({
        @JoinColumn(name = "CustomerID", referencedColumnName = "ID")
        , @JoinColumn(name = "CustomerID", referencedColumnName = "ID")})
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumns({
        @JoinColumn(name = "SellerEmployeeID", referencedColumnName = "EmployeeID")
        , @JoinColumn(name = "SellerEmployeeID", referencedColumnName = "EmployeeID")})
    @ManyToOne(optional = false)
    private Seller seller;

    public Order1() {
    }

    public Order1(Integer id) {
        this.id = id;
    }

    public Order1(Integer id, int billID, int idCustomer) {
        this.id = id;
        this.billID = billID;
        this.idCustomer = idCustomer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getCart() {
        return cart;
    }

    public void setCart(Integer cart) {
        this.cart = cart;
    }


    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
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
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Order1[ id=" + id + " ]";
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    
}
