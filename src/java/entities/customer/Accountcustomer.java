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
@Table(name = "accountcustomer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accountcustomer.findAll", query = "SELECT a FROM Accountcustomer a")
    , @NamedQuery(name = "Accountcustomer.findById", query = "SELECT a FROM Accountcustomer a WHERE a.id = :id")
    , @NamedQuery(name = "Accountcustomer.findByUsername", query = "SELECT a FROM Accountcustomer a WHERE a.username = :username")
    , @NamedQuery(name = "Accountcustomer.findByPassword", query = "SELECT a FROM Accountcustomer a WHERE a.password = :password")})
public class Accountcustomer implements Serializable {

    @Size(max = 255)
    @Column(name = "Username")
    private String username;
    @Size(max = 255)
    @Column(name = "Password")
    private String password;

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

    public Accountcustomer() {
    }

    public Accountcustomer(Integer id) {
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
        if (!(object instanceof Accountcustomer)) {
            return false;
        }
        Accountcustomer other = (Accountcustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Accountcustomer[ id=" + id + " ]";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
