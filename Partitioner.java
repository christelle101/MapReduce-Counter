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
	ArrayList<Reduce> reducers = new ArrayList<>();
	
	public Partitioner() {
		this.mappers = mappers;
		this.reducers = reducers;
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
	
	private void defineMap() {
		for (int n = 0; n<this.mappers.size() + 1; n++) {
			this.mappers.get(n%this.mappers.size()).addSplit(this.noms.get(n));
		}
	}
	public void startMap() {
		for (Map map : this.mappers) {
			map.start(); //méthode pour demarrer un thread
		}
	}
	
	private void resetMapper() {
		for (Map map : this.mappers) {
			map.status("reinitialisé");
			map.resetSplit();
			map.resetMap();
		}
	}
	
	private void defineReduce() {
		for(int i=0;i<this.hashM.size();i++){
            this.reducers.get(i%this.reducers.size()).addHashMap(this.hashM.get(i));
        }
	}
	
	private void startReducer(){
        for(Reduce reducer : this.reducers){
        	reducer.start();
        }
	}
	
	private void resetReducers(){
        for(Reduce reducer : this.reducers){
            reducer.etat("reinitialisé");
            reducer.resetHashMaps();
            reducer.resetReducer();
        }
    }
	
	public ArrayList<ArrayList<HashMap<String, Integer>>> launch() {
		ArrayList<ArrayList<HashMap<String, Integer>>> mapResult =new ArrayList<ArrayList<HashMap<String, Integer>>>();
		this.startMap();
		System.out.println("maps start running");
		for (Map map : this.mappers) {
			mapResult.add(map.map()); 
		}
		resetMapper();
		return mapResult;
	}

	
}
