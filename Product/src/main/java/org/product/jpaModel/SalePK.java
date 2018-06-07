package org.product.jpaModel;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

/**
 * The primary key class for the sales database table.
 * 
 */
@Embeddable
public class SalePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="product_id", insertable=false, updatable=false)
	private UUID productId;

	@Column(name="time_id", insertable=false, updatable=false)
	private UUID timeId;

	@Column(name="location_id", insertable=false, updatable=false)
	private UUID locationId;

	public SalePK() {
	}
	
	public SalePK(UUID productId,UUID timeId,UUID locationId) {
		this.productId = productId;
		this.timeId = timeId;
		this.locationId = locationId;
	}
	

	public UUID getProductId() {
		return productId;
	}


	public void setProductId(UUID productId) {
		this.productId = productId;
	}


	public UUID getTimeId() {
		return timeId;
	}


	public void setTimeId(UUID timeId) {
		this.timeId = timeId;
	}


	public UUID getLocationId() {
		return locationId;
	}


	public void setLocationId(UUID locationId) {
		this.locationId = locationId;
	}


	
}