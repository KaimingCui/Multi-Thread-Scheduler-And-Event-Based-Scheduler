package ood.ebs;

import ood.ebs.Record;

public class TaskOne implements Task,FlyWeight{

	private String[] words;
	private String request;
	private Record record;
	private int pg;
	
	public TaskOne(String request) {
		this.request = request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String[] getWords() {
		return this.words;
	}
	
	public int getWait() {
		return record.getWait();
	}

	public String getStatecode() {
		return record.getStatecode();
	}

	public String getCounty() {
		return record.getCounty();
	}

	public double getEq_site_limit() {
		return record.getEq_site_limit();
	}

	public double getHu_site_limit() {
		return record.getHu_site_limit();
	}

	public double getFl_site_limit() {
		return record.getFl_site_limit();
	}

	public double getFr_site_limit() {
		return record.getFr_site_limit();
	}

	public double getTiv_2011() {
		return record.getTiv_2011();
	}

	public double getTiv_2012() {
		return record.getTiv_2012();
	}

	public double getEq_site_deductible() {
		return record.getEq_site_deductible();
	}

	public double getHu_site_deductible() {
		return record.getHu_site_deductible();
	}

	public double getFl_site_deductible() {
		return record.getFl_site_deductible();
	}

	public double getFr_site_deductible() {
		return record.getFr_site_deductible();
	}

	public double getPoint_latitude() {
		return record.getPoint_latitude();
	}

	public double getPoint_longitude() {
		return record.getPoint_longitude();
	}

	public String getLine() {
		return record.getLine();
	}

	public String getConstruction() {
		return record.getConstruction();
	}

	public int getPoint_granularity() {
		return record.getPoint_granularity();
	}

	public Record getRecord() {
		return this.record;
	}

	@Override
	public void operation() {
		// TODO Auto-generated method stub
		words = request.split(",");

		record = new Record(words);
		
		pg = record.getPoint_granularity();
		
		switch(pg) {
		case 1:
			EventSource.generateEvent("GoStateTwo", record);
			break;
		case 2:
			EventSource.generateEvent("GoStateThree", record);
			break;
		case 3:
			EventSource.generateEvent("GoStateFive", record);
			break;
		case 4:
			EventSource.generateEvent("GoStateFour", record);
			break;
		case 5:
			EventSource.generateEvent("GoStateTwo", record);
			break;
		case 7:
			EventSource.generateEvent("GoStateThree", record);
			break;
		default:
				break;
		}
	}
	@Override
	public void setContent(String request) {
		// TODO Auto-generated method stub
		this.setRequest(request);
	}
	@Override
	public void setContent(Record record) {
		// TODO Auto-generated method stub
		
	}


}
