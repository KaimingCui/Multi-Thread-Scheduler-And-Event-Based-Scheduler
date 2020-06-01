package ood.ebs;
/**
 * receive the line
 * generate event go to state one
 * @author kaimingcui
 *
 */
public class Job implements Runnable{
	private String request;
	
	public Job(String request) {
		this.request = request;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		EventSource.generateEvent("GoStateOne", request);
//		System.out.println(request);
	}

}
