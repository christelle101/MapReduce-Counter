package proj731;

import java.util.ArrayList;
import java.util.HashMap;

public class Reduce {
	public ArrayList<ArrayList<HashMap<String, Integer>>> split =new ArrayList<ArrayList<HashMap<String, Integer>>>();
	/*//0 correspond a la partie des mots de a-m et 1 de n-z
	public int part_number;*/

	public /*ArrayList<HashMap<String, Integer>>*/ void reduce() {
		ArrayList<HashMap<String, Integer>> map = new ArrayList<HashMap<String, Integer>>();
		for (int i = 0; i< split.size(); i++) {
			for (int  j= 0; j< split.get(i).size(); i++) {
				for (String k : split.get(i).get(j).keySet()) {
					/*if (part_number==0 & k.substring(0,1).matches("[a-mA-M]*")) {
					
					}*/
					for (int l = 0; l<map.size(); l++) {
						if (k.equals(map.get(l).keySet())) {
							//map.get(l).;
								} 
				
						
					}
				}
			}
		}
	}
}
