package ood.tpr;
/**
 * starter
 * create pipeline
 * start scheduler and client
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Starter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PipedWriter writer = new PipedWriter();
			PipedReader reader = new PipedReader();
			BufferedReader input = new BufferedReader(new FileReader("FloridaCounties.csv"));
		
			writer.connect(reader);
			
			Thread client = new Thread(new Client(writer,input));
			Thread scheduler = new Thread(new Scheduler(reader));
			
			client.start();
			scheduler.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
