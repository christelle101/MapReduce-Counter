import java.util.*;

public class Partitioner {
	// manages the multithreading

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

	public HashMap<String, Integer> getUltimate() {
		return ultimate;
	}

	public void addMap(Map map) {
		// adds map to mappers
		this.mappers.add(map);
	}

	public void addHashMap(HashMap<String, Integer> hMap) {
		// adds a hash map
		this.hashM.add(hMap);
	}

	@SuppressWarnings("rawtypes")
	public ArrayList<Map> getMapper() {
		return mappers;
	}

	public void startMap() {
		for (Map map : this.mappers) {
			map.start(); // methode pour demarrer un thread
		}
	}

	private void resetMapper() {
		for (Map map : this.mappers) {
			map.status("reinitialis�");
			map.resetSplit();
			// map.resetMap();
		}
	}

	private void defineReduce() {
		for (int i = 0; i < this.hashM.size(); i++) {
			this.reducers.get(i % this.reducers.size()).addHashMap(this.hashM.get(i));
		}
	}

	private void startReducer() {
		// starts the reducers
		for (Reduce reducer : this.reducers) {
			reducer.start();
		}
	}

	private void resetReducers() {
		// resets the reducers
		for (Reduce reducer : this.reducers) {
			reducer.etat("reinitialis�");
			reducer.resetHashMaps();
			reducer.resetReducer();
		}
	}

	public ArrayList<ArrayList<HashMap<String, Integer>>> launch() throws InterruptedException {
		// result list
		ArrayList<ArrayList<HashMap<String, Integer>>> mapResults = new ArrayList<ArrayList<HashMap<String, Integer>>>();

		// threads are launched
		this.startMap();
		System.out.println("maps start running");

		// waiting for threads to finish
		for (Map map : this.mappers) {
			map.join();
		}
		System.out.println("maps finish");

		// the results from the mappers are added into the main list of results
		for (Map map : this.mappers) {
			mapResults.add(map.getResult());
		}
		resetMapper();
		return mapResults;
	}

}
