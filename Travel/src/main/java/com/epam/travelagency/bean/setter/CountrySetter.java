package com.epam.travelagency.bean.setter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

import com.epam.travelagency.bean.Country;


public class CountrySetter implements PreparedStatementSetter {

	private Country country;
	
	public CountrySetter(Country country) {
		this.country=country;
	}
	
	@Override
	public void setValues(PreparedStatement ps) throws SQLException {
		ps.setString(1, country.getName());
		
	}

}
