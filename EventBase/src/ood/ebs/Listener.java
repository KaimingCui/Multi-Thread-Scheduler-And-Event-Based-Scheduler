package ood.ebs;
/**
 * The observer
 * once it received a event it will send that event to some event queue
 * based on the name of event
 * @author kaimingcui
 *
 */
public class Listener implements MyEventListener{
	
	@Override
	public void HandleMyEvent(MyEvent event) {
		// TODO Auto-generated method stub
		switch(event.getWhatEvent()) {
		case "NewRequest":
			Scheduler.AddQueue(event);
			break;
		case "GoStateOne":
			StateOne.AddQueue(event);
			break;
		case "GoStateTwo":
			StateTwo.AddQueue(event);
			break;
		case "GoStateThree":
			StateThree.AddQueue(event);
			break;
		case "GoStateFour":
			StateFour.AddQueue(event);
			break;
		case "GoStateFive":
			StateFive.AddQueue(event);
			break;
		case "jobDown":
			Scheduler.counteDown();
			break;
		case "InputFinished":
			Scheduler.AddQueue(event);
			break;
		case "Finished":
			StateOne.AddQueue(event);
			StateTwo.AddQueue(event);
			StateThree.AddQueue(event);
			StateFour.AddQueue(event);
			StateFive.AddQueue(event);
			break;
		default:
			break;
		}
	}

}
