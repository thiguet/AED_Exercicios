// Você  foi  contratado  para  desenvolver  uma  agenda  de  contatos  
// (atributos  nome,  telefone,  email  e  CPF)  para um  escritório  de  advocacia.  

// Um  colega  sugeriu  que  você  implementasse  uma  árvore  de  binária  de  
// listas  em  que a  pesquisa  na  árvore  acontece  pela  primeira  letra  do  nome  
// e,  quando  encontramos  a  letra,  temos  uma  pesquisa em  uma  lista  de  contatos.

// Crie  uma  classe  Agenda  contendo  o  atributo  No  raiz,  os  
// métodos inserir(Contato contato), remover(String nome), pesquisar(String nome) e pesquisar(int cpf).

// Crie  uma  classe  No contendo os  atributos  Celula primeiro e ultimo, 
// No  esq  e  dir,  e  char  letra.

// Crie  uma  classe  Celula  contendo  os  atributos  Contato  contato  e  Celula  prox.

// Crie  uma  classe  Contato  contendo  os  atributos  String  nome,  telefone  e  email  e  int  CPF.

public class Agenda {

	private Nodo raiz;

	public Agenda() {

	}

	public void inserir(Contato pessoa) throws Exception {
		this.raiz = inserir(pessoa, raiz);
	}

	public Nodo inserir (Contato pessoa, Nodo novoNo) throws Exception {
		if(pessoa == null) {
			novoNo = new Con(nome);
		} else if( novoNo.getEsq().equals() ) {
			
		} else if() {
			
		} else {
			throw new Exception("Deu Ruim");
		}
		
		return novoNo;
	}

	public Contato remover(String nome) {
		return null;

	}

	public Contato pesquisar(String nome) {
		return null;

	}

	public Contato pesquisar(int cpf) {
		return null;

	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

}
