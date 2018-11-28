package main;

import search.Search;
import search.TreeSearch;

public class Main {
	public static void main(String args[]) throws Exception {
//		if(args.length != 2) {
//			Config.print("Você precisa informar 2 parâmetros no mínimo !");
//		}
		
		String fileName = "test.txt"; 
		Search searchObj = new TreeSearch(fileName);
		searchObj.run();
		
	}
}
