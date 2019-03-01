package com.epam.travelagency.dao;

import com.epam.travelagency.bean.Review;

public interface ReviewDAO {

	public void add(Review review) throws DAOException;
	
	public Review get(Integer id) throws DAOException;
	
	public void delete(Integer id) throws DAOException;
	
	public void update(String text,Integer id) throws DAOException;
}
