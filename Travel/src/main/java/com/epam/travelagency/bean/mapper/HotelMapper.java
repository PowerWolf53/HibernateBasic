package com.epam.travelagency.bean.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.travelagency.bean.Feature;
import com.epam.travelagency.bean.Hotel;

import com.epam.travelagency.bean.builder.HotelBuilder;

public class HotelMapper implements RowMapper<Hotel> {

		@Override
		public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
			String[] features=(String[]) rs.getArray(6).getArray();
			
			Hotel hotel = new HotelBuilder().
					id(rs.getInt(1)).
					name(rs.getString(2)).
					stars(rs.getInt(3)).
					latitude(rs.getDouble(4)).
					longtitude(rs.getDouble(5)).
					features(Feature.convertToEnum(features)).
					website(rs.getString(7)).
					build();
			return hotel;
			
		}
}
