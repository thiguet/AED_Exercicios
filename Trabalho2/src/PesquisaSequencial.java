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

	
//  Fa�a  um  programa  que  leia  um  texto  qualquer  (arquivo  no  formato  .txt)  e  imprima,  
//  em  ordem  alfab�tica, as  palavras  e  a  sua  freq��ncia  no  texto.
	
//	1.pseq -  Pesquisa  Sequencial

//	2.pbinaria -  Pesquisa  Bin�ria

//	3.arvore - �rvore  Bin�ria  de  Pesquisa  sem  balanceamento

//	4.haberto - Hash -  endere�amento  aberto - �rea de Reserva
	
//  5.hlista - Hash -  lista  encadeada
}
