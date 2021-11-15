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
		  
		  for(int j =0; j < lenght_list/nb_parties; j++){
		    splits.get(i).add(list.get(0));
		    list.remove(0);
		    //System.out.println("split for "+i+ " "+ splits);
		  }
		}
		
		//if the length of list is not divisible by the desired number of parts, we add the remaining elements in our parts
		if (list.size()%nb_parties !=0) {
			for (int i = 0; i < list.size()+1; i++) {
				splits.get(i).add(list.get(0));
				list.remove(0);
				//System.out.println(list);
			}
		}
		return splits;
	}}
			
			
	
