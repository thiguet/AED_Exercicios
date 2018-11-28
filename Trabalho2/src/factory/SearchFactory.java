package factory;

import search.Search;
import search.SequencialSearch;
import search.BinarySearch;
import search.HashSearch;
import search.LinkedListSearch;
import search.TreeSearch;

public class SearchFactory implements ISearchFactory {
	public static final String TREE_SEARCH_ID = "arvore";
	public static final String HASH_SEARCH_ID = "haberto";
	public static final String LINKED_LIST_SEARCH_ID = "hlista";
	public static final String SEQUENTIAL_SEARCH_ID = "pseq";
	public static final String BINARY_SEARCH_ID = "pbinaria";
	
	@Override
	public Search getSearch(String id, String fileName) throws Exception {
		if(id.equals(TREE_SEARCH_ID)) {
			return new TreeSearch(fileName);
		} else if(id.equals(HASH_SEARCH_ID)) {
			return new HashSearch(fileName);
		} else if(id.equals(LINKED_LIST_SEARCH_ID)) {
			return new LinkedListSearch(fileName);
		} else if(id.equals(SEQUENTIAL_SEARCH_ID)) {
			return new SequencialSearch(fileName);
		} else if(id.equals(BINARY_SEARCH_ID)) {
			return new BinarySearch(fileName);
		} else {
			throw new Exception("Type of search not supported yet !");
		}
	}	
}
