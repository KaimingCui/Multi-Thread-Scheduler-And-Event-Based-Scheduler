package ood.tpr;

import java.util.Set;

public class TaskFour{
	private Record record;
	private String line;
	private String construction;
	private TallyByType tally;
	
	public TaskFour(Record record) {
		this.record = record;
	}
	
	public TaskFour(Record record,TallyByType tally) {
		this.record = record;
		this.tally = tally;
	}
	
	public TaskFour(String line, String construction) {
		this.line = line;
		this.construction = construction;
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

	public void process() {
		try {
			Thread.sleep(1000);
			
			
			String type = this.getLine() + "," + this.getConstruction();
			
			Set<String> keySet = tally.getTally().keySet();
			for(String str:keySet) {
				if(str.equals(type)) {
					Integer i = tally.getTally().get(type);
					tally.getTally().put(type,i+1);
				}
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
