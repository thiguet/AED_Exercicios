package search;
import java.util.List;

import model.Tree;

public class TreeSearch extends AbstractSearch {
	public Tree tree;
	
	public TreeSearch(String fileName) {
		super(fileName);
		tree = new Tree();
	}
	
	@Override
	public boolean exists(String str) {
		boolean exist = tree.find(str);
		this.nrKeysCompared = tree.getNrComparations();
		return exist;
	}

	@Override
	public void add(List<String> listStr) {
		listStr.stream()
				.forEach(str -> {
					tree.add(str);
				});
		
		this.nrKeysCompared = tree.getNrComparations();
		this.nrAttrNeeded = tree.getNrAttribs();
	}
	
	@Override
	public void printAlphabetical() {
		tree.print();
	}
}
