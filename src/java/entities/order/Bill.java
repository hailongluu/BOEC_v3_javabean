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
    , @NamedQuery(name = "Bill.findByShipper", query = "SELECT b FROM Bill b WHERE b.shipper = :shipper")
    , @NamedQuery(name = "Bill.findByShippingMethood", query = "SELECT b FROM Bill b WHERE b.shippingMethood = :shippingMethood")
    , @NamedQuery(name = "Bill.findByIdOrder", query = "SELECT b FROM Bill b WHERE b.idOrder = :idOrder")
    , @NamedQuery(name = "Bill.findByPaymentmethod", query = "SELECT b FROM Bill b WHERE b.paymentmethod = :paymentmethod")})
public class Bill implements Serializable {

    @Size(max = 255)
    @Column(name = "ShippingMethood")
    private String shippingMethood;
    @Size(max = 255)
    @Column(name = "Paymentmethod")
    private String paymentmethod;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Shipper")
    private Integer shipper;
    @Column(name = "IdOrder")
    private Integer idOrder;
    @JoinColumns({
        @JoinColumn(name = "ShipperEmployeeID", referencedColumnName = "EmployeeID")
        , @JoinColumn(name = "ShipperEmployeeID", referencedColumnName = "EmployeeID")})
    @ManyToOne(optional = false)
    private Shipper shipper1;

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

    public Integer getShipper() {
        return shipper;
    }

    public void setShipper(Integer shipper) {
        this.shipper = shipper;
    }


    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }


    public Shipper getShipper1() {
        return shipper1;
    }

    public void setShipper1(Shipper shipper1) {
        this.shipper1 = shipper1;
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
        return "entities.Bill[ id=" + id + " ]";
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
    
}
