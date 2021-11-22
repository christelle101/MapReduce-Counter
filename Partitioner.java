import java.io.*;
import java.lang.Thread;
import java.util.*;
import java.util.concurrent.*; /* contient la methode qui permet de
demander la fermeture : toutes les taches en cours d'execution se poursuivent jusqu'a leur 
fin mais on ne peut plus ajouter aucune tache
*/

public class Partitioner {
	private HashMap<String, Integer> ultimate;
	private ArrayList<HashMap<String, Integer>> hashM;
	public ArrayList<String> noms;
	public String dossier;
	//ArrayList<Map> maps = new ArrayList<>();
	//ArrayList<Reduce> reduced = new ArrayList<>();
	
	public Partitioner() {
		//this.maps = maps;
		//this.reduced = reduced;
		this.noms = new ArrayList<String>();
		this.hashM = new ArrayList<HashMap<String, Integer>>();
		this.ultimate = new HashMap<String, Integer>();
	}
	
	public HashMap<String, Integer>getUltimate(){
		return ultimate;
	}
	
	/*public void addMap (Map map) {
		this.maps.add(map);
	}*/
	
	/*public void addReduce(Reduce reduce) {
		this.reduced.add(reduce);
	}*/
	
	public void addHashMap(HashMap<String, Integer> hMap) {
		this.hashM.add(hMap);
	}
	
	/*@SuppressWarnings("rawtypes")
	public ArrayList<Map> getMaps(){
		return maps;
	}*/
	
	/*public ArrayList<Reduce> getReduced(){
		return reduced;
	}*/
	
	
}
