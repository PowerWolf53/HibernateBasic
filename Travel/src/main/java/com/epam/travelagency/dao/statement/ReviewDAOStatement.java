package com.epam.travelagency.dao.statement;

public class ReviewDAOStatement {

	public static final String ADD_NEW_REVIEW ="INSERT INTO \"TravelAgency\".\"Review\" (\"date\",\"text\",\"id_User\",\"id_Tour\") values(?::Date,?,?,?)";
	
	public static final String GET_REVIEW_BY_ID="SELECT * FROM \"TravelAgency\".\"Review\" WHERE \"id\"=?";
	
	public static final String DELETE_REVIEW="DELETE FROM \"TravelAgency\".\"Review\" WHERE \"id\"=?";
	
	public static final String CHANGE_TEXT="UPDATE \"TravelAgency\".\"Review\" SET text=? WHERE id=?";
}
