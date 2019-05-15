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
@Table(name = "fullnameemployee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fullnameemployee.findAll", query = "SELECT f FROM Fullnameemployee f")
    , @NamedQuery(name = "Fullnameemployee.findById", query = "SELECT f FROM Fullnameemployee f WHERE f.id = :id")
    , @NamedQuery(name = "Fullnameemployee.findByFirstname", query = "SELECT f FROM Fullnameemployee f WHERE f.firstname = :firstname")
    , @NamedQuery(name = "Fullnameemployee.findByMiddlename", query = "SELECT f FROM Fullnameemployee f WHERE f.middlename = :middlename")
    , @NamedQuery(name = "Fullnameemployee.findByLastname", query = "SELECT f FROM Fullnameemployee f WHERE f.lastname = :lastname")})
public class Fullnameemployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Firstname")
    private String firstname;
    @Size(max = 255)
    @Column(name = "Middlename")
    private String middlename;
    @Size(max = 255)
    @Column(name = "Lastname")
    private String lastname;
    @OneToMany(mappedBy = "name")
    private List<Employee> employeeList;

    public Fullnameemployee() {
    }

    public Fullnameemployee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Fullnameemployee)) {
            return false;
        }
        Fullnameemployee other = (Fullnameemployee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.employee.Fullnameemployee[ id=" + id + " ]";
    }
    
}
