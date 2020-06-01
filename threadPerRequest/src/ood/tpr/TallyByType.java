package ood.tpr;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class TallyByType {
	private Map<String,Integer> tally = new HashMap<>();
	
	public TallyByType() {
		tally.put("Residential,Masonry", 0);
		tally.put("Residential,Wood", 0);
		tally.put("Commercial", 0);
		tally.put("Commercial,Reinforced Concrete", 0);
		tally.put("Commercial,Reinforced Masonry", 0);
		tally.put("Commercial,Steel Frame", 0);
	}
	
	public Map<String,Integer> getTally(){
		return this.tally;
	}
}
