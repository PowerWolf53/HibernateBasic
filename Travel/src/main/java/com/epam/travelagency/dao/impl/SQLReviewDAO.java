package com.epam.travelagency.dao.impl;

import javax.sql.DataSource;


import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.travelagency.bean.Review;

import com.epam.travelagency.bean.mapper.ReviewMapper;

import com.epam.travelagency.bean.setter.ReviewSetter;

import com.epam.travelagency.dao.DAOException;
import com.epam.travelagency.dao.DAOWarning;
import com.epam.travelagency.dao.ReviewDAO;
import com.epam.travelagency.dao.statement.ReviewDAOStatement;



public class SQLReviewDAO implements ReviewDAO  {


	
	private DataSource source;
	
	public SQLReviewDAO(DataSource source) {
		this.source=source;
	}
	
	@Override
	public void add(Review review) throws DAOException {
		try {
			JdbcTemplate template = new JdbcTemplate(source);
			template.update(ReviewDAOStatement.ADD_NEW_REVIEW, new ReviewSetter(review));
		} catch (DuplicateKeyException e) {
			throw new DAOException(DAOWarning.USER_NOT_UNIQUE_DATA);
		}catch(DataAccessException e) {
			e.printStackTrace();
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		
	}

	@Override
	public Review get(Integer id) throws DAOException {
		Review review;
		try {
		JdbcTemplate template = new JdbcTemplate(source);
		review=template.queryForObject(ReviewDAOStatement.GET_REVIEW_BY_ID,new ReviewMapper(), new Object[] {id});		
		}catch (EmptyResultDataAccessException e) {
			throw new DAOException(DAOWarning.NOTHING_FOUND);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		return review;
		
	}

	@Override
	public void delete(Integer id) throws DAOException {
		try {
			JdbcTemplate template = new JdbcTemplate(source);
			template.update(ReviewDAOStatement.DELETE_REVIEW,id);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		
	}

	@Override
	public void update(String text, Integer id) throws DAOException {
		try {
			JdbcTemplate template = new JdbcTemplate(source);
			template.update(ReviewDAOStatement.CHANGE_TEXT,text,id);
		} catch (DuplicateKeyException e) {
			throw new DAOException(DAOWarning.USER_NOT_UNIQUE_DATA);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		
	}

}
