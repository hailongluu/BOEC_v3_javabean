/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.employee;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hailongluu
 */
@Entity
@Table(name = "shipper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shipper.findAll", query = "SELECT s FROM Shipper s")
    , @NamedQuery(name = "Shipper.findByEmployeeID", query = "SELECT s FROM Shipper s WHERE s.employeeID = :employeeID")
    , @NamedQuery(name = "Shipper.findByTransportation", query = "SELECT s FROM Shipper s WHERE s.transportation = :transportation")})
public class Shipper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EmployeeID")
    private Integer employeeID;
    @Size(max = 255)
    @Column(name = "Transportation")
    private String transportation;
    @JoinColumns({
        @JoinColumn(name = "EmployeeID", referencedColumnName = "ID", insertable = false, updatable = false)
        , @JoinColumn(name = "EmployeeID", referencedColumnName = "ID", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Employee employee;

    public Shipper() {
    }

    public Shipper(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeID != null ? employeeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shipper)) {
            return false;
        }
        Shipper other = (Shipper) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.employee.Shipper[ employeeID=" + employeeID + " ]";
    }
    
}
