package ood.tpr;
/**
 * receive a line from client
 * start a job using that line
 * jobs are in a thread pool
 */
import java.io.IOException;
import java.io.PipedReader;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.*;

public class Scheduler implements Runnable{
	private PipedReader reader;
	private String request = new String("");
	private static TallyByType tally = new TallyByType();
	private static List<Record> ExpensiveHouse = new ArrayList<>();
	
	public Scheduler(PipedReader reader) {
		this.reader = reader;
	}
	
	public static void register(Record record) {
		Scheduler.ExpensiveHouse.add(record);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ExecutorService pool = Executors.newFixedThreadPool(90);
			StringBuilder temp = new StringBuilder("");
			int ch = reader.read();
//			long starttime = System.currentTimeMillis();
			while(ch != -1) {
				if(((char)ch) == '\n') {
					request = temp.toString();
					temp.replace(0, temp.length(), "");

					pool.execute(new Jobs(request,tally));
					
				}else {
					temp.append((char)ch);
				}
				
				ch = reader.read();
			}
			
//			long endtime = System.currentTimeMillis();
//			System.out.println("time: " + (endtime - starttime));
			Set<Entry<String,Integer>> entryset = tally.getTally().entrySet();
			System.out.println("--------------------------------------------");
			System.out.println("Tally By Type:");
			for(Entry<String,Integer> entry:entryset) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
