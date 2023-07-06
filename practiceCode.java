/*
Reading a 2D String Array and returning a HashMap that provides the user both the total amount of times a client visited and made a transaction at a store + the total amount of money they spent
*/

import java.util.HashMap;
import java.util.*;

public class practiceCode{
	public static void main(String[]args){

	String[][] everyone = {{"Mary", "event1", "20"}, {"Vi","event34", "30"}, {"Mary", "event2", "40"}, {"Vi", "event24", "40"}, 
	{"Linh", "event12", "12"}, {"Linh", "event90", "90"}, {"Mary", "event34", "90"}, {"Vu", "event11", "90"}, {"Vi", "event99", "90"}, 
	{"Vu", "event78", "90"}};

  	HashMap <String, List<Integer>> timeTable = new HashMap<>(); 

		for(int i = 0; i < everyone.length; i++){ 
			String name = everyone[i][0];
			int timeOfUse = Integer.valueOf(everyone[i][2]);

			if(!timeTable.containsKey(name)){
				List<Integer> times = new ArrayList<>();
				times.add(0);
				times.add(0);
				timeTable.put(name, times);
			}
				List<Integer> times = timeTable.get(name);
				times.set(0, times.get(0) + 1);
				times.set(1, times.get(1) + timeOfUse);
				timeTable.put(name, times);
		}
		System.out.println(timeTable);
	}
}
