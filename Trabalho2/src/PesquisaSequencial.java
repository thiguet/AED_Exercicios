import java.util.List;

import model.Word;
import util.Config;

public class PesquisaSequencial extends AbstractSearch {
	private Word[] memoria;
	
	PesquisaSequencial(String fileName) {
		super(fileName);
		this.memoria = new Word [Config.TAM_MAX_PALAVRAS];
	}

	@Override
	public boolean exists(String word) {
		for(int i = 0 ;  i < memoria.length; i++ ) {
			if(memoria[i].equals(word)) {
				
			}
		}
		
		return false;
	}

	@Override
	public void add(List<String> content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alphabeticalPrint() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
//  Faça  um  programa  que  leia  um  texto  qualquer  (arquivo  no  formato  .txt)  e  imprima,  
//  em  ordem  alfabética, as  palavras  e  a  sua  freqüência  no  texto.
	
//	1.pseq -  Pesquisa  Sequencial

//	2.pbinaria -  Pesquisa  Binária

//	3.arvore - Árvore  Binária  de  Pesquisa  sem  balanceamento

//	4.haberto - Hash -  endereçamento  aberto - Área de Reserva
	
//  5.hlista - Hash -  lista  encadeada
}
