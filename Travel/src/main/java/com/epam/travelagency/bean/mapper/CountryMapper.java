package com.epam.travelagency.bean.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.travelagency.bean.Country;


public class CountryMapper implements RowMapper<Country> {

	@Override
	public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		Country country=new Country();
		country.setId(rs.getInt("id"));
		country.setName(rs.getString("name"));
		return country;
	}
}
