package com.epam.travelagency.bean.setter;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

import com.epam.travelagency.bean.Country;
import com.epam.travelagency.bean.Hotel;
import com.epam.travelagency.bean.Tour;


public class TourSetter implements PreparedStatementSetter {

	private Tour tour;
	
	private Country country;
	
	private Hotel hotel;
	
	public TourSetter(Tour tour,Country country,Hotel hotel) {
		this.tour=tour;
		this.country=country;
		this.hotel=hotel;
	}
	
	@Override
	public void setValues(PreparedStatement ps) throws SQLException {
		
		ps.setString(1, tour.getPhoto());
		ps.setString(2,  tour.getDate().toString());
		ps.setInt(3, tour.getDuration());
		ps.setString(4, tour.getDescription());
		ps.setDouble(5, tour.getCost());
		ps.setString(6, tour.getType().toString().toLowerCase());
		ps.setInt(7, hotel.getId());
		ps.setInt(8,country.getId());
		
	}

}
