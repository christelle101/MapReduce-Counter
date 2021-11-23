import java.io.*;
import java.lang.Thread;
import java.util.*;
import java.util.concurrent.*; /* contient la methode qui permet de
demander la fermeture : toutes les taches en cours d'execution se poursuivent jusqu'a leur 
fin mais on ne peut plus ajouter aucune tache
*/

public class Partitioner extends Thread{
	private HashMap<String, Integer> ultimate;
	private ArrayList<HashMap<String, Integer>> hashM;
	public ArrayList<String> noms;
	public String dossier;
	ArrayList<Map> mappers = new ArrayList<>();
	//ArrayList<Reduce> reducer = new ArrayList<>();
	
	public Partitioner() {
		this.mappers = mappers;
		//this.reducer = reducer;
		this.noms = new ArrayList<String>();
		this.hashM = new ArrayList<HashMap<String, Integer>>();
		this.ultimate = new HashMap<String, Integer>();
	}
	
	public HashMap<String, Integer>getUltimate(){
		return ultimate;
	}
	
	public void addMap (Map map) {
		this.mappers.add(map);
	}
	
	/*public void addReduce(Reduce reduce) {
		this.reducer.add(reduce);
	}*/
	
	public void addHashMap(HashMap<String, Integer> hMap) {
		this.hashM.add(hMap);
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList<Map> getMapper(){
		return mappers;
	}
	
	/*public ArrayList<Reduce> getReducer(){
		return reducers;
	}*/
	
	public void defineMap() {
		for (int n = 0; n<this.mappers.size() + 1; n++) {
			this.mappers.get(n%this.mappers.size()).addText(this.noms.get(n));
		}
	}
	public void startMap() {
		for (Map map : this.mappers) {
			map.start(); //méthode pour demarrer un thread
		}
	}
	
	/*private void resetMapper() {
		
	}*/
	
	
}
