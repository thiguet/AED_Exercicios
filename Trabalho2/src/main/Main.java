package main;

import search.Search;
import search.TreeSearch;

public class Main {
	public static void main(String args[]) throws Exception {
//		if(args.length != 2) {
//			Config.print("Voc� precisa informar 2 par�metros no m�nimo !");
//		}
		
		String fileName = "test.txt"; 
		Search searchObj = new TreeSearch(fileName);
		searchObj.run();
		
	}
}
