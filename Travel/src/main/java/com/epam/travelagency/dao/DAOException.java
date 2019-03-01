package com.epam.travelagency.dao;

public class DAOException extends Exception {


	private static final long serialVersionUID = 9004886775664900053L;

	public DAOException()
	{
		super();
	}
	
	public DAOException(String message)
	{
		super(message);
	}
	
	public DAOException(String message,Exception e) 
	{
		super(message,e);
	}
}
