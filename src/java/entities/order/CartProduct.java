/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.order;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "cart_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartProduct.findAll", query = "SELECT c FROM CartProduct c")
    , @NamedQuery(name = "CartProduct.findByCartID", query = "SELECT c FROM CartProduct c WHERE c.cartID = :cartID")
    , @NamedQuery(name = "CartProduct.findByProductId", query = "SELECT c FROM CartProduct c WHERE c.productId = :productId")
    , @NamedQuery(name = "CartProduct.findById", query = "SELECT c FROM CartProduct c WHERE c.id = :id")})
public class CartProduct implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CartID")
    private int cartID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ProductId")
    private String productId;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;

    public CartProduct() {
    }

    public CartProduct(Integer id) {
        this.id = id;
    }

    public CartProduct(Integer id, int cartID, String productId) {
        this.id = id;
        this.cartID = cartID;
        this.productId = productId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof CartProduct)) {
            return false;
        }
        CartProduct other = (CartProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CartProduct[ id=" + id + " ]";
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    
}
