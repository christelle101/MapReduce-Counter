
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Thread;

public class Map extends Thread{
	
	private ArrayList<String> split;
	private int etat;
	private HashMap<String, Integer> map;

	public int getEtat() {
		return etat;
	}


	public Map(ArrayList<String> s) {
		//ArrayList<String> s = null;
		this.split = s;
		this.etat = 0;
		//this.s = new ArrayList<String>();
	}
	
	public ArrayList<HashMap<String, Integer>> map(){
		//method which reads the file and returns a HashMap<word,key>
		ArrayList<HashMap<String, Integer>> element=new ArrayList<HashMap<String, Integer>>();
		for(int i = 0; i < split.size(); i++){
			//list of word
			String[] words = split.get(i).split(" ");
			for (int j = 0; j < words.length; j++) {
				HashMap<String, Integer> word=new HashMap<String, Integer>();
				word.put(words[j],1);
				element.add(word);
			}
		}
		return element;
	}
	
	public void addSplit(String nom) {
		this.split.add(nom);
	}
	
	public void status(String state) {
		if (state == "completed") {
			this.etat = 1;
		}
		else {
			this.etat = 0;
		}
	}
	
	public void resetMap(){
		this.map = new HashMap<String, Integer>();
	}
	
	public void resetSplit(){
		this.split = new ArrayList<String>();
	}

	

}




