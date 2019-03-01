package com.epam.travelagency.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.travelagency.bean.Feature;
import com.epam.travelagency.bean.Hotel;

import com.epam.travelagency.bean.mapper.HotelMapper;

import com.epam.travelagency.bean.setter.HotelSetter;
import com.epam.travelagency.dao.DAOException;
import com.epam.travelagency.dao.DAOWarning;
import com.epam.travelagency.dao.HotelDAO;
import com.epam.travelagency.dao.statement.HotelDAOStatement;




public class SQLHotelDAO implements HotelDAO {


	private DataSource source;
	
	public SQLHotelDAO(DataSource source) {
		this.source=source;
	}
	
	@Override
	public void add(Hotel hotel) throws DAOException {
		try {
			JdbcTemplate template = new JdbcTemplate(source);
			template.update(HotelDAOStatement.ADD_NEW_HOTEL,new HotelSetter(hotel));
		} catch (DuplicateKeyException e) {
			throw new DAOException(DAOWarning.USER_NOT_UNIQUE_DATA);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
	}

	@Override
	public List<Hotel> getAllHotels() throws DAOException {
		List<Hotel> hotelList;
		try {
		JdbcTemplate template = new JdbcTemplate(source);
		hotelList = template.query(HotelDAOStatement.GET_ALL_HOTELS, new HotelMapper());
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		return hotelList;
		
	}

	@Override
	public void delete(Integer id) throws DAOException {
		try {
			JdbcTemplate template = new JdbcTemplate(source);
			template.update(HotelDAOStatement.DELETE_HOTEL,id);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		
	}

	@Override
	public Hotel getHotel(Integer id) throws DAOException {
		Hotel hotel;
		try {
		JdbcTemplate template = new JdbcTemplate(source);
		hotel=template.queryForObject(HotelDAOStatement.GET_HOTEL_BY_ID,new HotelMapper(), new Object[] {id});		
		}catch (EmptyResultDataAccessException e) {
			throw new DAOException(DAOWarning.NOTHING_FOUND);
		}catch(DataAccessException e) {
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		return hotel;
	}

	@Override
	public void addFeature(Integer id, Feature feature) throws DAOException {
		try {
			JdbcTemplate template = new JdbcTemplate(source);
		
			template.update(HotelDAOStatement.UPDATE_FEATURES,feature.toString().toLowerCase(),id);
		} catch (DuplicateKeyException e) {
			throw new DAOException(DAOWarning.USER_NOT_UNIQUE_DATA);
		}catch(DataAccessException e) {
			e.printStackTrace();
			throw new DAOException(DAOWarning.CONNECTION_PROBLEMS);
		}
		
	}

}
