package ood.ebs;
/**
 * generate specific event accoding to the pg number
 */
import ood.ebs.Record;
import ood.ebs.Scheduler;

public class TaskFive implements Task,FlyWeight{
	private double eq_site_license;
	private Record record;
	private int pg;
	
//	public TaskFive(double eq_site_license) {
//		this.eq_site_license = eq_site_license;
//	}
//	
//	public TaskFive(double eq_site_license,Record record) {
//		this.eq_site_license = eq_site_license;
//		this.record = record;
//	}
//	
	public TaskFive(Record record) {
		this.record = record;
		this.eq_site_license = record.getEq_site_limit();
	}
	
	public double getEq_site_license() {
		return eq_site_license;
	}

	public void setRecord(Record record) {
		this.record = record;
		this.eq_site_license = record.getEq_site_limit();
	}

	public void setEq_site_license(double eq_site_license) {
		this.eq_site_license = eq_site_license;
	}


	@Override
	public void operation() {
		// TODO Auto-generated method stub
		pg = record.getPoint_granularity();
		
		if(this.eq_site_license >= 800000) {
			Scheduler.register(record);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		switch(pg){
		case 1:
			EventSource.generateEvent("jobDown");
			break;
		case 2:
			EventSource.generateEvent("GoStateTwo", record);
			break;
		case 3:
			EventSource.generateEvent("GoStateFour", record);
			break;
		case 4:
			EventSource.generateEvent("GoStateThree", record);
			break;
		case 5:
			EventSource.generateEvent("GoStateThree", record);
			break;
		case 7:
			EventSource.generateEvent("GoStateFour", record);
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