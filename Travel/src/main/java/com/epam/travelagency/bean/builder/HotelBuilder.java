package com.epam.travelagency.bean.builder;



import com.epam.travelagency.bean.Feature;
import com.epam.travelagency.bean.Hotel;


public class HotelBuilder {

	private int id;

	private String name;

	private int stars;

	private String website;

	private double latitude;

	private double longtitude;

	private Feature[] features;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

	public Feature[] getFeatures() {
		return features;
	}

	public void setFeatures(Feature[] features) {
		this.features = features;
	}
	
	public HotelBuilder id(int id) {
		this.setId(id);
		return this;
	}

	public HotelBuilder name(String name) {
		this.setName(name);
		return this;
	}

	public HotelBuilder stars(Integer stars) {
		this.setStars(stars);
		return this;
	}

	public HotelBuilder longtitude(double longtitude) {
		this.setLongtitude(longtitude);
		return this;
	}
	
	public HotelBuilder latitude(double latitude) {
		this.setLatitude(latitude);
		return this;
	}

	public HotelBuilder website(String website) {
		this.setWebsite(website);
		return this;
	}
	
	public HotelBuilder features(Feature[] features) {
		this.setFeatures(features);
		return this;
	}
	
	
	
	public Hotel build() {
		Hotel hotel = new Hotel();
		hotel.setId(this.getId());
		hotel.setName(this.getName());
		hotel.setStars(this.getStars());
		hotel.setWebsite(this.getWebsite());
		hotel.setLongtitude(this.getLongtitude());
		hotel.setLatitude(this.getLatitude());
		hotel.setFeatures(this.getFeatures());
		return hotel;
	
	}
	
	

}
