package com.zyos.country.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * War entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "war", schema = "public")

public class War implements java.io.Serializable {

	// Fields

	private Integer wid;
	private Country country;
	private String warname;

	// Constructors

	/** default constructor */
	public War() {
	}

	/** minimal constructor */
	public War(Integer wid) {
		this.wid = wid;
	}

	/** full constructor */
	public War(Integer wid, Country country, String warname) {
		this.wid = wid;
		this.country = country;
		this.warname = warname;
	}

	// Property accessors
	@Id

	@Column(name = "wid", unique = true, nullable = false)

	public Integer getWid() {
		return this.wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid_country")

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name = "warname", length = 60)

	public String getWarname() {
		return this.warname;
	}

	public void setWarname(String warname) {
		this.warname = warname;
	}

}