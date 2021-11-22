package proj731;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {
	
	private ArrayList<String> split;
	

	public Map(ArrayList<String> s) {
		this.split = s;
	}
	
	public HashMap<String, Integer> map(){
		//method which reads the file and returns a HashMap<word,key>
		HashMap<String, Integer> element=new HashMap<String, Integer>();
		for(int i = 0; i < split.size(); i++){
			//list of word
			String[] words = split.get(i).split(" ");
			for (int j = 0; j < words.length; j++) {
				element.put(words[j],1);
			}
		}
		return element;
	}
	

	}
