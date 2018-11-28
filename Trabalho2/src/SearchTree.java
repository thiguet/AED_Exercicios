import java.util.List;

import model.Tree;

public class SearchTree extends AbstractSearch {
	public Tree tree;
	
	SearchTree(String fileName) {
		super(fileName);
	}
	
	@Override
	public boolean exists(String str) {
		boolean exist = tree.find(str);
		
		this.nrKeysCompared = tree.getNrComparations();		
		
		return exist;
	}

	@Override
	public void add(List<String> listStr) {
		listStr.stream().forEach(str -> tree.add(str));
	}
	
	@Override
	public void alphabeticalPrint() {
//		List<Word> words = tree.getTreeContent();
//		
//		words.stream()
//			 .forEach(word -> Config.print(word.getWord()));
		tree.print();
	}
}
