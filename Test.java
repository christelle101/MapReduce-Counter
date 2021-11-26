package proj731;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

	public class Test {
		public static void main (String[] arg) throws IOException, InterruptedException {
			//nombre de thread 
			int nb_map =5;
			
			//division du texte a compter en nombre de thread part
			Divider list = new Divider("big.txt", nb_map);
			System.out.println("voici le texte divisé en "+nb_map+" parties");
			System.out.println(list.split());
			
			Partitioner part= new Partitioner();
			
			//creation des thread et stockage dans mappers du partitioner
			for (int i=0; i<nb_map; i++) {
				Map test=new Map(list.split().get(i));
				part.addMap(test);
			}
			
			//lancement des threads
			ArrayList<ArrayList<HashMap<String, Integer>>> mapResult =part.launch();
			//System.out.println("voici le resultat des maps: ");
			//System.out.println(mapResult);
			
			//lancement du reduce
			Reduce r =new Reduce(mapResult);
			System.out.println(r.reduce());
			
		}

	}

	

