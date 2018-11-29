package search;
import java.util.ArrayList;
import java.util.List;

import model.Word;
import sort.ISort;
import sort.InsertionSort;
import util.Config;

public class SequencialSearch extends AbstractSearch {
	private Word[] memory;

	public SequencialSearch (String fileName) {
		super(fileName);
		this.memory = new Word [Config.TAM_MAX_PALAVRAS];
	}

	@Override
	public boolean exists (String word) {
		for(int i = 0; i < memory.length ; i++) {
			if(memory[i] != null && memory[i].getWord().equals(word))
				return true;
		}
		
		return false;
	}

	@Override
	public void add(List<String> content) {
		Word word;
		
		for(int i = 0 ; i < content.size() && i < memory.length ; i++) {
			this.nrAttrNeeded++;
			String str = content.get(i);
			
			this.nrKeysCompared++;
			if(exists(str)) {
				for(Word aux : memory) {
					this.nrKeysCompared++;
					if(aux != null && aux.getWord().equals(str)) 
						aux.plusFrequency();
				}				
			} else {
				word = new Word (str);
				this.nrAttrNeeded++;
				
				memory[i] = word;
				this.nrAttrNeeded++;
			}	
		}
	}

	@Override
	public void printAlphabetical () {
		this.sortAlphabetical();
		this.print();
	}
	
	private void sortAlphabetical () {	
		List<Word> words = new ArrayList<Word> ();
		ISort<Word> order = new InsertionSort<Word>();
		
		for(Word word : this.memory) {
			if(word != null)
				words.add(word);
		}
		
		order.sort(words);
		
		int i = 0;
		for(Word word : words) {
			memory[i] = word;
			i++;
		}
	}
	
	private void print () {
		for(int i = 0 ; i < this.memory.length && this.memory[i] != null ; i++) {
			Config.print(this.memory[i].toString());
		}
	}
	
//  Fa�a  um  programa  que  leia  um  texto  qualquer  (arquivo  no  formato  .txt)  e  imprima,  
//  em  ordem  alfab�tica, as  palavras  e  a  sua  freq��ncia  no  texto.
	
//	1.pseq -  Pesquisa  Sequencial

//	2.pbinaria -  Pesquisa  Bin�ria

//	3.arvore - �rvore  Bin�ria  de  Pesquisa  sem  balanceamento

//	4.haberto - Hash -  endere�amento  aberto - �rea de Reserva
	
//  5.hlista - Hash -  lista  encadeada

}
