package ood.ebs;

import java.util.Set;
import java.util.Map.Entry;

import ood.ebs.Record;
import ood.ebs.TallyByType;

public class TaskFour implements Task,FlyWeight{
	private Record record;
	private String line;
	private String construction;
	private TallyByType tally;
	private int pg;
	
	public TaskFour(Record record) {
		this.record = record;
		this.tally = Scheduler.getTallyByType();
		this.line = record.getLine();
		this.construction = record.getConstruction();
	}
	
//	public TaskFour(Record record,TallyByType tally) {
//		this.record = record;
//		this.tally = tally;
//	}
//	
//	public TaskFour(String line, String construction) {
//		this.line = line;
//		this.construction = construction;
//		this.tally = Scheduler.getTallyByType();
//	}
	
	public void setRecord(Record record) {
		this.record = record;
		this.line = record.getLine();
		this.construction = record.getConstruction();
	}
	
	public TaskFour(String line, String construction,TallyByType tally) {
		this.line = line;
		this.construction = construction;
		this.tally = tally;
	}
	
	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getConstruction() {
		return construction;
	}

	public void setConstruction(String construction) {
		this.construction = construction;
	}


	@Override
	public void operation() {
		// TODO Auto-generated method stub
		try {
			pg = record.getPoint_granularity();
			Thread.sleep(1000);

			String type = this.getLine() + "," + this.getConstruction();

			Set<String> keySet = tally.getTally().keySet();

			for(String str:keySet) {
				if(str.equals(type)) {
					Integer i = tally.getTally().get(type);
					tally.getTally().put(type,i+1);
				}
			}
			
//			System.out.println(this.getLine() + "," + this.getConstruction());
			switch(pg){
			case 1:
				EventSource.generateEvent("GoStateFive", record);
				break;
			case 2:
				EventSource.generateEvent("GoStateFive", record);
				break;
			case 3:
				EventSource.generateEvent("GoStateThree", record);
				break;
			case 4:
				EventSource.generateEvent("GoStateTwo", record);
				break;
			case 5:
				EventSource.generateEvent("jobDown");
				break;
			case 7:
				EventSource.generateEvent("jobDown");
				break;
			default:
				break;
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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