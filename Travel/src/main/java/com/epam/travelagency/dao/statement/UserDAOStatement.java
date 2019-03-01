package com.epam.travelagency.dao.statement;

public class UserDAOStatement {

	public static final String ADD_NEW_USER ="INSERT INTO \"TravelAgency\".\"User\" (\"login\",\"password\") values(?,?)";
	
	public static final String GET_ALL_USERS="SELECT * FROM \"TravelAgency\".\"User\"";
	
	public static final String GET_USER_BY_ID="SELECT * FROM \"TravelAgency\".\"User\" WHERE \"id\"=?";
	
	public static final String DELETE_USER="DELETE FROM \"TravelAgency\".\"User\" WHERE \"id\"=?";
	
	public static final String CHANGE_PASSWORD="UPDATE \"TravelAgency\".\"User\" SET password=? WHERE id=?";
	
	public static final String GET_USER_BY_LOGIN="SELECT * FROM \"TravelAgency\".\"User\" WHERE \"login\"=?";
	
	public static final String ADD_TOUR ="INSERT INTO \"TravelAgency\".\"UserTour\" (\"id_User\",\"id_Tour\") values(?,?)";
	
	public static final String DELETE_TOUR="DELETE FROM \"TravelAgency\".\"UserTour\" WHERE \"id_User\"=? AND \"id_Tour\"=? ";
}
