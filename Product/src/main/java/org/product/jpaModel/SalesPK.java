/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.product.jpaModel;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

/**
 *
 * @author nkthan
 */
@Embeddable
public class SalesPK implements Serializable {

   // @Basic(optional = false)
    @NotNull
   // @Lob
    @Column(name = "product_id")
    private UUID productId;
   // @Basic(optional = false)
    @NotNull
   // @Lob
    @Column(name = "time_id")
    private UUID timeId;
   // @Basic(optional = false)
    @NotNull
   // @Lob
    @Column(name = "location_id")
    private UUID locationId;

    public SalesPK() {
    }

    public SalesPK(UUID productId, UUID timeId, UUID locationId) {
        this.productId = productId;
        this.timeId = timeId;
        this.locationId = locationId;
    }

    public Object getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public Object getTimeId() {
        return timeId;
    }

    public void setTimeId(UUID timeId) {
        this.timeId = timeId;
    }

    public Object getLocationId() {
        return locationId;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        hash += (timeId != null ? timeId.hashCode() : 0);
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesPK)) {
            return false;
        }
        SalesPK other = (SalesPK) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        if ((this.timeId == null && other.timeId != null) || (this.timeId != null && !this.timeId.equals(other.timeId))) {
            return false;
        }
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.product.jpaModel.SalesPK[ productId=" + productId + ", timeId=" + timeId + ", locationId=" + locationId + " ]";
    }
    
}
