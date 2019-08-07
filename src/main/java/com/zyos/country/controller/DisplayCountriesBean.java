package com.zyos.country.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.zyos.country.model.Country;
import com.zyos.country.model.War;
import com.zyos.country.model.CountryDAO;
import com.zyos.country.model.WarDAO;

@Named
@SessionScoped
public class DisplayCountriesBean implements Serializable {
	private Country currCountry;
	private ArrayList<Country> countries;
	private CountryDAO cdao;
	private WarDAO wdao;

	
	/*
	 * ToDo: Make no line dependant order code...
	 */
	public DisplayCountriesBean() {
		this.currCountry = new Country();
		this.cdao = new CountryDAO();
		this.wdao = new WarDAO();
		this.countries = (ArrayList<Country>) cdao.findAll();
	}

	public Country getCurrCountry() {
		return currCountry;
	}

	public void setCurrCountry(Country currCountry) {
		this.currCountry = currCountry;
	}
	
	//----------------------------------------------------
	// CRUD
	//----------------------------------------------------
	public String createCountry() {
		this.currCountry = new Country();
		currCountry.setCid(getNextCountryId());
		return "/editCountry.xhtml";	
	}
	
	public ArrayList<Country> getCountries() {
		return countries;
	}
	
	public String updateCountry(Country c) {
		this.currCountry = c;
		return "/editCountry.xhtml";
	}
	
	public void deleteCountry(Country c) {
		cdao.delete(c);
		countries.remove(c);
	}
	
	public String saveCountry() {
		currCountry.setCid(getNextCountryId());
		cdao.save(currCountry);
		countries.add(currCountry);
		return "/index.xhtml";
	}
	
	//----------------------------------------------------
	// MISC
	//----------------------------------------------------
	public Integer getNextCountryId() {
		Integer max = -1;
		List<Country> countries = cdao.findAll();
		for(Country c : countries)
			if(c.getCid() > max)
				max = c.getCid();
		return ++max;
	}
	
	public Integer getNextWarId() {
		Integer max = -1;
		List<War> wars = wdao.findAll();
		for(War w : wars)
			if(w.getWid() > max)
				max = w.getWid();
		return ++max;
	}	
}
