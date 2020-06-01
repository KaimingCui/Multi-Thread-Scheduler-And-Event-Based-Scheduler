package ood.ebs;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
public interface Stage {
	public void EventHandler(LinkedBlockingQueue<MyEvent> queue);
}
