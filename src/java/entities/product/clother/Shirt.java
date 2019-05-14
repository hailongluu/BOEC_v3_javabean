/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.product.clother;

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
@Table(name = "shirt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shirt.findAll", query = "SELECT s FROM Shirt s")
    , @NamedQuery(name = "Shirt.findByProductIdproduct", query = "SELECT s FROM Shirt s WHERE s.productIdproduct = :productIdproduct")
    , @NamedQuery(name = "Shirt.findByShirtSpecification", query = "SELECT s FROM Shirt s WHERE s.shirtSpecification = :shirtSpecification")})
public class Shirt implements Serializable {

    @Size(max = 255)
    @Column(name = "ShirtSpecification")
    private String shirtSpecification;

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

    public Shirt() {
    }

    public Shirt(String productIdproduct) {
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
        if (!(object instanceof Shirt)) {
            return false;
        }
        Shirt other = (Shirt) object;
        if ((this.productIdproduct == null && other.productIdproduct != null) || (this.productIdproduct != null && !this.productIdproduct.equals(other.productIdproduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Shirt[ productIdproduct=" + productIdproduct + " ]";
    }

    public String getShirtSpecification() {
        return shirtSpecification;
    }

    public void setShirtSpecification(String shirtSpecification) {
        this.shirtSpecification = shirtSpecification;
    }
    
}
