package ood.tpr;

public class TaskFive{
	private double eq_site_license;
	private Record record;
	
	public TaskFive(double eq_site_license) {
		this.eq_site_license = eq_site_license;
	}
	
	public TaskFive(double eq_site_license,Record record) {
		this.eq_site_license = eq_site_license;
		this.record = record;
	}
	
	public TaskFive(Record record) {
		this.record = record;
	}
	
	public double getEq_site_license() {
		return eq_site_license;
	}



	public void setEq_site_license(double eq_site_license) {
		this.eq_site_license = eq_site_license;
	}



	public void process() {
		
		if(this.eq_site_license >= 800000) {
			Scheduler.register(record);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
