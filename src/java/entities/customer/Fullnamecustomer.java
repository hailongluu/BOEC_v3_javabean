/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.customer;

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
@Table(name = "fullnamecustomer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fullnamecustomer.findAll", query = "SELECT f FROM Fullnamecustomer f")
    , @NamedQuery(name = "Fullnamecustomer.findById", query = "SELECT f FROM Fullnamecustomer f WHERE f.id = :id")
    , @NamedQuery(name = "Fullnamecustomer.findByFirstname", query = "SELECT f FROM Fullnamecustomer f WHERE f.firstname = :firstname")
    , @NamedQuery(name = "Fullnamecustomer.findByMiddlename", query = "SELECT f FROM Fullnamecustomer f WHERE f.middlename = :middlename")
    , @NamedQuery(name = "Fullnamecustomer.findByLastname", query = "SELECT f FROM Fullnamecustomer f WHERE f.lastname = :lastname")})
public class Fullnamecustomer implements Serializable {

    @Size(max = 255)
    @Column(name = "Firstname")
    private String firstname;
    @Size(max = 255)
    @Column(name = "Middlename")
    private String middlename;
    @Size(max = 255)
    @Column(name = "Lastname")
    private String lastname;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumns({
        @JoinColumn(name = "CustomerID", referencedColumnName = "ID")
        , @JoinColumn(name = "CustomerID", referencedColumnName = "ID")})
    @ManyToOne(optional = false)
    private Customer customer;

    public Fullnamecustomer() {
    }

    public Fullnamecustomer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        if (!(object instanceof Fullnamecustomer)) {
            return false;
        }
        Fullnamecustomer other = (Fullnamecustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Fullnamecustomer[ id=" + id + " ]";
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
}
