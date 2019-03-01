package com.epam.travelagency.dao;

import java.util.List;

import com.epam.travelagency.bean.Feature;
import com.epam.travelagency.bean.Hotel;

public interface HotelDAO {

	public void add(Hotel hotel) throws DAOException;
	
	public List<Hotel> getAllHotels() throws DAOException;
	
	public void delete(Integer id) throws DAOException;
	
	public Hotel getHotel(Integer id) throws DAOException;
	
	public void addFeature(Integer id,Feature feature) throws DAOException;
}
