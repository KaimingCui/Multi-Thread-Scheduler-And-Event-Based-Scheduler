package ood.ebs;
/**
 * the factory
 * will return the object if it has existed
 * will create new task if it is not existed
 */
import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
	private static Map<String,FlyWeight> tasks = new HashMap<>();
	
	public static FlyWeight factory(String state,MyEvent event) {
		FlyWeight fly = tasks.get(state);
		if(fly == null) {
			if(state == "task1") {
				fly = new TaskOne(event.getRequest());
			}else if(state == "task2") {
				fly = new TaskTwo(event.getRecord());
			}else if(state == "task3") {
				fly = new TaskThree(event.getRecord());
			}else if(state == "task4") {
				fly = new TaskFour(event.getRecord());
			}else if(state == "task5") {
				fly = new TaskFive(event.getRecord());
			}
			
			tasks.put(state, fly);
		}
		
		if(state == "task1") {
			fly.setContent(event.getRequest());
		}else {
			fly.setContent(event.getRecord());
		}
		
		return fly;
	}
}
