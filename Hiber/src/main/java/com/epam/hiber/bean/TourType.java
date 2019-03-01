package com.epam.hiber.bean;

public enum TourType {
   SPA,AUTO,BYCYCLE,HOLIDAY,WEDDING,SHOP,EXTREME,EXCURSION,CHILDREN,EDUCATIONAL;
	
	public static TourType getValue(String type) {
		switch(type) {
		case "spa":return SPA;
		case "auto":return AUTO;
		case "bycycle":return BYCYCLE;
		case "holiday":return HOLIDAY;
		case "wedding":return WEDDING;
		case "shop":return SHOP;
		case "extreme":return EXTREME;
		case "excursion":return EXCURSION;
		case "children": return CHILDREN;
		case "educational": return EDUCATIONAL;
		default:return null;
		}
	}
}
