package Model;

public class ListaFlexivel {
	private Nodo primeiro;
	private Nodo ultimo;
	private int tamanho;
	
	public ListaFlexivel () {
		this.primeiro = new Nodo();
		this.ultimo = this.primeiro;
		this.primeiro.setProx(ultimo);
	}
	
	public ListaFlexivel(Serie novaSerie) {
		this.primeiro = new Nodo();
		this.ultimo = new Nodo(novaSerie);
		this.primeiro.setProx(this.ultimo);
		this.tamanho++;
	}
	
	public void add(Serie novaSerie) {
		Nodo aux = new Nodo(novaSerie);
		this.ultimo.setProx(aux);
		this.ultimo = aux;
		this.tamanho++;
	}

	public Serie rm() throws Exception {
		if(listaEstaVazia())
			throw new Exception("A lista está vazia !");
		
		Nodo aux = this.ultimo; 
		
		while(aux.getProx() != null) {
			aux = aux.getProx();
		}
		
		return aux.getSerie();
	}
	
	public Serie rm(int pos) throws Exception {
		if(listaEstaVazia())
			throw new Exception("A lista está vazia !");
		
		if(!posicaoExiste(pos))
			throw new Exception("Esta posição não existe !");
		
		Nodo aux = this.ultimo; 
		
		while(pos > 0) {
			aux = aux.getProx();
			pos--;
		}
		
		return aux.getSerie();
	}

	public Serie rm(Serie toRemove) throws Exception {
		if(listaEstaVazia())
			throw new Exception("A lista está vazia !");
		
		Nodo aux = this.primeiro; 
		
		while(aux.getProx() != null && !aux.equals(toRemove)) {
			aux = aux.getProx();
		}
		
		return aux.getSerie();
	}

	private boolean listaEstaVazia() {
		return this.ultimo.getProx() == null;
	}
	
	@Override
	public String toString() {
		String str = "";
		Nodo aux = this.ultimo;
		while(aux != null) {
			str += aux.toString();
		}
		return str;
	}
	
	public Object[][] getDataInRowFormat() {
		Object[][] data = new Object[this.tamanho][6];
		
		Nodo aux = primeiro.getProx();
		Object[] helper;
		int i = 0;
		while(aux != null) {
			helper = aux.getSerie().toObject();
			data[i]= helper;
			aux = aux.getProx();
			i++;
		}
		
		return data;
	}

	public int getTamanho() {
		return tamanho;
	}

	public Serie getSerie(int posicao) throws Exception {
		Serie serie;
		Nodo aux;
		
		if(posicaoExiste(posicao)) {
			aux = primeiro;
			for(int i = posicao; i > 0; i--) {
				aux = aux.getProx();
			}
			serie = aux.getSerie();
		} else {
			throw new Exception("A posição informada não existe !");
		}
		
		return serie;
	}

	private boolean posicaoExiste(int posicao) {
		return posicao >= 0 && posicao < tamanho;
	}
}
