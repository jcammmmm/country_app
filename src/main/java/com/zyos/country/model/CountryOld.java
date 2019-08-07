package com.zyos.country.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Country entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "country", schema = "public")

public class CountryOld implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String countryname;
	private Integer population;
	private Double extension;
	private String govtype;
	private Set<War> wars = new HashSet<War>(0);
	
	/*
	 * Catches String values collected in war checkbox from editCountry.xml,
	 * this is needed since wars cannot store this data...
	 */
	private ArrayList<String> strWars;

	// Constructors

	/** default constructor */
	public CountryOld() {
	}

	/** minimal constructor */
	public CountryOld(Integer cid) {
		this.cid = cid;
	}

	/** full constructor */
	public CountryOld(Integer cid, String countryname, Integer population, Double extension, String govtype,
			Set<War> wars) {
		this.cid = cid;
		this.countryname = countryname;
		this.population = population;
		this.extension = extension;
		this.govtype = govtype;
		this.wars = wars;
	}

	// Property accessors
	@Id

	@Column(name = "cid", unique = true, nullable = false)

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Column(name = "countryname", length = 50)

	public String getCountryname() {
		return this.countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	@Column(name = "population")

	public Integer getPopulation() {
		return this.population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	@Column(name = "extension", precision = 17, scale = 17)

	public Double getExtension() {
		return this.extension;
	}

	public void setExtension(Double extension) {
		this.extension = extension;
	}

	@Column(name = "govtype", length = 50)

	public String getGovtype() {
		return this.govtype;
	}

	public void setGovtype(String govtype) {
		this.govtype = govtype;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")

	public Set<War> getWars() {
		return this.wars;
	}

	public void setWars(Set<War> wars) {
		this.wars = wars;
	}

	@Transient
	public ArrayList<String> getStrWars() {
		return strWars;
	}

//	public void setStrWars(ArrayList<String> strWars) {
//		this.strWars = strWars;
//		for(String s : strWars)
//			wars.add(new War(null, this, s));
//	}
}