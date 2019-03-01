package com.epam.travelagency.dao;

import java.util.List;

import com.epam.travelagency.bean.Country;


public interface CountryDAO {

	public void addCountry(Country country) throws DAOException;
	
	public List<Country> getAllCountries() throws DAOException;
	
	public Country getCountry(Integer id) throws DAOException;
	
	public Country getCountry(String name) throws DAOException;
	
	public void deleteCountry(Integer id) throws DAOException;
}
