//package org.product.model;
//
//import java.sql.Timestamp;
//import java.util.UUID;
//
//import org.springframework.data.cassandra.core.mapping.Column;
//import org.springframework.data.cassandra.core.mapping.PrimaryKey;
//import org.springframework.data.cassandra.core.mapping.Table;
//
//
//@Table("time")
//public class Time {
//	@PrimaryKey
//	private UUID time_id;
//
//	@Column("month")
//	private Integer month;
//	
//	@Column("quarter")
//	private Integer quarter;
//	
//	@Column("year")
//	private Integer year;
//	
//	@Column("create_at")
//	private Timestamp create_at;
//	
//	//@org.springframework.data.cassandra.core.mapping.Column(value="modified_at")
//	@Column("modified_at")
//	private Timestamp modified_at;
//
//	public UUID getTime_id() {
//		return time_id;
//	}
//
//	public void setTime_id(UUID time_id) {
//		this.time_id = time_id;
//	}
//
//	public Integer getMonth() {
//		return month;
//	}
//
//	public void setMonth(Integer month) {
//		this.month = month;
//	}
//
//	public Integer getQuarter() {
//		return quarter;
//	}
//
//	public void setQuarter(Integer quarter) {
//		this.quarter = quarter;
//	}
//
//	public Integer getYear() {
//		return year;
//	}
//
//	public void setYear(Integer year) {
//		this.year = year;
//	}
//
//	public Timestamp getCreate_at() {
//		return create_at;
//	}
//
//	public void setCreate_at(Timestamp create_at) {
//		this.create_at = create_at;
//	}
//
//	public Timestamp getModified_at() {
//		return modified_at;
//	}
//
//	public void setModified_at(Timestamp modified_at) {
//		this.modified_at = modified_at;
//	}
//	
//	
//}
