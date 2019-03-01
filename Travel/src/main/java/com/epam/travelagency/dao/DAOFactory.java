package com.epam.travelagency.dao;

import javax.sql.DataSource;


import com.epam.travelagency.dao.impl.SQLCountryDAO;
import com.epam.travelagency.dao.impl.SQLHotelDAO;
import com.epam.travelagency.dao.impl.SQLReviewDAO;
import com.epam.travelagency.dao.impl.SQLTourDAO;
import com.epam.travelagency.dao.impl.SQLUserDAO;

public class DAOFactory {



	
	public UserDAO getUserDAO(DataSource source) {
		return new SQLUserDAO(source);
	}
	
	public CountryDAO getCountryDAO(DataSource source) {
		return new SQLCountryDAO(source);
	}
	
	public HotelDAO getHotelDAO(DataSource source) {
		return new SQLHotelDAO(source);
	}
	
	public TourDAO getTourDAO(DataSource source) {
		return new SQLTourDAO(source);
	}
	
	public ReviewDAO getReviewDAO(DataSource source) {
		return new SQLReviewDAO(source);
	}
}
