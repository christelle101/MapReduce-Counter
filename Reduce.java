package proj731;

import java.util.ArrayList;
import java.util.HashMap;

public class Reduce {
	public ArrayList<HashMap<String, Integer>> split =new ArrayList<HashMap<String, Integer>>();
	//0 correspond a la partie des mots de a-m et 1 de n-z
	public int part_number;

	public /*ArrayList<HashMap<String, Integer>>*/ void reduce() {
		ArrayList<HashMap<String, Integer>> map = new ArrayList<HashMap<String, Integer>>();
		for (int i = 0; i< split.size(); i++) {
			for (String j : split.get(i).keySet()) {
				if (part_number==0 & j.substring(0,1).matches("[a-mA-M]*")) {
					
				}
				
			}
		}
	}

}
