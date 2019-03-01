package com.epam.travelagency.dao;

import com.epam.travelagency.bean.Country;
import com.epam.travelagency.bean.Hotel;
import com.epam.travelagency.bean.Tour;

public interface TourDAO {

	public void add(Tour tour,Hotel hotel,Country country) throws DAOException;
	
	public Tour get(Integer id) throws DAOException;
	
	public void delete(Integer id) throws DAOException;
	
	public void updateDescription(Integer id,String description) throws DAOException;
}
