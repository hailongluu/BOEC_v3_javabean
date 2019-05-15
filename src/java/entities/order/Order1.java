/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.order;

import entities.customer.Customer;
import entities.employee.Seller;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
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
    , @NamedQuery(name = "Order1.findByDateCreated", query = "SELECT o FROM Order1 o WHERE o.dateCreated = :dateCreated")
    , @NamedQuery(name = "Order1.findByOrderStatus", query = "SELECT o FROM Order1 o WHERE o.orderStatus = :orderStatus")
    , @NamedQuery(name = "Order1.findByShippingStatus", query = "SELECT o FROM Order1 o WHERE o.shippingStatus = :shippingStatus")
    , @NamedQuery(name = "Order1.findByShippingAddress", query = "SELECT o FROM Order1 o WHERE o.shippingAddress = :shippingAddress")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BillID")
    private int billID;
    @Column(name = "DateCreated")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Size(max = 255)
    @Column(name = "OrderStatus")
    private String orderStatus;
    @Size(max = 255)
    @Column(name = "ShippingStatus")
    private String shippingStatus;
    @Size(max = 255)
    @Column(name = "ShippingAddress")
    private String shippingAddress;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order1")
    private Bill bill;
    @JoinColumn(name = "Id", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cart cart;
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

    public Order1(Integer id, int billID) {
        this.id = id;
        this.billID = billID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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
        return "entities.order.Order1[ id=" + id + " ]";
    }
    
}
