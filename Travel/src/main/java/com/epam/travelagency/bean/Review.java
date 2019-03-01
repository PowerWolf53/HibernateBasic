package com.epam.travelagency.bean;

import java.io.Serializable;
import java.util.Date;

public class Review implements Serializable {


	private static final long serialVersionUID = 3995438355361050339L;

	private int id;
	
	private Date date;
	
	private String text;
	
	private int userId;
	
	private int tourId;
	
	public Review() {
	
	}
	
	public Review(Date date,String text,int userId,int tourId) {
		this.date=date;
		this.text=text;
		this.userId=userId;
		this.tourId=tourId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + tourId;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (tourId != other.tourId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", date=" + date + ", text=" + text + ", userId=" + userId + ", tourId=" + tourId
				+ "]";
	}
	
	
	
}
