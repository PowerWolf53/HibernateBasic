package com.epam.travelagency.bean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Feature {
	POOL,DECKCHAIRS,AQUABAR,SEA,WIFI,SAUNA,CHILDRENZONE,SPORTCLUB,SOUVENIRS,TOWELS;
	
	public static String[] convertToArray(Feature[] features) {
		List<String> strings = Stream.of(features).map(e -> e.name().toLowerCase()).collect(Collectors.toList());
		return strings.toArray(new String[strings.size()]);
		
	}
	
	public static Feature[] convertToEnum(String[] features) {
		Feature[] featureArray=new Feature[features.length];
		for(int i=0;i<features.length;i++) {
			featureArray[i]= Feature.getValue(features[i]);
		}
		return featureArray;
	}
	
	public static Feature getValue(String feature) {
		switch(feature) {
		case "pool":return Feature.POOL;
		case "deckchairs":return Feature.DECKCHAIRS;
		case "aquabar":return Feature.AQUABAR;
		case "sea":return Feature.SEA;
		case "wifi":return Feature.WIFI;
		case "sauna":return Feature.SAUNA;
		case "chilrenzone":return Feature.CHILDRENZONE;
		case "sportclub":return Feature.SPORTCLUB;
		case "souvenirs":return Feature.SOUVENIRS;
		case "towels":return Feature.TOWELS;
		default:return null;
		}
	}
}
