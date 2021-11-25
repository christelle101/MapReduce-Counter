
import java.util.ArrayList;
import java.util.HashMap;

public class Reduce {
	public ArrayList<ArrayList<HashMap<String, Integer>>> list =new ArrayList<ArrayList<HashMap<String, Integer>>>();
	/*//0 correspond a la partie des mots de a-m et 1 de n-z
	public int part_number;*/
	
	public Reduce(ArrayList<ArrayList<HashMap<String, Integer>>> split) {
		super();
		this.list = split;
	}

	public ArrayList<HashMap<String, Integer>> reduce() {
		//list of hashmap<word, occurency>
		ArrayList<HashMap<String, Integer>> map = new ArrayList<HashMap<String, Integer>>();
		//liste stockant les cles sous format string
		ArrayList<String> words = new ArrayList<String>();
		
		for (int i = 0; i< list.size(); i++) {
			for (int  j= 0; j< list.get(i).size(); j++) {
					//si le mot cle n'a pas deja ete rencontre on le rajoute dans words er son hashmap dans map
					if (!words.contains(list.get(i).get(j).keySet().toString())){
						words.add(list.get(i).get(j).keySet().toString());
						map.add(list.get(i).get(j));
						//System.out.println("map "+map);
						//System.out.println(words.contains(split.get(i).get(j).keySet()));
					}
					
					//si on a deja rencontre ce mot on cherche dans quel hashmap de map c'est 
					//et on on incremente le compteur d'occurneve
					else {
						for (int l = 0; l<=map.size()-1; l++) {
							String keySplit=(String) list.get(i).get(j).keySet().toArray()[0];
							String keyMap=(String) map.get(l).keySet().toArray()[0];
							
							//System.out.println("l "+l +" "+ map.get(l));
							
							if (keySplit.equals(keyMap)) {
								//System.out.println(map.get(l).keySet().toArray()[0]);
								map.get(l).put(keyMap.toString(), map.get(l).get(keyMap) + 1); 
								//System.out.println(map);
								} 
						}
					
						
				
						
					}
				}
			}
		return(map);
		}
	}

	
