package ood.tpr;
/**
 * based on the pg number to execute the tasks
 */
import java.io.IOException;

public class Jobs implements Runnable{
	private String request = "";
	private TallyByType tally;
	private double distance;
	
	public Jobs(String request) {
		this.request = request;
	}
	
	public Jobs(String request,TallyByType tally) {
		this.request = request;
		this.tally = tally;
	}
	
	public String getRequest() {
		return this.request;
	}
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			int pg = Integer.parseInt(request.substring(request.length()-1));
			
			TaskOne one = new TaskOne(this.request);
			one.process();

			if(pg == 1) {
				TaskTwo two = new TaskTwo(one.getRecord());
				two.process();
				TaskThree three = new TaskThree(one.getRecord().getPoint_latitude(),one.getRecord().getPoint_longitude());
				this.setDistance(three.process());
				TaskFour four = new TaskFour(one.getRecord().getLine(),one.getRecord().getConstruction(),tally);
				four.process();
				TaskFive five = new TaskFive(one.getRecord().getEq_site_limit());
				five.process();
				
				
			}else if(pg == 2){
				TaskThree three = new TaskThree(one.getRecord().getPoint_latitude(),one.getRecord().getPoint_longitude());
				this.setDistance(three.process());
				TaskFour four = new TaskFour(one.getRecord().getLine(),one.getRecord().getConstruction(),tally);
				four.process();
				TaskFive five = new TaskFive(one.getRecord().getEq_site_limit());
				five.process();
				TaskTwo two = new TaskTwo(one.getRecord());
				two.process();
				
				
			}else if(pg == 3) {
				TaskFive five = new TaskFive(one.getRecord().getEq_site_limit());
				five.process();
				TaskFour four = new TaskFour(one.getRecord().getLine(),one.getRecord().getConstruction(),tally);
				four.process();
				TaskThree three = new TaskThree(one.getRecord().getPoint_latitude(),one.getRecord().getPoint_longitude());
				this.setDistance(three.process());
				TaskTwo two = new TaskTwo(one.getRecord());
				two.process();


			}else if(pg == 4) {
				TaskFour four = new TaskFour(one.getRecord().getLine(),one.getRecord().getConstruction(),tally);
				four.process();
				TaskTwo two = new TaskTwo(one.getRecord());
				two.process();
				TaskFive five = new TaskFive(one.getRecord().getEq_site_limit());
				five.process();
				TaskThree three = new TaskThree(one.getRecord().getPoint_latitude(),one.getRecord().getPoint_longitude());
				this.setDistance(three.process());
				
			}else if(pg == 5) {
				TaskTwo two = new TaskTwo(one.getRecord());
				two.process();
				TaskFive five = new TaskFive(one.getRecord().getEq_site_limit());
				five.process();
				TaskThree three = new TaskThree(one.getRecord().getPoint_latitude(),one.getRecord().getPoint_longitude());
				this.setDistance(three.process());
				TaskFour four = new TaskFour(one.getRecord().getLine(),one.getRecord().getConstruction(),tally);
				four.process();
				
			}else {
				TaskThree three = new TaskThree(one.getRecord().getPoint_latitude(),one.getRecord().getPoint_longitude());
				this.setDistance(three.process());
				TaskTwo two = new TaskTwo(one.getRecord());
				two.process();
				TaskFive five = new TaskFive(one.getRecord().getEq_site_limit());
				five.process();
				TaskFour four = new TaskFour(one.getRecord().getLine(),one.getRecord().getConstruction(),tally);
				four.process();
			}
			
//			System.out.println(this.getRequest() + "," + this.getDistance());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
