package com.epam.travelagency.dao.statement;

public class HotelDAOStatement {

	public static final String ADD_NEW_HOTEL="INSERT INTO \"TravelAgency\".\"Hotel\" (\"name\",\"stars\",\"website\",\"latitude\",\"longtitude\",\"features\") values(?,?,?,?,?,?)";

	public static final String GET_ALL_HOTELS="SELECT * FROM \"TravelAgency\".\"Hotel\"";
	
	public static final String DELETE_HOTEL="DELETE FROM \"TravelAgency\".\"Hotel\" WHERE \"id\"=?";
	
	public static final String GET_HOTEL_BY_ID="SELECT * FROM \"TravelAgency\".\"Hotel\" WHERE \"id\"=?";
	
	public static final String UPDATE_FEATURES="UPDATE \"TravelAgency\".\"Hotel\" SET \"features\"=array_append(\"features\",CAST (? AS features)) WHERE id=?";
}
