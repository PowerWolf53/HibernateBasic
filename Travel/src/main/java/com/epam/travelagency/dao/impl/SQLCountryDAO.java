package com.epam.travelagency.dao.impl;

import java.util.List;

import javax.sql.DataSource;


import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.travelagency.bean.Country;
import com.epam.travelagency.bean.mapper.CountryMapper;
import com.epam.travelagency.bean.setter.CountrySetter;
import com.epam.travelagency.dao.CountryDAO;
import com.epam.travelagency.dao.DAOException;
import com.epam.travelagency.dao.DAOWarning;
import com.epam.travelagency.dao.statement.CountryDAOStatement;





public class SQLCountryDAO implements CountryDAO {


	private DataSource source;
	
	public SQLCountryDAO(DataSource source) {
		this.source=source;
	}
	
	@Override
	public void addCountry(Country country) throws DAOException {
		try {
			JdbcTemplate template = new JdbcTemplate(source);
			template.update(CountryDAOStatement.ADD_NEW_COUNTRY, new CountrySetter(country));
		} catch (DuplicateKeyException e) {
			throw new DAOException(DAOWarning.USER_NOT_UNIQUE_DATA);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		
	}

	@Override
	public List<Country> getAllCountries() throws DAOException {
		List<Country> countryList;
		try {
		JdbcTemplate template = new JdbcTemplate(source);
		countryList = template.query(CountryDAOStatement.GET_ALL_COUNTRIES, new CountryMapper());
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		return countryList;
	}

	@Override
	public Country getCountry(Integer id) throws DAOException  {
		Country country;
		try {
		JdbcTemplate template = new JdbcTemplate(source);
		country=template.queryForObject(CountryDAOStatement.GET_COUNTRY_BY_ID,new BeanPropertyRowMapper<Country>(Country.class), new Object[] {id});		
		}catch (EmptyResultDataAccessException e) {
			throw new DAOException(DAOWarning.NOTHING_FOUND);
		}
		return country;
	}

	@Override
	public void deleteCountry(Integer id) throws DAOException {
		try {
			JdbcTemplate template = new JdbcTemplate(source);
			template.update(CountryDAOStatement.DELETE_COUNTRY,id);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		
	}

	@Override
	public Country getCountry(String name) throws DAOException {
		Country country;
		try {
		JdbcTemplate template = new JdbcTemplate(source);
		country=template.queryForObject(CountryDAOStatement.GET_COUNTRY_BY_NAME,new CountryMapper(), new Object[] {name});		
		}catch (EmptyResultDataAccessException e) {
			throw new DAOException(DAOWarning.NOTHING_FOUND);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		
		return country;
	}

}
