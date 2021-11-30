import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Thread;

public class Reduce extends Thread {
	/*
	 * Takes into argument a list of lists of hashmaps, with each hashmap
	 * representing a word from the text,
	 * and counts the number of occurrences of that word, then stocks it into a list
	 * of hashmaps.
	 */

	public ArrayList<ArrayList<HashMap<String, Integer>>> list = new ArrayList<ArrayList<HashMap<String, Integer>>>();
	/*
	 * //0 correspond a la partie des mots de a-m et 1 de n-z
	 * public int part_number;
	 */

	private ArrayList<HashMap<String, Integer>> hMaps;
	public HashMap<String, Integer> reducer;
	private int status;

	public Reduce(ArrayList<ArrayList<HashMap<String, Integer>>> split) {
		super();
		this.list = split;
	}

	public ArrayList<HashMap<String, Integer>> reduce() {
		// list of hashmap<word, occurency>
		ArrayList<HashMap<String, Integer>> map = new ArrayList<HashMap<String, Integer>>();
		// list that stocks the keys in a string format
		ArrayList<String> words = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {

			if (i % 100 == 0) {
				System.out.println("boucle 1: i= " + i);
			}

			for (int j = 0; j < list.get(i).size(); j++) {

				if (j % list.get(i).size() == 0) {
					System.out.println("list.get(i).size() div j: " + j / list.get(i).size());

				}

				/*
				 * if the word has not already been met, it is added into words and its
				 * hashmap is added into map
				 */
				if (!words.contains(list.get(i).get(j).keySet().toString())) {
					words.add(list.get(i).get(j).keySet().toString());
					map.add(list.get(i).get(j));

					// System.out.println("map "+map);
					// System.out.println(words.contains(split.get(i).get(j).keySet()));
				}

				/*
				 * if the word has already been met, it is searched in the hashmaps of maps
				 * and then the occurence counter is incremented.
				 */
				else {
					for (int l = 0; l <= map.size() - 1; l++) {

						if (l % 100 == 0) {
							System.out.println("boucle 3: l= " + l);
						}

						String keySplit = (String) list.get(i).get(j).keySet().toArray()[0];
						String keyMap = (String) map.get(l).keySet().toArray()[0];

						// System.out.println("l "+l +" "+ map.get(l));

						if (keySplit.equals(keyMap)) {
							// System.out.println(map.get(l).keySet().toArray()[0]);
							map.get(l).put(keyMap.toString(), map.get(l).get(keyMap) + 1);
							// System.out.println(map);
						}
					}
				}
			}
		}
		return (map);
	}

	public void addHashMap(HashMap<String, Integer> hashMap) {
		// adds hashmap
		// TODO Auto-generated method stub
		this.hMaps.add(hashMap);
	}

	public void resetHashMaps() {
		// resets hashmap
		this.hMaps = new ArrayList<HashMap<String, Integer>>();
	}

	public void resetReducer() {
		// resets reducer
		this.reducer = new HashMap<String, Integer>();
	}

	public void etat(String state) {
		// gets the status
		if (state == "completed") {
			this.status = 1;
		} else {
			this.status = 0;
		}
	}
}
