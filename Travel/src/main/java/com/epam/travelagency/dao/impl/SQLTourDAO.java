package com.epam.travelagency.dao.impl;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.travelagency.bean.Country;
import com.epam.travelagency.bean.Hotel;
import com.epam.travelagency.bean.Tour;

import com.epam.travelagency.bean.mapper.TourMapper;

import com.epam.travelagency.bean.setter.TourSetter;

import com.epam.travelagency.dao.DAOException;
import com.epam.travelagency.dao.DAOWarning;
import com.epam.travelagency.dao.TourDAO;
import com.epam.travelagency.dao.statement.TourDAOStatement;



public class SQLTourDAO implements TourDAO {


	private DataSource source;
	
	public SQLTourDAO(DataSource source) {
		this.source=source;
	}
	
	@Override
	public void add(Tour tour,Hotel hotel,Country country) throws DAOException {
		try {
			JdbcTemplate template = new JdbcTemplate(source);
			template.update(TourDAOStatement.ADD_NEW_TOUR, new TourSetter(tour,country,hotel));
		} catch (DuplicateKeyException e) {
			throw new DAOException(DAOWarning.USER_NOT_UNIQUE_DATA);
		}catch(DataAccessException e) {
			e.printStackTrace();
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		
	}

	@Override
	public Tour get(Integer id) throws DAOException {
		Tour tour;
		try {
		JdbcTemplate template = new JdbcTemplate(source);
		tour=template.queryForObject(TourDAOStatement.GET_TOUR_BY_ID,new TourMapper(), new Object[] {id});		
		}catch (EmptyResultDataAccessException e) {
			throw new DAOException(DAOWarning.NOTHING_FOUND);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		return tour;
	}

	@Override
	public void delete(Integer id) throws DAOException {
		try {
			JdbcTemplate template = new JdbcTemplate(source);
			template.update(TourDAOStatement.DELETE_TOUR,id);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		
	}

	@Override
	public void updateDescription(Integer id,String description) throws DAOException {
		
		try {
			JdbcTemplate template = new JdbcTemplate(source);
			template.update(TourDAOStatement.CHANGE_DESCRIPTION,description,id);
		} catch (DuplicateKeyException e) {
			throw new DAOException(DAOWarning.USER_NOT_UNIQUE_DATA);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
	}

}
