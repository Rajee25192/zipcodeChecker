package com.zipcode.zipcodeChecker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="validate_zipcodes")
public class ValidateZipCode {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "min_range")
	private Integer minRange;
	
	@Column(name = "max_range")
	private Integer maxRange;

	public ValidateZipCode() {
		super();
	}

	public ValidateZipCode(Integer maxRange2, Integer minRange2) {
		this.maxRange=maxRange2;
		this.minRange=minRange2;
	}

	public Integer getMinRange() {
		return minRange;
	}

	public void setMinRange(Integer minRange) {
		this.minRange = minRange;
	}

	public Integer getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(Integer maxRange) {
		this.maxRange = maxRange;
	}
	
	
}
