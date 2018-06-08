/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.product.jpaModel;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nkthan
 */
@Entity
@Table(name = "sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s")
    , @NamedQuery(name = "Sales.findByDollars", query = "SELECT s FROM Sales s WHERE s.dollars = :dollars")
    , @NamedQuery(name = "Sales.findByCreateAt", query = "SELECT s FROM Sales s WHERE s.createAt = :createAt")
    , @NamedQuery(name = "Sales.findByModifiedAt", query = "SELECT s FROM Sales s WHERE s.modifiedAt = :modifiedAt")})
public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalesPK salesPK;
    @Column(name = "dollars")
    private BigInteger dollars;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(name = "modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;
    @JoinColumn(name = "location_id", referencedColumnName = "location_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Location location;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "time_id", referencedColumnName = "time_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Time time;

    public Sales() {
    }

    public Sales(SalesPK salesPK) {
        this.salesPK = salesPK;
    }

    public Sales(Object productId, Object timeId, Object locationId) {
        this.salesPK = new SalesPK(productId, timeId, locationId);
    }

    public SalesPK getSalesPK() {
        return salesPK;
    }

    public void setSalesPK(SalesPK salesPK) {
        this.salesPK = salesPK;
    }

    public BigInteger getDollars() {
        return dollars;
    }

    public void setDollars(BigInteger dollars) {
        this.dollars = dollars;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesPK != null ? salesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.salesPK == null && other.salesPK != null) || (this.salesPK != null && !this.salesPK.equals(other.salesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.product.jpaModel.Sales[ salesPK=" + salesPK + " ]";
    }
    
}
