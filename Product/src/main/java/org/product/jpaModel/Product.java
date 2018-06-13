/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.product.jpaModel;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author nkthan
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByClass1", query = "SELECT p FROM Product p WHERE p.class1 = :class1")
    , @NamedQuery(name = "Product.findByInventory", query = "SELECT p FROM Product p WHERE p.inventory = :inventory")
    , @NamedQuery(name = "Product.findByItem", query = "SELECT p FROM Product p WHERE p.item = :item")
    , @NamedQuery(name = "Product.findByCreateAt", query = "SELECT p FROM Product p WHERE p.createAt = :createAt")
    , @NamedQuery(name = "Product.findByModifiedAt", query = "SELECT p FROM Product p WHERE p.modifiedAt = :modifiedAt")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
  //  @Basic(optional = false)
    @NotNull
   // @Lob
    @Column(name = "product_id")
    private UUID productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "class")
    private String class1;
    @Size(max = 50)
    @Column(name = "inventory")
    private String inventory;
    @Column(name = "item")
    private Integer item;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(name = "modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product",fetch = FetchType.EAGER)
    private Collection<Sales> salesCollection;

    public Product() {
    }

//    public Product(Object productId) {
//        this.productId = productId;
//    }
//
//    public Product(Object productId, String class1) {
//        this.productId = productId;
//        this.class1 = class1;
//    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

   // @XmlTransient
    @JsonIgnore
    public Collection<Sales> getSalesCollection() {
        return salesCollection;
    }

    public void setSalesCollection(Collection<Sales> salesCollection) {
        this.salesCollection = salesCollection;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.product.jpaModel.Product[ productId=" + productId + " ]";
    }
    
}
