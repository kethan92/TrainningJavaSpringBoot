package org.product.jpaModel;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	private UUID product_id;
	@Column(name="class")
	private String classd;
	private String inventory;
	private Integer item;
	private Timestamp create_at;
	private Timestamp modified_at;
	public UUID getProduct_id() {
		return product_id;
	}
	public void setProduct_id(UUID product_id) {
		this.product_id = product_id;
	}
	public String getClassd() {
		return classd;
	}
	public void setClassd(String classd) {
		this.classd = classd;
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
	public Timestamp getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Timestamp create_at) {
		this.create_at = create_at;
	}
	public Timestamp getModified_at() {
		return modified_at;
	}
	public void setModified_at(Timestamp modified_at) {
		this.modified_at = modified_at;
	}
	
	
}
