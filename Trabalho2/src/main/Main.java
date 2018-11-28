package main;

import factory.ISearchFactory;
import factory.SearchFactory;
import search.Search;

public class Main {
	private static final String HELP_MESSAGE = "Usage: Trampo2 <filename> <desired structure>";
	
	public static void main(String args[]) throws Exception {
//		if(args.length != 2) {
//			Config.print(HELP_MESSAGE);
//			Config.print("Voc� precisa informar 2 par�metros no m�nimo !");
//		}
		ISearchFactory searchFactory = new SearchFactory();
		
		String fileName = "test.txt"; 
		String id = SearchFactory.SEQUENTIAL_SEARCH_ID;//.TREE_SEARCH_ID;
		
		Search searchObj = searchFactory.getSearch(id, fileName);
		searchObj.run();
	}
}
