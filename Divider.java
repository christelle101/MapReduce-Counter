package proj731;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Divider {
	private String fName;
	private int nb_parties;
	

	public Divider(String name, int nb) {
		this.fName = name;
		this.nb_parties = nb;
	}
	
	public ArrayList<ArrayList<String>> split() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(fName)));
		ArrayList<String> list = new ArrayList<String>();
		String line;
		int lenght_list = 0;
		//for each line of your file
		while((line = br.readLine()) != null){
		    list.add(line);
		    lenght_list+=1;
		}
		br.close();

		//then you can split your list into differents parts
		ArrayList<ArrayList<String>> splits  = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < nb_parties; i++){
		  splits.add(new ArrayList<String>());
		  
		  for(int j =0; j < nb_parties; j++){
		    splits.get(i).add(list.get(j*lenght_list/nb_parties));
		    list.remove(j*lenght_list/nb_parties);
		    System.out.println(splits);
		  }
		}
		return splits;
	}
}
	
