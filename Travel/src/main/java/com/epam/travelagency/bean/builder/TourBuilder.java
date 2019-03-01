package com.epam.travelagency.bean.builder;

import java.util.Date;



import com.epam.travelagency.bean.Tour;
import com.epam.travelagency.bean.TourType;

public class TourBuilder {

	private int id;

	private String photo;

	private Date date;

	private int duration;

	private String description;

	private double cost;

	private TourType type;
	


	public TourBuilder id(int id) {
		this.setId(id);
		return this;
	}

	public TourBuilder photo(String photo) {
		this.setPhoto(photo);
		return this;
	}

	public TourBuilder date(Date date) {
		this.setDate(date);
		return this;
	}

	public TourBuilder duration(int duration) {
		this.setDuration(duration);
		return this;
	}

	public TourBuilder description(String description) {
		this.setDescription(description);
		return this;
	}
	
	public TourBuilder cost(double cost) {
		this.setCost(cost);
		return this;
	}
	
	public TourBuilder type(TourType type) {
		this.setType(type);
		return this;
	}
	
	public Tour build() {
		Tour tour=new Tour();
		tour.setId(this.getId());
		tour.setPhoto(this.getPhoto());
		tour.setDate(this.getDate());
		tour.setDuration(this.getDuration());
		tour.setDescription(this.getDescription());
		tour.setCost(this.getCost());
		tour.setType(this.getType());
		return tour;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public TourType getType() {
		return type;
	}

	public void setType(TourType type) {
		this.type = type;
	}

}
