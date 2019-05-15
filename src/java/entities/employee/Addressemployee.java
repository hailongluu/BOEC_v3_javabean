/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.employee;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "addressemployee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Addressemployee.findAll", query = "SELECT a FROM Addressemployee a")
    , @NamedQuery(name = "Addressemployee.findById", query = "SELECT a FROM Addressemployee a WHERE a.id = :id")
    , @NamedQuery(name = "Addressemployee.findByCity", query = "SELECT a FROM Addressemployee a WHERE a.city = :city")
    , @NamedQuery(name = "Addressemployee.findByDistrict", query = "SELECT a FROM Addressemployee a WHERE a.district = :district")
    , @NamedQuery(name = "Addressemployee.findByStreet", query = "SELECT a FROM Addressemployee a WHERE a.street = :street")})
public class Addressemployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "City")
    private String city;
    @Size(max = 255)
    @Column(name = "District")
    private String district;
    @Size(max = 255)
    @Column(name = "Street")
    private String street;
    @OneToMany(mappedBy = "address")
    private List<Employee> employeeList;

    public Addressemployee() {
    }

    public Addressemployee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
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
        if (!(object instanceof Addressemployee)) {
            return false;
        }
        Addressemployee other = (Addressemployee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.employee.Addressemployee[ id=" + id + " ]";
    }
    
}
