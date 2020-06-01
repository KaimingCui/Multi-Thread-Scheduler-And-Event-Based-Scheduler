package ood.tpr;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PipedWriter;
/**
 * read a line from input file and send it to scheduler
 * @author kaimingcui
 *
 */
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
//			BufferedReader input = new BufferedReader(new FileReader("FloridaCountiesLess.csv"));
			input.readLine();
			
			while((line = input.readLine())!=null){
				records.add(line);
				line = line + "\n";
				writer.write(line);

				
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
			
			writer.close();
			
			
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}