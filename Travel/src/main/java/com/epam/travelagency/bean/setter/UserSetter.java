package com.epam.travelagency.bean.setter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

import com.epam.travelagency.bean.User;

public final class UserSetter implements PreparedStatementSetter {

	private User user;
	
	public UserSetter(User user) {
		this.user=user;
	}
	
	@Override
	public void setValues(PreparedStatement ps) throws SQLException {
		ps.setString(1,user.getLogin());
		ps.setString(2,user.getPassword());
		
	}

}
