import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Thread;

public class Map extends Thread {
	/*
	 * extends the Java Thread class.
	 * The run method reads the words from the list of lines which is taken into
	 * argument, and stocks them into a list of hashmaps.
	 */

	private ArrayList<String> split;
	private int etat;
	private ArrayList<HashMap<String, Integer>> result = new ArrayList<HashMap<String, Integer>>();
	// private HashMap<String, Integer> map;

	public int getEtat() {
		// returns the state of the map
		return etat;
	}

	public ArrayList<HashMap<String, Integer>> getResult() {
		return result;
	}

	public Map(ArrayList<String> s) {
		// ArrayList<String> s = null;
		this.split = s;
		this.etat = 0;
		// this.s = new ArrayList<String>();
	}

	public void run() {

		// System.out.println("m start");

		for (int i = 0; i < split.size(); i++) {

			// list of word
			String[] words = split.get(i).split(" ");

			for (int j = 0; j < words.length; j++) {
				HashMap<String, Integer> word = new HashMap<String, Integer>();
				word.put(words[j], 1);
				this.result.add(word);
			}
		}
		// System.out.println("m finish");
	}

	public void addSplit(String nom) {
		// adds split to map
		this.split.add(nom);
	}

	public void status(String state) {
		// gets the status of the mapping action
		if (state == "completed") {
			this.etat = 1;
		} else {
			this.etat = 0;
		}
	}

	public void resetSplit() {
		this.split = new ArrayList<String>();
	}

}

/*
 * 
 * import java.util.ArrayList;
 * import java.util.HashMap;
 * 
 * public class Map {
 * 
 * private ArrayList<String> split;
 * 
 * 
 * public Map(ArrayList<String> s) {
 * this.split = s;
 * }
 * 
 * public ArrayList<HashMap<String, Integer>> map(){
 * //method which reads the file and returns a HashMap<word,key>
 * ArrayList<HashMap<String, Integer>> element=new ArrayList<HashMap<String,
 * Integer>>();
 * for(int i = 0; i < split.size(); i++){
 * //list of word
 * String[] words = split.get(i).split(" ");
 * for (int j = 0; j < words.length; j++) {
 * HashMap<String, Integer> word=new HashMap<String, Integer>();
 * word.put(words[j],1);
 * element.add(word);
 * }
 * }
 * return element;
 * }
 */

/*
 * public ArrayList<HashMap<String, Integer>> map(){
 * //method which reads the file and returns a HashMap<word,key>
 * ArrayList<HashMap<String, Integer>> element=new ArrayList<HashMap<String,
 * Integer>>();
 * try {
 * File file=new File(fName);
 * // Creating the File Reader object
 * FileReader fr=new FileReader(file);
 * // Creating the BufferedReader object
 * BufferedReader br = new BufferedReader(fr);
 * String line= null;
 * //the loop will read line by line
 * while((line = br.readLine())!= null){
 * //list of word
 * String[] words = line.split(" ");
 * for (int i = 0; i < words.length; i++) {
 * HashMap<String, Integer> word=new HashMap<String, Integer>();
 * word.put(words[i],1);
 * element.add(word);
 * }
 * }
 * fr.close();
 * }
 * catch(IOException e){
 * System.out.println("An error occurred.");
 * e.printStackTrace();
 * }
 * return element;
 * }
 * }
 */
