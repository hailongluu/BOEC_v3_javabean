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
@Table(name = "screen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Screen.findAll", query = "SELECT s FROM Screen s")
    , @NamedQuery(name = "Screen.findByResolution", query = "SELECT s FROM Screen s WHERE s.resolution = :resolution")
    , @NamedQuery(name = "Screen.findByRgb", query = "SELECT s FROM Screen s WHERE s.rgb = :rgb")
    , @NamedQuery(name = "Screen.findByProductId", query = "SELECT s FROM Screen s WHERE s.productId = :productId")})
public class Screen implements Serializable {

    @Size(max = 255)
    @Column(name = "Resolution")
    private String resolution;
    @Size(max = 255)
    @Column(name = "Rgb")
    private String rgb;

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

    public Screen() {
    }

    public Screen(String productId) {
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
        if (!(object instanceof Screen)) {
            return false;
        }
        Screen other = (Screen) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Screen[ productId=" + productId + " ]";
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }
    
}
