package ood.ebs;

public class Record {
	private int Wait;
	private String Statecode;
	private String County;
	private double eq_site_limit;
	private double hu_site_limit;
	private double fl_site_limit;
	private double fr_site_limit;
	private double tiv_2011;
	private double tiv_2012;
	private double eq_site_deductible;
	private double hu_site_deductible;
	private double fl_site_deductible;
	private double fr_site_deductible;
	private double point_latitude;
	private double point_longitude;
	private String line;
	private String construction;
	private int point_granularity;
	private double distance = 0;
	

	public Record(String[] words) {
		this.Wait = Integer.parseInt(words[0]);
		this.Statecode = words[1];
		this.County = words[2];
		this.eq_site_limit = Double.valueOf(words[3]);
		this.hu_site_limit = Double.valueOf(words[4]);
		this.fl_site_limit = Double.valueOf(words[5]);
		this.fr_site_limit = Double.valueOf(words[6]);
		this.tiv_2011 = Double.valueOf(words[7]);
		this.tiv_2012 = Double.valueOf(words[8]);
		this.eq_site_deductible = Double.valueOf(words[9]);
		this.hu_site_deductible = Double.valueOf(words[10]);
		this.fl_site_deductible = Double.valueOf(words[11]);
		this.fr_site_deductible = Double.valueOf(words[12]);
		this.point_latitude = Double.valueOf(words[13]);
		this.point_longitude = Double.valueOf(words[14]);
		this.line =words[15];
		this.construction = words[16];
		this.point_granularity = Integer.parseInt(words[17]);
		
	}
	
//	public Record(int wait, String statecode, String county, double eq_site_limit, double hu_site_limit,
//			double fl_site_limit, double fr_site_limit, double tiv_2011, double tiv_2012, double eq_site_deductible,
//			double hu_site_deductible, double fl_site_deductible, double fr_site_deductible, double point_latitude,
//			double point_longitude, String line, String construction, int point_granularity) {
//		
//		
//		this.Wait = wait;
//		this.Statecode = statecode;
//		this.County = county;
//		this.eq_site_limit = eq_site_limit;
//		this.hu_site_limit = hu_site_limit;
//		this.fl_site_limit = fl_site_limit;
//		this.fr_site_limit = fr_site_limit;
//		this.tiv_2011 = tiv_2011;
//		this.tiv_2012 = tiv_2012;
//		this.eq_site_deductible = eq_site_deductible;
//		this.hu_site_deductible = hu_site_deductible;
//		this.fl_site_deductible = fl_site_deductible;
//		this.fr_site_deductible = fr_site_deductible;
//		this.point_latitude = point_latitude;
//		this.point_longitude = point_longitude;
//		this.line = line;
//		this.construction = construction;
//		this.point_granularity = point_granularity;
//	}
	
	
	public int getWait() {
		return Wait;
	}
	public String getStatecode() {
		return Statecode;
	}
	public String getCounty() {
		return County;
	}
	public double getEq_site_limit() {
		return eq_site_limit;
	}
	public double getHu_site_limit() {
		return hu_site_limit;
	}
	public double getFl_site_limit() {
		return fl_site_limit;
	}
	public double getFr_site_limit() {
		return fr_site_limit;
	}
	public double getTiv_2011() {
		return tiv_2011;
	}
	public double getTiv_2012() {
		return tiv_2012;
	}
	public double getEq_site_deductible() {
		return eq_site_deductible;
	}
	public double getHu_site_deductible() {
		return hu_site_deductible;
	}
	public double getFl_site_deductible() {
		return fl_site_deductible;
	}
	public double getFr_site_deductible() {
		return fr_site_deductible;
	}
	public double getPoint_latitude() {
		return point_latitude;
	}
	public double getPoint_longitude() {
		return point_longitude;
	}
	public String getLine() {
		return line;
	}
	public String getConstruction() {
		return construction;
	}
	public int getPoint_granularity() {
		return point_granularity;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	public String toString() {
		return this.Wait + "," + this.Statecode + "," + this.County + "," + this.eq_site_limit + "," + this.hu_site_limit + ","
				+ this.fl_site_limit + "," + this.fr_site_limit + "," + this.tiv_2011 + "," + this.tiv_2012 + "," + this.eq_site_deductible + ","
				+ this.hu_site_deductible + "," + this.fl_site_deductible + "," + this.fr_site_deductible + "," + this.point_latitude + ","
				+ this.point_longitude + "," + this.line + "," + this.construction + "," + this.point_granularity + "," + this.distance;
	}
	
}
