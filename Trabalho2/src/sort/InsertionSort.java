package sort;

import java.util.List;

public class InsertionSort<E extends Comparable<E>> implements ISort<E> {

	public InsertionSort() {}
		
	@Override
	public void sort(List<E> list) {
		int n = list.size(); 
        
		for (int i = 1; i < n; ++i) {
            E key = list.get(i); 
            int j = i - 1; 
  
            while (j >= 0 && list.get(j).compareTo(key) > 0) { 
                list.set(j + 1, list.get(j)); 
                j = j - 1; 
            } 
            
            list.set(j + 1, key); 
        }
	}
}
