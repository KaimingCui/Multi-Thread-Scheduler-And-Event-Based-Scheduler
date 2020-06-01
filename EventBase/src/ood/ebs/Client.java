package ood.ebs;
/**
 * Client
 * read the file, line by line
 * According to the wait time number to wait
 * once read a line, send that line into scheduler (generate event)
 * After read all lines of the file, generate a event that tells input down
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PipedWriter;

public class Client implements Runnable{
	private PipedWriter writer;
	private String line = null;
	private List<String> records = new ArrayList<>();
	private BufferedReader input;
	
	public Client(PipedWriter writer,BufferedReader input) {
		this.writer = writer;
		this.input = input;
	}
	public Client(PipedWriter writer) {
		this.writer = writer;
	}
	
	public Client(BufferedReader input) {
		this.input = input;
	}

	
	public List<String> getRecords() {
		return records;
	}
	
	public PipedWriter getPipedWriter() {
		return writer;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			input.readLine();
		
			while((line = input.readLine())!=null){

				EventSource.generateEvent("NewRequest", line);
				
				if(line.charAt(0) == 0) {
					
				}else if(line.charAt(0) == 1) {
					Thread.sleep(1000);
				}else if(line.charAt(0) == 2) {
					Thread.sleep(2000);
				}else if(line.charAt(0) == 3) {
					Thread.sleep(3000);
				}else if(line.charAt(0) == 4) {
					Thread.sleep(4000);
				}else {
					Thread.sleep(5000);
				}
						
			}
			
			EventSource.generateEvent("InputFinished");


		
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}