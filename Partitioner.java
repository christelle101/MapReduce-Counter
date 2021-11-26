package proj731;

import java.util.*;

public class Partitioner{
	/*classe qui permet de gerer le lancement des threads*/

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
	
	/*public void defineMap() {
		for (int n = 0; n<this.mappers.size() + 1; n++) {
			this.mappers.get(n%this.mappers.size()).addSplit(this.noms.get(n));
		}
	}*/
	
	public void startMap() {
		for (Map map : this.mappers) {
			map.start(); //methode pour demarrer un thread
		}
	}
	
	private void resetMapper() {
		for (Map map : this.mappers) {
			map.status("reinitialisé");
			map.resetSplit();
			//map.resetMap();
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
	
	public ArrayList<ArrayList<HashMap<String, Integer>>> launch() throws InterruptedException {
		//liste resultat
		ArrayList<ArrayList<HashMap<String, Integer>>> mapResults =new ArrayList<ArrayList<HashMap<String, Integer>>>();
		
		//lancement des threads
		this.startMap();
		System.out.println("maps start running");
		
		//on attend la fin des threads
		for (Map map : this.mappers) {
			map.join(); 
		}
		System.out.println("maps finish");
		
		//on ajoute les resultats des differents map dans la liste des resultats
		for (Map map : this.mappers) {
			mapResults.add(map.getResult()); 
		}
		resetMapper();
		return mapResults;
	}
	
}
