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
@Table(name = "clothes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clothes.findAll", query = "SELECT c FROM Clothes c")
    , @NamedQuery(name = "Clothes.findByCategory", query = "SELECT c FROM Clothes c WHERE c.category = :category")
    , @NamedQuery(name = "Clothes.findByProductIdproduct", query = "SELECT c FROM Clothes c WHERE c.productIdproduct = :productIdproduct")
    , @NamedQuery(name = "Clothes.findBySize", query = "SELECT c FROM Clothes c WHERE c.size = :size")
    , @NamedQuery(name = "Clothes.findByColor", query = "SELECT c FROM Clothes c WHERE c.color = :color")})
public class Clothes implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Size")
    private int size;
    @Size(max = 255)
    @Column(name = "Color")
    private String color;

    private static final long serialVersionUID = 1L;
    @Column(name = "Category")
    private Integer category;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ProductIdproduct")
    private String productIdproduct;
    @JoinColumn(name = "ProductIdproduct", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Product product;

    public Clothes() {
    }

    public Clothes(String productIdproduct) {
        this.productIdproduct = productIdproduct;
    }

    public Clothes(String productIdproduct, int size) {
        this.productIdproduct = productIdproduct;
        this.size = size;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
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
        if (!(object instanceof Clothes)) {
            return false;
        }
        Clothes other = (Clothes) object;
        if ((this.productIdproduct == null && other.productIdproduct != null) || (this.productIdproduct != null && !this.productIdproduct.equals(other.productIdproduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Clothes[ productIdproduct=" + productIdproduct + " ]";
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
