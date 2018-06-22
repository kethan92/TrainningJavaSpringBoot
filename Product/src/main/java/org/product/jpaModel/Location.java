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

import org.product.util.DateTimeZoneDeserializer;
import org.product.util.DateTimeZoneSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * @author nkthan
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
    , @NamedQuery(name = "Location.findByCity", query = "SELECT l FROM Location l WHERE l.city = :city")
    , @NamedQuery(name = "Location.findByCountry", query = "SELECT l FROM Location l WHERE l.country = :country")
    , @NamedQuery(name = "Location.findByCreateAt", query = "SELECT l FROM Location l WHERE l.createAt = :createAt")
    , @NamedQuery(name = "Location.findByModifiedAt", query = "SELECT l FROM Location l WHERE l.modifiedAt = :modifiedAt")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@Basic(optional = false)
    @NotNull
    //@Lob
    @Column(name = "location_id")
    private UUID locationId;
    @Size(max = 50)
    @Column(name = "city")
    private String city;
    @Size(max = 50)
    @Column(name = "country")
    private String country;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using=DateTimeZoneSerializer.class)
    @JsonDeserialize(using=DateTimeZoneDeserializer.class)
    private Date createAt;
    @Column(name = "modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using=DateTimeZoneSerializer.class)
    @JsonDeserialize(using=DateTimeZoneDeserializer.class)
    private Date modifiedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location",fetch = FetchType.LAZY)
    private Collection<Sales> salesCollection;

    public Location() {
    }

//    public Location(Object locationId) {
//        this.locationId = locationId;
//    }

    public UUID getLocationId() {
        return locationId;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    //@XmlTransient
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
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.product.jpaModel.Location[ locationId=" + locationId + " ]";
    }
    
}
