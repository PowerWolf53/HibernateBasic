package com.epam.travelagency.bean.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.travelagency.bean.Review;


public class ReviewMapper implements RowMapper<Review> {

	@Override
	public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Review review = new Review();
		review.setId(rs.getInt("id"));
		review.setDate(rs.getDate("date"));
		review.setText(rs.getString("text"));
		review.setUserId(rs.getInt("id_User"));
		review.setTourId(rs.getInt("id_Tour"));
		return review;
	}

}
