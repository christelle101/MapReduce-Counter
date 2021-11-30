import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Test {
	public static void main(String[] arg) throws IOException, InterruptedException {
		// number of threads to run
		int nb_map = 5;

		// text is divided into the number of threads
		Divider list = new Divider("big.txt", nb_map);
		System.out.println("voici le texte divise en " + nb_map + " parties");
		System.out.println(list.split());

		Partitioner part = new Partitioner();

		// creation des thread et stockage dans mappers du partitioner
		// creation of threads and then stocking into mappers
		for (int i = 0; i < nb_map; i++) {
			Map test = new Map(list.split().get(i));
			part.addMap(test);
		}

		// threads launching
		ArrayList<ArrayList<HashMap<String, Integer>>> mapResult = part.launch();
		// System.out.println("voici le resultat des maps: ");
		// System.out.println(mapResult);

		// reducing launching
		Reduce r = new Reduce(mapResult);
		System.out.println(r.reduce());

	}

}
