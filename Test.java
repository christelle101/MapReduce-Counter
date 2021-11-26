
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

	public class Test {
		public static void main (String[] arg) throws IOException {
			int nb_map =20;
			Divider list = new Divider("big.txt", nb_map);
			System.out.println(list.split());
			
			/*for (int i=0; i<nb_map; i++) {
				Map test=new Map(list.split().get(i));
				System.out.println(test.map());
			}*/
			Map test0=new Map(list.split().get(0));
			Map test1=new Map(list.split().get(1));
			Map test2=new Map(list.split().get(2));
			Map test3=new Map(list.split().get(3));
			Map test4=new Map(list.split().get(4));
			Map test5=new Map(list.split().get(5));
			Map test6=new Map(list.split().get(6));
			Map test7=new Map(list.split().get(7));
			Map test8=new Map(list.split().get(8));
			Map test9=new Map(list.split().get(9));
			Map test10=new Map(list.split().get(10));
			Map test11=new Map(list.split().get(11));
			Map test12=new Map(list.split().get(12));
			Map test13=new Map(list.split().get(13));
			Map test14=new Map(list.split().get(14));
			Map test15=new Map(list.split().get(15));
			Map test16=new Map(list.split().get(16));
			Map test17=new Map(list.split().get(17));
			Map test18=new Map(list.split().get(18));
			Map test19=new Map(list.split().get(19));
			
			
			PartitionerTest part= new PartitionerTest();
			
			part.addMap(test0);
			part.addMap(test1);
			part.addMap(test2);
			part.addMap(test3);
			part.addMap(test4);
			part.addMap(test5);
			part.addMap(test6);
			part.addMap(test7);
			part.addMap(test8);
			part.addMap(test9);
			part.addMap(test10);
			part.addMap(test11);
			part.addMap(test12);
			part.addMap(test13);
			part.addMap(test14);
			part.addMap(test15);
			part.addMap(test16);
			part.addMap(test17);
			part.addMap(test18);
			part.addMap(test19);
			
			ArrayList<ArrayList<HashMap<String, Integer>>> mapResult =part.launch();
			
			//ArrayList<ArrayList<HashMap<String, Integer>>> split =new ArrayList<ArrayList<HashMap<String, Integer>>>();
			
			System.out.println(mapResult);
			Reduce r =new Reduce(mapResult);
			System.out.println(r.reduce());
			
			
		}

	}

	
