package com.epam.travelagency.bean.setter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

import com.epam.travelagency.bean.Review;


public class ReviewSetter implements PreparedStatementSetter {

	private Review review;
	
	public ReviewSetter(Review review) {
		this.review=review;
	}
	
	@Override
	public void setValues(PreparedStatement ps) throws SQLException {
		
		ps.setString(1, review.getDate().toString());
		ps.setString(2, review.getText());
		ps.setInt(3, review.getUserId());
		ps.setInt(4, review.getTourId());
		
		
	}

}
