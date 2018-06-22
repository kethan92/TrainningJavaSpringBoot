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
@Table(name = "time")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Time.findAll", query = "SELECT t FROM Time t")
    , @NamedQuery(name = "Time.findByMonth", query = "SELECT t FROM Time t WHERE t.month = :month")
    , @NamedQuery(name = "Time.findByQuarter", query = "SELECT t FROM Time t WHERE t.quarter = :quarter")
    , @NamedQuery(name = "Time.findByYear", query = "SELECT t FROM Time t WHERE t.year = :year")
    , @NamedQuery(name = "Time.findByCreateAt", query = "SELECT t FROM Time t WHERE t.createAt = :createAt")
    , @NamedQuery(name = "Time.findByModifiedAt", query = "SELECT t FROM Time t WHERE t.modifiedAt = :modifiedAt")})
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
   // @Basic(optional = false)
    @NotNull
    //@Lob
    @Column(name = "time_id")
    private UUID timeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "month")
    private int month;
    @Column(name = "quarter")
    private Integer quarter;
    @Column(name = "year")
    private Integer year;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "time",fetch = FetchType.LAZY)
    private Collection<Sales> salesCollection;

    public Time() {
    }

//    public Time(Object timeId) {
//        this.timeId = timeId;
//    }

//    public Time(Object timeId, int month) {
//        this.timeId = timeId;
//        this.month = month;
//    }

    public UUID getTimeId() {
        return timeId;
    }

    public void setTimeId(UUID timeId) {
        this.timeId = timeId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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
        hash += (timeId != null ? timeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Time)) {
            return false;
        }
        Time other = (Time) object;
        if ((this.timeId == null && other.timeId != null) || (this.timeId != null && !this.timeId.equals(other.timeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.product.jpaModel.Time[ timeId=" + timeId + " ]";
    }
    
}
