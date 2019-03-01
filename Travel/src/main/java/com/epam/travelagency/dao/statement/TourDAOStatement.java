package com.epam.travelagency.dao.statement;

public class TourDAOStatement {
	
	public static final String ADD_NEW_TOUR ="INSERT INTO \"TravelAgency\".\"Tour\" (\"photo\",\"date\",\"duration\",\"description\",\"cost\",\"tourType\",\"id_Hotel\",\"id_Country\") values(?,?::Date,?,?,?,?::\"TravelAgency\".\"tourType\",?,?)";
	
	public static final String GET_TOUR_BY_ID="SELECT * FROM \"TravelAgency\".\"Tour\" WHERE \"id\"=?";
	
	public static final String DELETE_TOUR="DELETE FROM \"TravelAgency\".\"Tour\" WHERE \"id\"=?";
	
	public static final String CHANGE_DESCRIPTION="UPDATE \"TravelAgency\".\"Tour\" SET description=? WHERE id=?";
}
