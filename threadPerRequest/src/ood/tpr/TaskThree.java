package ood.tpr;

import java.text.DecimalFormat;

public class TaskThree {
	private static double EARTH_RADIUS = 6378.137; //unit: km
	private static double fix_latitude = 30.0;
	private static double fix_longitude = -81.0;
	private double distance;
	private double latitude;
	private double longitude;
	private Record record;
	
	
	public TaskThree(Record record) {
		this.record = record;
	}
	
	public TaskThree(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	public static double getEARTH_RADIUS() {
		return EARTH_RADIUS;
	}

	public static void setEARTH_RADIUS(double eARTH_RADIUS) {
		EARTH_RADIUS = eARTH_RADIUS;
	}

	public static double getFix_latitude() {
		return fix_latitude;
	}

	public static void setFix_latitude(double fix_latitude) {
		TaskThree.fix_latitude = fix_latitude;
	}

	public static double getFix_longitude() {
		return fix_longitude;
	}

	public static void setFix_longitude(double fix_longitude) {
		TaskThree.fix_longitude = fix_longitude;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getDistance() {
		return this.distance;
	}
	
	public double getRadius(double degree) {
		return degree * Math.PI / 180.0;
	}
	
	//calculate the distance between two point according to latitude and longitude
	//unit: meter
	public double CalDistance(double lat1,double lat2,double lng1, double lng2) {
		double radLat1 = getRadius(lat1);
		double radLat2 = getRadius(lat2);
		double lat = radLat1 - radLat2;
		double lon = getRadius(lng1) - getRadius(lng2);
		
		double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(lat/2), 2))) + 
						Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(lon/2), 2);
		distance = distance * EARTH_RADIUS;
		
		return distance * 1000;
		
	}
	
	public double process() {
		
		
		DecimalFormat df = new DecimalFormat("0.000000");
		setDistance(Double.valueOf(df.format(CalDistance(fix_latitude,latitude,fix_longitude,longitude))));
		
		
		return this.getDistance();
	}
	

}
