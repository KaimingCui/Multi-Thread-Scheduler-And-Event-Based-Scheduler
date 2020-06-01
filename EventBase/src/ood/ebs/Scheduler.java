package ood.ebs;
/**
 * Scheduler
 * when scheduler receive a line it will start a job
 * the batch size control the maximum number of jobs active at a time
 * Has its own event queue
 */
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
//import java.util.Queue;

public class Scheduler implements Runnable,Stage{
	private static TallyByType tally = new TallyByType();
	private static List<Record> ExpensiveHouse = new ArrayList<>();
	
	private static int jobDown = 0;
	private static LinkedBlockingQueue<MyEvent> eventQueue = new LinkedBlockingQueue<>();
	private ExecutorService pool;
	private boolean flag = true;
	private int batchSize = 10;
	
	
	public Scheduler() {

	}
//	public Scheduler(PipedReader reader) {
//		this.reader = reader;
//	}
	public static  LinkedBlockingQueue<MyEvent> getQueue() {
		return Scheduler.eventQueue;
	}
	public static void AddQueue(MyEvent event) {
		Scheduler.eventQueue.add(event);
	}
	
	public static void register(Record record) {
		Scheduler.ExpensiveHouse.add(record);
	}
	
	public static TallyByType getTallyByType() {
		return Scheduler.tally;
	}
	
	public static void counteDown() {
		Scheduler.jobDown--;
	}
	
	public static void counteUp() {
		Scheduler.jobDown++;
	}
	
	public static int getCounter() {
		return Scheduler.jobDown;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			pool = Executors.newFixedThreadPool(batchSize);
//			long starttime = System.currentTimeMillis();
			if(!eventQueue.isEmpty()) {
				flag = true;
			}
			while(flag) {
				EventHandler(eventQueue);		
			}
			
			while(Scheduler.getCounter() != 0) {
				Thread.sleep(1000);
			}
			
			EventSource.generateEvent("Finished");
//			long endtime = System.currentTimeMillis();
//			System.out.println("time: " + (endtime-starttime));
			Set<Entry<String,Integer>> entryset = tally.getTally().entrySet();
			System.out.println("--------------------------------------------");
			System.out.println("Tally By Type:");
			for(Entry<String,Integer> entry:entryset) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void EventHandler(LinkedBlockingQueue<MyEvent> queue) {
		// TODO Auto-generated method stub
		while(!queue.isEmpty()) {
			try {
				if(queue.element().getWhatEvent() == "InputFinished") {
					flag = false;
					break;
				}
				Scheduler.counteUp();
				pool.execute(new Job(queue.take().getRequest()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
	}
	
	
}