package org.product.model;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

//
//import org.springframework.data.cassandra.mapping.PrimaryKey;
//import org.springframework.data.cassandra.mapping.Table;




//@org.springframework.data.cassandra.core.mapping.Table

@Table("product")
public class Product {
	
	//@Column(name="PRODUCT_ID",nullable=false)
	//@org.springframework.data.cassandra.core.mapping.Column(value="product_id")
	@PrimaryKey
	private UUID product_id;
	
	//@org.springframework.data.cassandra.core.mapping.Column(value="class")
	@Column("class")
	private String classd;
	
	//@org.springframework.data.cassandra.core.mapping.Column(value="inventory")
	@Column("inventory")
	private String inventory;
	
	//@org.springframework.data.cassandra.core.mapping.Column(value="item")
	@Column("item")
	private Integer item;
	
	//@org.springframework.data.cassandra.core.mapping.Column(value="create_at")
	@Column("create_at")
	private Timestamp create_at;
	
	//@org.springframework.data.cassandra.core.mapping.Column(value="modified_at")
	@Column("modified_at")
	private Timestamp modified_at;

	public UUID getProduct_id() {
		return product_id;
	}

	public void setProduct_id(UUID product_id) {
		this.product_id = product_id;
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
