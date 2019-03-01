package com.epam.travelagency.bean.setter;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

import com.epam.travelagency.bean.Feature;
import com.epam.travelagency.bean.Hotel;


public class HotelSetter implements PreparedStatementSetter {

	private Hotel hotel;
	
	public HotelSetter(Hotel hotel) {
		this.hotel=hotel;
	}
	
	@Override
	public void setValues(PreparedStatement ps) throws SQLException {
		Array features=ps.getConnection().createArrayOf("features",Feature.convertToArray(hotel.getFeatures()) );
		ps.setString(1, hotel.getName());
		ps.setInt(2,hotel.getStars());
		ps.setString(3, hotel.getWebsite());
		ps.setDouble(4, hotel.getLatitude());
		ps.setDouble(5, hotel.getLongtitude());
		ps.setArray(6, features);
		
		
	}
}
