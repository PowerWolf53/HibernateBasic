package com.epam.travelagency.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.travelagency.bean.Tour;
import com.epam.travelagency.bean.User;
import com.epam.travelagency.bean.mapper.UserMapper;
import com.epam.travelagency.bean.setter.UserSetter;
import com.epam.travelagency.dao.DAOException;
import com.epam.travelagency.dao.DAOWarning;
import com.epam.travelagency.dao.UserDAO;
import com.epam.travelagency.dao.statement.UserDAOStatement;

public class SQLUserDAO implements UserDAO {

	private DataSource source;
	
	public SQLUserDAO(DataSource source) {
		this.source=source;
	}

	@Override
	public void addUser(User user) throws DAOException {
		try {
			JdbcTemplate template = new JdbcTemplate(source);
			template.update(UserDAOStatement.ADD_NEW_USER, new UserSetter(user));
		} catch (DuplicateKeyException e) {
			throw new DAOException(DAOWarning.USER_NOT_UNIQUE_DATA);
		}catch(DataAccessException e) {
			e.printStackTrace();
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
	}

	@Override
	public List<User> getAllUsers() throws DAOException {
		List<User> userList;
		try {
		JdbcTemplate template = new JdbcTemplate(source);
		userList = template.query(UserDAOStatement.GET_ALL_USERS, new UserMapper());
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		return userList;
	}

	@Override
	public User getUser(Integer id) throws DAOException {
		User user;
		try {
		JdbcTemplate template = new JdbcTemplate(source);
		user=template.queryForObject(UserDAOStatement.GET_USER_BY_ID,new UserMapper(), new Object[] {id});		
		}catch (EmptyResultDataAccessException e) {
			throw new DAOException(DAOWarning.NOTHING_FOUND);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		return user;
	}

	@Override
	public void deleteUser(Integer id) throws DAOException {
		try {
			JdbcTemplate template = new JdbcTemplate(source);
			template.update(UserDAOStatement.DELETE_USER,id);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		
	}

	@Override
	public void changePassword(Integer id,String newPassword) throws DAOException {
		try {
			JdbcTemplate template = new JdbcTemplate(source);
			template.update(UserDAOStatement.CHANGE_PASSWORD,newPassword,id);
		} catch (DuplicateKeyException e) {
			throw new DAOException(DAOWarning.USER_NOT_UNIQUE_DATA);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		
	}

	@Override
	public User getUser(String login) throws DAOException {
		User user;
		try {
		JdbcTemplate template = new JdbcTemplate(source);
		user=template.queryForObject(UserDAOStatement.GET_USER_BY_LOGIN,new UserMapper(), new Object[] {login});		
		}catch (EmptyResultDataAccessException e) {
			throw new DAOException(DAOWarning.NOTHING_FOUND);
		}catch(DataAccessException e) {
			
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		return user;
	}

	@Override
	public void addTour(Tour tour, User user) throws DAOException {
		try {
			JdbcTemplate template = new JdbcTemplate(source);
			template.update(UserDAOStatement.ADD_TOUR, user.getId(),tour.getId());
		} catch (DuplicateKeyException e) {
			throw new DAOException(DAOWarning.USER_NOT_UNIQUE_DATA);
		}catch(DataAccessException e) {
			e.printStackTrace();
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		
	}

	@Override
	public void deleteTour(Integer userId,Integer tourId ) throws DAOException {
	
		try {
			JdbcTemplate template = new JdbcTemplate(source);
			template.update(UserDAOStatement.DELETE_TOUR,userId,tourId);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
	}
}
