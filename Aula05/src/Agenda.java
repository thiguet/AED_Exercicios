
public class Agenda {
	
	No raiz;
	
	public Agenda () {
		
	}
	
	@SuppressWarnings("unused")
	private void initializeAlfabeto() {
		
	}

	public void inserir(String nome) {
		raiz = inserir(nome, raiz);
	}
	
	public No inserir(String nome, No no) {
		if(nome.charAt(0) == no.letra ) {
			no.lista.add(nome);
		} else if(nome.charAt(0) > no.letra ) {
			no.esq.lista.add(nome);
		} else if(nome.charAt(0) < no.letra ) {
			no.dir.lista.add(nome);
		}
		
		return no;
	}
	
}
