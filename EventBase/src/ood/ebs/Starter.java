package ood.ebs;
/**
 * the starter of the program
 * create the scheduler and the stages
 * start them
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Starter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//start the program, register the listener into list.
			Listener lis = new Listener();
			EventSource.addMyEventListener(lis);
			//input stream to read the file
			BufferedReader input = new BufferedReader(new FileReader("FloridaCounties.csv"));
					
			Thread client = new Thread(new Client(input));
			Thread scheduler = new Thread(new Scheduler());
			Thread stateOne = new Thread(new StateOne());
			Thread stateTwo = new Thread(new StateTwo());
			Thread stateThree = new Thread(new StateThree());
			Thread stateFour = new Thread(new StateFour());
			Thread stateFive= new Thread(new StateFive());
			
			client.start();
			scheduler.start();
			stateOne.start();
			stateTwo.start();
			stateThree.start();
			stateFour.start();
			stateFive.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
