/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.product.electronic;

import entities.product.Product;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hailongluu
 */
@Entity
@Table(name = "disk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disk.findAll", query = "SELECT d FROM Disk d")
    , @NamedQuery(name = "Disk.findByKind", query = "SELECT d FROM Disk d WHERE d.kind = :kind")
    , @NamedQuery(name = "Disk.findByCapacity", query = "SELECT d FROM Disk d WHERE d.capacity = :capacity")
    , @NamedQuery(name = "Disk.findByProductId", query = "SELECT d FROM Disk d WHERE d.productId = :productId")})
public class Disk implements Serializable {

    @Size(max = 255)
    @Column(name = "Kind")
    private String kind;
    @Size(max = 255)
    @Column(name = "Capacity")
    private String capacity;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ProductId")
    private String productId;
    @JoinColumn(name = "ProductId", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Product product;

    public Disk() {
    }

    public Disk(String productId) {
        this.productId = productId;
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disk)) {
            return false;
        }
        Disk other = (Disk) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Disk[ productId=" + productId + " ]";
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    
}
