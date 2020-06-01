package ood.ebs;
/**
 * state three
 * execute task three
 * Has its own event queue
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class StateThree implements Runnable,Stage{
	private static LinkedBlockingQueue<MyEvent> eventQueue = new LinkedBlockingQueue<>();
//	private ExecutorService pool;
	private boolean flag = true;
//	private int batchSize = 10;
	
	
	public static  LinkedBlockingQueue<MyEvent> getQueue() {
		return StateThree.eventQueue;
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
//				pool.execute(new TaskThree(queue.take().getRecord()));
//				pool.execute((TaskThree)(FlyweightFactory.factory("task3", queue.take())));
				Task task = (Task)FlyweightFactory.factory("task3", queue.take());
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
