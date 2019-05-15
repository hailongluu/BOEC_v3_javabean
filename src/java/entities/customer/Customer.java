/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.customer;

import entities.order.Order1;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hailongluu
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id")
    , @NamedQuery(name = "Customer.findByIdnumber", query = "SELECT c FROM Customer c WHERE c.idnumber = :idnumber")
    , @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone")
    , @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")})
public class Customer implements Serializable {

    @Size(max = 255)
    @Column(name = "Idnumber")
    private String idnumber;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "Phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "Email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Order1> order1List;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "Account", referencedColumnName = "ID")
    @ManyToOne
    private Accountcustomer account;
    @JoinColumn(name = "Address", referencedColumnName = "ID")
    @ManyToOne
    private Addresscustomer address;
    @JoinColumn(name = "Name", referencedColumnName = "ID")
    @ManyToOne
    private Fullnamecustomer name;

    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Accountcustomer getAccount() {
        return account;
    }

    public void setAccount(Accountcustomer account) {
        this.account = account;
    }

    public Addresscustomer getAddress() {
        return address;
    }

    public void setAddress(Addresscustomer address) {
        this.address = address;
    }

    public Fullnamecustomer getName() {
        return name;
    }

    public void setName(Fullnamecustomer name) {
        this.name = name;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.customer.Customer[ id=" + id + " ]";
    }
    
    public static class CustomerBuilder{
		private final String username;
		private final String pass;
		private final String firstName;
		private final String lastName;
		private String address;
		private String phone;

		public CustomerBuilder(String username, String pass, String firstName, String lastName) {
			this.username = username;
			this.pass = pass;
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public  CustomerBuilder address(String add){
			this.address = add;
			return this;
		}
		public CustomerBuilder phone(String phone){
			this.phone = phone;
			return this;
		}
		public Customer build(){
			Fullnamecustomer fullName = new Fullnamecustomer();
                        fullName.setFirstname(this.firstName);
                        fullName.setLastname(this.lastName);
			Accountcustomer account = new Accountcustomer();
                        account.setUsername(this.username);
                        account.setPassword(this.pass);
			Addresscustomer address = new Addresscustomer();
                        address.setStreet(this.address);
			Customer customer = new Customer();
                        customer.setAccount(account);
                        customer.setPhone(this.phone);
                        customer.setAddress(address);
                        customer.setName(fullName);       
			return customer;
		}
	}


    @XmlTransient
    public List<Order1> getOrder1List() {
        return order1List;
    }

    public void setOrder1List(List<Order1> order1List) {
        this.order1List = order1List;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
