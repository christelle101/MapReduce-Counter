
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Thread;

public class Map extends Thread{
	
	private ArrayList<String> split;
	private int etat;
	private ArrayList<String> text;

	public Map(ArrayList<String> s) {
		this.split = s;
		this.etat = 0;
		this.text = new ArrayList<String>();
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
	
	public void addText(String nom) {
		this.text.add(nom);
	}
	
	public void status(String state) {
		if (state == "completed") {
			this.etat = 1;
		}
		else {
			this.etat = 0;
		}
	}
	

}


