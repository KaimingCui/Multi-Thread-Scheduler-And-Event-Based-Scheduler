package ood.ebs;

import ood.ebs.Record;

public class TaskTwo implements Task,FlyWeight{

	private Record record;
	private int pg;
	
	public TaskTwo(Record record) {
		this.record = record;
	}
	
	public void setRecord(Record record) {
		this.record = record;
	}
	@Override
	public void operation() {
		// TODO Auto-generated method stub
		pg = record.getPoint_granularity();
		for(int i = 0; i < (int)record.getEq_site_limit();i++) {
			
		}
		for(int i = 0; i < (int)record.getHu_site_limit();i++) {
			
		}
		for(int i = 0; i < (int)record.getFl_site_limit();i++) {
			
		}
		for(int i = 0; i < (int)record.getFr_site_limit();i++) {
			
		}
		
		
		switch(pg) {
		case 1:
			EventSource.generateEvent("GoStateThree", record);
			break;
		case 2:
			EventSource.generateEvent("jobDown");
			break;
		case 3:
			EventSource.generateEvent("jobDown");
			break;
		case 4:
			EventSource.generateEvent("GoStateFive", record);
			break;
		case 5:
			EventSource.generateEvent("GoStateFive", record);
			break;
		case 7:
			EventSource.generateEvent("GoStateFive", record);
			break;
		default:
				break;
		}
	}

	@Override
	public void setContent(String request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContent(Record record) {
		// TODO Auto-generated method stub
		this.setRecord(record);
	}

}