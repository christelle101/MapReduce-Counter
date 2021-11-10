package proj731;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Map {
	
	private String fName;
	

	public Map(String name) {
		this.fName = name;
	}
	
	public ArrayList<HashMap<String, Integer>> map(){
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
	}
	}


