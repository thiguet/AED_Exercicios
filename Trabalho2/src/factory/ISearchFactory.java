package factory;

import search.Search;

public interface ISearchFactory {
	public Search getSearch(String id, String fileName) throws Exception;
}
