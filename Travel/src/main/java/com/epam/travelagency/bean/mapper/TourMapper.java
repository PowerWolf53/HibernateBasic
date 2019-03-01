package com.epam.travelagency.bean.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.travelagency.bean.Tour;
import com.epam.travelagency.bean.TourType;


public class TourMapper implements RowMapper<Tour> {

		@Override
		public Tour mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Tour tour=new Tour();
			tour.setId(rs.getInt("id"));
			tour.setPhoto(rs.getString("photo"));
			tour.setDate(rs.getDate("date"));
			tour.setDuration(rs.getInt("duration"));
			tour.setDescription(rs.getString("description"));
			tour.setCost(rs.getDouble("cost"));
			tour.setType(TourType.getValue(rs.getString("tourType")));
			return tour;
		}

}
