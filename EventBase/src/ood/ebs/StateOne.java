package ood.ebs;
/**
 * state one
 * get task one from factory and run it
 * Has its own event queue
 */
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class StateOne implements Runnable,Stage{
//	private static Queue<MyEvent> eventQueue= new LinkedBlockingQueue<>();
	private static LinkedBlockingQueue<MyEvent> eventQueue = new LinkedBlockingQueue<>();
//	private ExecutorService pool;
	private boolean flag = true;
//	private int batchSize = 10;
	
	public static  LinkedBlockingQueue<MyEvent> getQueue() {
		return StateOne.eventQueue;
	}
	public static void AddQueue(MyEvent event) {
		eventQueue.add(event);
	}
	
	
	@Override
	public void EventHandler(LinkedBlockingQueue<MyEvent> queue) {
		// TODO Auto-generated method stub
		while(!queue.isEmpty()) {
			try {
				if(queue.element().getWhatEvent() == "Finished") {
					flag = false;
					break;
				}
//				pool.execute(new TaskOne(queue.take().getRequest()));
//				pool.execute(((TaskOne)(FlyweightFactory.factory("task1", queue.take()))));
				
				Task task = (Task)FlyweightFactory.factory("task1", queue.take());
				task.operation();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub

//		pool = Executors.newFixedThreadPool(batchSize);
		while(flag) {
			EventHandler(eventQueue);
		}
	}

}
