package org.product.jpaModel;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="sales")
public class Sales {

	
	@Embedded
	private SalePK id;

	@Column(name="create_at")
	private Timestamp createAt;

	private BigDecimal dollars;

	@Column(name="modified_at")
	private Timestamp modifiedAt;

	//bi-directional many-to-one association to Location
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="location_id")
	private Location location;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="product_id")
	private Product product;

	//bi-directional many-to-one association to Time
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="time_id")
	private Time time;

	public SalePK getId() {
		return id;
	}

	public void setId(SalePK id) {
		this.id = id;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public BigDecimal getDollars() {
		return dollars;
	}

	public void setDollars(BigDecimal dollars) {
		this.dollars = dollars;
	}

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
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
		
		
		

		
}
