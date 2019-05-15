/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.order;

import entities.employee.Shipper;
import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hailongluu
 */
@Entity
@Table(name = "bill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b")
    , @NamedQuery(name = "Bill.findById", query = "SELECT b FROM Bill b WHERE b.id = :id")
    , @NamedQuery(name = "Bill.findByShippingMethood", query = "SELECT b FROM Bill b WHERE b.shippingMethood = :shippingMethood")
    , @NamedQuery(name = "Bill.findByPaymentmethod", query = "SELECT b FROM Bill b WHERE b.paymentmethod = :paymentmethod")
    , @NamedQuery(name = "Bill.findByName", query = "SELECT b FROM Bill b WHERE b.name = :name")
    , @NamedQuery(name = "Bill.findByCity", query = "SELECT b FROM Bill b WHERE b.city = :city")
    , @NamedQuery(name = "Bill.findByAdd", query = "SELECT b FROM Bill b WHERE b.add = :add")
    , @NamedQuery(name = "Bill.findByPhone", query = "SELECT b FROM Bill b WHERE b.phone = :phone")})
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "ShippingMethood")
    private String shippingMethood;
    @Size(max = 255)
    @Column(name = "Paymentmethod")
    private String paymentmethod;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @Size(max = 45)
    @Column(name = "add")
    private String add;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "phone")
    private String phone;
    @JoinColumn(name = "ID", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Order1 order1;
    @JoinColumns({
        @JoinColumn(name = "ShipperEmployeeID", referencedColumnName = "EmployeeID")
        , @JoinColumn(name = "ShipperEmployeeID", referencedColumnName = "EmployeeID")})
    @ManyToOne(optional = false)
    private Shipper shipper;

    public Bill() {
    }

    public Bill(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShippingMethood() {
        return shippingMethood;
    }

    public void setShippingMethood(String shippingMethood) {
        this.shippingMethood = shippingMethood;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Order1 getOrder1() {
        return order1;
    }

    public void setOrder1(Order1 order1) {
        this.order1 = order1;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
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
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.order.Bill[ id=" + id + " ]";
    }
    
}
