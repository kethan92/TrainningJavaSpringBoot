package org.product.jpaModel;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="Time")
public class Time {

	@Id
	private UUID time_id;

	@Column(name="month")
	private Integer month;
	
	@Column(name="quarter")
	private Integer quarter;
	
	@Column(name="year")
	private Integer year;
	
	@Column(name="create_at")
	private Timestamp create_at;
	
	//@org.springframework.data.cassandra.core.mapping.Column(value="modified_at")
	@Column(name="modified_at")
	private Timestamp modified_at;
	
	//bi-directional many-to-one association to Sale
	@javax.persistence.OneToMany(fetch = FetchType.LAZY)
	private List<Sales> sales;

	public UUID getTime_id() {
		return time_id;
	}

	public void setTime_id(UUID time_id) {
		this.time_id = time_id;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
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
