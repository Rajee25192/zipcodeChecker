package com.zipcode.zipcodeChecker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="zipcodes")
public class ZipCodes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "min_range")
	@NotNull(message = "Required")
	@DecimalMax(value = "99999", message = "Should be 5 digits")
	@DecimalMin(value = "10000", message = "Should be 5 digits")
	private int minRange;
	
	@Column(name = "max_range")
	@NotNull(message = "Required")
	@DecimalMax(value = "99999", message = "Should be 5 digits")
	@DecimalMin(value = "10000", message = "Should be 5 digits")
	private int maxRange;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMinRange() {
		return minRange;
	}

	public void setMinRange(int minRange) {
		this.minRange = minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}

	public ZipCodes() {
		super();
	}	
}
