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
@Table(name = "hat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hat.findAll", query = "SELECT h FROM Hat h")
    , @NamedQuery(name = "Hat.findByProductIdproduct", query = "SELECT h FROM Hat h WHERE h.productIdproduct = :productIdproduct")
    , @NamedQuery(name = "Hat.findByHatSpecification", query = "SELECT h FROM Hat h WHERE h.hatSpecification = :hatSpecification")})
public class Hat implements Serializable {

    @Size(max = 255)
    @Column(name = "HatSpecification")
    private String hatSpecification;

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

    public Hat() {
    }

    public Hat(String productIdproduct) {
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
        if (!(object instanceof Hat)) {
            return false;
        }
        Hat other = (Hat) object;
        if ((this.productIdproduct == null && other.productIdproduct != null) || (this.productIdproduct != null && !this.productIdproduct.equals(other.productIdproduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Hat[ productIdproduct=" + productIdproduct + " ]";
    }

    public String getHatSpecification() {
        return hatSpecification;
    }

    public void setHatSpecification(String hatSpecification) {
        this.hatSpecification = hatSpecification;
    }
    
}
