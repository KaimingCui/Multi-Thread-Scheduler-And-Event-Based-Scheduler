package ood.ebs;

import java.text.DecimalFormat;

import ood.ebs.Record;

public class TaskThree implements Task,FlyWeight{
	private static double EARTH_RADIUS = 6378.137; //unit: km
	private static double fix_latitude = 30.0;
	private static double fix_longitude = -81.0;
	private double distance;
	private double latitude;
	private double longitude;
	private Record record;
	private int pg;
	
	
	public TaskThree(Record record) {
		this.record = record;
		this.latitude = record.getPoint_latitude();
		this.longitude = record.getPoint_longitude();
	}
	
//	public TaskThree(double latitude, double longitude) {
//		this.latitude = latitude;
//		this.longitude = longitude;
//	}
	
	public void setRecord(Record record) {
		this.record = record;
		this.latitude = record.getPoint_latitude();
		this.longitude = record.getPoint_longitude();
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

	@Override
	public void operation() {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("0.000000");
		record.setDistance(Double.valueOf(df.format(CalDistance(fix_latitude,latitude,fix_longitude,longitude))));
		pg = record.getPoint_granularity();
		
		switch(pg){
		case 1:
			EventSource.generateEvent("GoStateFour", record);
			break;
		case 2:
			EventSource.generateEvent("GoStateFour", record);
			break;
		case 3:
			EventSource.generateEvent("GoStateTwo", record);
			break;
		case 4:
			EventSource.generateEvent("jobDown");
			break;
		case 5:
			EventSource.generateEvent("GoStateFour", record);
			break;
		case 7:
			EventSource.generateEvent("GoStateTwo", record);
			break;
		default:
			break;
		}
	}

	@Override
	public void setContent(String request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContent(Record record) {
		// TODO Auto-generated method stub
		this.setRecord(record);
	}
	

}