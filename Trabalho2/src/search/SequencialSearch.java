package search;
import java.util.ArrayList;
import java.util.List;

import model.Word;
import sort.ISort;
import sort.InsertionSort;
import util.Config;

public class SequencialSearch extends AbstractSearch {
	private Word[] memory;

	SequencialSearch (String fileName) {
		super(fileName);
		this.memory = new Word [Config.TAM_MAX_PALAVRAS];
	}

	@Override
	public boolean exists (String word) {
		for(int i = 0; i < memory.length ; i++) {
			if(memory[i].getWord().equals(word))
				return true;
		}
		
		return false;
	}

	@Override
	public void add (List<String> content) {
		Word word;
		
		for(int i = 0 ; i < content.size() && i < memory.length ; i++) {
			word = new Word (content.get(i));
			this.nrKeysCompared++;
			
			if(exists(memory[i].getWord())) {
				for(Word aux : memory) {
					this.nrKeysCompared++;
					if(aux.getWord().equals(word.getWord())) 
						aux.plusFrequency();
				}				
			} else {
				memory[i] = word;
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
			words.add(word);
		}
		
		order.sort(words);
	}
	
	private void print () {
		for(int i = 0 ; i < this.memory.length ; i++) {
			Config.print(this.memory[i].getWord());
		}
	}
	
//  Faça  um  programa  que  leia  um  texto  qualquer  (arquivo  no  formato  .txt)  e  imprima,  
//  em  ordem  alfabética, as  palavras  e  a  sua  freqüência  no  texto.
	
//	1.pseq -  Pesquisa  Sequencial

//	2.pbinaria -  Pesquisa  Binária

//	3.arvore - Árvore  Binária  de  Pesquisa  sem  balanceamento

//	4.haberto - Hash -  endereçamento  aberto - Área de Reserva
	
//  5.hlista - Hash -  lista  encadeada

}
