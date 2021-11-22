package proj731;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {
	
	private ArrayList<String> split;
	

	public Map(ArrayList<String> s) {
		this.split = s;
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
	
	/*public ArrayList<HashMap<String, Integer>> map(){
		//method which reads the file and returns a HashMap<word,key>
		ArrayList<HashMap<String, Integer>> element=new ArrayList<HashMap<String, Integer>>();
		try {
			File file=new File(fName);
			// Creating the File Reader object
			FileReader fr=new FileReader(file);
			// Creating the BufferedReader object 
			BufferedReader br = new BufferedReader(fr); 
			String line= null;
			//the loop will read line by line
			while((line = br.readLine())!= null){
				//list of word
				String[] words = line.split(" ");
				for (int i = 0; i < words.length; i++) {
					HashMap<String, Integer> word=new HashMap<String, Integer>();
					word.put(words[i],1);
					element.add(word);
				}
			}
			fr.close();  
		}
		catch(IOException e){
			System.out.println("An error occurred.");
		    e.printStackTrace();
	    }
		return element;
	}*/
	}


