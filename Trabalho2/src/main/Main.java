package main;

import factory.ISearchFactory;
import factory.SearchFactory;
import search.Search;
import util.Config;

public class Main {
	private static final String HELP_MESSAGE =  "Usage: <desired structure> <filename>" + 
												" - 	";
	
	public static void main(String args[]) throws Exception {		
		if(args.length != 2) {
			Config.print(HELP_MESSAGE);
		} else {
			ISearchFactory searchFactory = new SearchFactory();
			
			String fileName = "test.txt"; 
			String id = SearchFactory.LINKED_LIST_SEARCH_ID; //.TREE_SEARCH_ID;
			
			Search searchObj = searchFactory.getSearch(id, fileName);
			searchObj.run();	
		}
	}
}
