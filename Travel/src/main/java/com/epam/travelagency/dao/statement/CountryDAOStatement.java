package com.epam.travelagency.dao.statement;

public class CountryDAOStatement {

	public static final String ADD_NEW_COUNTRY="INSERT INTO \"TravelAgency\".\"Country\" (name) values(?)";
	
	public static final String GET_ALL_COUNTRIES="SELECT * FROM \"TravelAgency\".\"Country\"";
	
	public static final String GET_COUNTRY_BY_ID="SELECT * FROM \"TravelAgency\".\"Country\" WHERE \"id\"=?";
	
	public static final String GET_COUNTRY_BY_NAME="SELECT * FROM \"TravelAgency\".\"Country\" WHERE \"name\"=?";
	
	public static final String DELETE_COUNTRY="DELETE FROM \"TravelAgency\".\"Country\" WHERE \"id\"=?";
}
