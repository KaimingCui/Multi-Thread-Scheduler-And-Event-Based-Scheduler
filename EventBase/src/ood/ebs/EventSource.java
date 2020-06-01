package ood.ebs;
/**
 * event source
 * generate event and notify listener
 */
import java.util.ArrayList;

public class EventSource {
	private static ArrayList<MyEventListener> listeners = new ArrayList<>();
	
	public static void addMyEventListener(MyEventListener lis) {
		listeners.add(lis);
	}
	
	public static void removeMyEventListener(MyEventListener lis) {
		listeners.remove(lis);
	}
	
	public static void notifyListener(MyEvent event) {
		for(MyEventListener listener:listeners) {
			listener.HandleMyEvent(event);
		}
	}
	
	public static void generateEvent() {
		MyEvent event = new MyEvent(new EventSource());
		notifyListener(event);
	}
	
	public static void generateEvent(String name) {
		MyEvent event = new MyEvent(new EventSource(),name);
		notifyListener(event);
	}
	
	public static void generateEvent(String name,Record record) {
		MyEvent event = new MyEvent(new EventSource(),name,record);
		notifyListener(event);
	}
	
	public static void generateEvent(String name,String request) {
		MyEvent event = new MyEvent(new EventSource(),name,request);
		notifyListener(event);
	}
	
	
}
