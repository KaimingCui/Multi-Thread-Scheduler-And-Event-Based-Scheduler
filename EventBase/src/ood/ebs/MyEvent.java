package ood.ebs;

import java.util.EventObject;

public class MyEvent extends EventObject{
	
	private String whatEvent;
	private Record record;
	private String request;
	
	public MyEvent(Object source,String whatEvent) {
		super(source);
		this.whatEvent = whatEvent;
	}
	
	public MyEvent(Object source,String whatEvent,Record record) {
		super(source);
		this.whatEvent = whatEvent;
		this.record = record;
	}
	
	public MyEvent(Object source,String whatEvent,String request) {
		super(source);
		this.whatEvent = whatEvent;
		this.request = request;
	}
	
	public MyEvent(Object source) {
		super(source);
	}
	
	public String getWhatEvent() {
		return this.whatEvent;
	}
	
	public Record getRecord() {
		return this.record;
	}
	
	public String getRequest() {
		return this.request;
	}

}
