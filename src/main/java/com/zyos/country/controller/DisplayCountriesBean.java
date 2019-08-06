package com.zyos.country.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.zyos.country.model.Country;
import com.zyos.country.model.CountryDAO;

@Named
@SessionScoped
public class DisplayCountriesBean implements Serializable {
	private Country currCountry;
	private ArrayList<Country> countries;
	private CountryDAO cdao;

	public DisplayCountriesBean() {
		System.out.println("jfalksjdflkajs");
		this.currCountry = new Country();
		this.cdao = new CountryDAO();
		this.countries = (ArrayList<Country>) cdao.findAll();
		System.out.println("jfalksjdflkajs");
		System.out.println(countries);
	}

	public Country getCurrCountry() {
		return currCountry;
	}

	public void setCurrCountry(Country currCountry) {
		this.currCountry = currCountry;
	}

	public ArrayList<Country> getCountries() {
		System.out.println("[DisplayContries.getCountries() : = " );
		ArrayList<Country> dummy = new ArrayList<>();
		dummy.add(new Country(1, "alfa", 10000, 10000.0 , "buhahahah", null));
		dummy.add(new Country(1, "beta", 10000, 10000.0 , "buhahahah", null));
		dummy.add(new Country(1, "dela", 10000, 10000.0 , "buhahahah", null));
		dummy.add(new Country(1, "gama", 10000 , 10000.0 , "buhahahah", null));
		
//		return countries;
		return dummy;
	}
}
