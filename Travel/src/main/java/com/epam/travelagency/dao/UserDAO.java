package com.epam.travelagency.dao;

import java.util.List;

import com.epam.travelagency.bean.Tour;
import com.epam.travelagency.bean.User;

public interface UserDAO {

	
	public void addUser(User user) throws DAOException;
	
	public List<User> getAllUsers() throws DAOException;
	
	public User getUser(Integer id) throws DAOException;
	
	public User getUser(String login) throws DAOException;
	
	public void deleteUser(Integer id) throws DAOException;
	
	public void changePassword(Integer id,String newPassword) throws DAOException;
	
	public void addTour(Tour tour,User user) throws DAOException;
	
	public void deleteTour(Integer userId,Integer tourId) throws DAOException;
}
