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
@Table(name = "electronics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Electronics.findAll", query = "SELECT e FROM Electronics e")
    , @NamedQuery(name = "Electronics.findByChip", query = "SELECT e FROM Electronics e WHERE e.chip = :chip")
    , @NamedQuery(name = "Electronics.findByRam", query = "SELECT e FROM Electronics e WHERE e.ram = :ram")
    , @NamedQuery(name = "Electronics.findByDisk", query = "SELECT e FROM Electronics e WHERE e.disk = :disk")
    , @NamedQuery(name = "Electronics.findByScreen", query = "SELECT e FROM Electronics e WHERE e.screen = :screen")
    , @NamedQuery(name = "Electronics.findByProductIdproduct", query = "SELECT e FROM Electronics e WHERE e.productIdproduct = :productIdproduct")
    , @NamedQuery(name = "Electronics.findBySpecification", query = "SELECT e FROM Electronics e WHERE e.specification = :specification")})
public class Electronics implements Serializable {

    @Size(max = 255)
    @Column(name = "Chip")
    private String chip;
    @Size(max = 255)
    @Column(name = "Ram")
    private String ram;
    @Size(max = 255)
    @Column(name = "Disk")
    private String disk;
    @Size(max = 255)
    @Column(name = "Screen")
    private String screen;
    @Size(max = 255)
    @Column(name = "Specification")
    private String specification;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ProductIdproduct")
    private String productIdproduct;
    @JoinColumn(name = "ProductIdproduct", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Product product;

    public Electronics() {
    }

    public Electronics(String productIdproduct) {
        this.productIdproduct = productIdproduct;
    }


    public String getProductIdproduct() {
        return productIdproduct;
    }

    public void setProductIdproduct(String productIdproduct) {
        this.productIdproduct = productIdproduct;
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
        hash += (productIdproduct != null ? productIdproduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Electronics)) {
            return false;
        }
        Electronics other = (Electronics) object;
        if ((this.productIdproduct == null && other.productIdproduct != null) || (this.productIdproduct != null && !this.productIdproduct.equals(other.productIdproduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Electronics[ productIdproduct=" + productIdproduct + " ]";
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
    
}
