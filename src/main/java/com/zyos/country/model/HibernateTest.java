package com.zyos.country.model;

import java.util.List;

import org.hibernate.HibernateException;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			CountryDAO cdao = new CountryDAO();
			List<Country> data = cdao.findAll();
			System.out.println(data);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
