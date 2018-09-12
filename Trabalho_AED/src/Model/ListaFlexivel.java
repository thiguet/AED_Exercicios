package Model;

import javax.swing.JOptionPane;

public class ListaFlexivel {
	private Nodo primeiro;
	private Nodo ultimo;
	private int tamanho;
	
	public ListaFlexivel () {
		this.ultimo = this.primeiro = null;
		this.tamanho = 0;
	}
	
	public ListaFlexivel(Serie novaSerie) {
		this.primeiro = this.ultimo = new Nodo(novaSerie);
		this.tamanho++;
	}
	
	public void addFim(Serie novaSerie) {
		Nodo aux = new Nodo(novaSerie);
		
		novaSerie.setId(this.tamanho - 1);
		
		if(listaVazia()) {
			this.primeiro = this.ultimo = aux;
			
			this.tamanho++;
		} else {
			aux.setAnterior(this.ultimo);
			this.ultimo.setProximo(aux);
			
			this.ultimo = aux;
			
			this.tamanho++;
		}
	}

	public void addIni(Serie novaSerie) {
		Nodo aux = new Nodo(novaSerie);
		
		if(listaVazia()) {
			this.primeiro = this.ultimo = aux;
			this.tamanho++;
		} else {
			aux.setProximo(this.primeiro);
			this.primeiro.setAnterior(aux);
			
			this.primeiro = aux;
			
			this.tamanho++;
		}
		
	}
	
	public void add(Serie novaSerie, int pos) throws Exception {
		Nodo aux = new Nodo(novaSerie);
		Nodo cont;
		
		if(!posicaoExiste(pos)) 
			throw new Exception("A posição não existe !");
		
		if(pos == 0) {
			this.addIni(novaSerie);
		} else if(pos == this.tamanho - 1) {
			this.addFim(novaSerie);
		} else {
			cont = this.primeiro;
			
			while(pos >= 0) {
				pos--;
				cont = cont.getProximo();
			}
			
			cont.getAnterior().setProximo(aux);
			cont.setAnterior(aux);
			
			aux.setAnterior(cont.getAnterior());
			aux.setProximo(cont);
			
			this.tamanho++;
		}
	}
		
	public Serie rmIni() throws Exception {
		if(listaVazia())
			throw new Exception("A lista está vazia !");
		
		Nodo aux = this.primeiro;
		this.primeiro = aux.getProximo();
	
		aux.setAnterior(null);
		aux.setProximo (null);
		
		this.tamanho--;
		
		return aux.getSerie();
	}

	public Serie rmFim() throws Exception {
		if(listaVazia())
			throw new Exception("A lista está vazia !");
		
		Nodo aux = this.ultimo; 
		this.ultimo = aux.getAnterior();

		aux.setAnterior(null);
		aux.setProximo (null);
		
		this.tamanho--;
		
		return aux.getSerie();
	}
	
	public Serie rm(int id) throws Exception {
		if(listaVazia())
			throw new Exception("A lista está vazia !");
		
		Nodo aux = this.primeiro; 
		
		int i = 0;
		while(aux != null && !(aux.getSerie().getId() == id) ) {
			aux = aux.getProximo();
			i++;
		}
		
		JOptionPane.showMessageDialog(null, i + " FODEO.");
		if(aux == null) 
			throw new Exception("Não existe nenhuma Série com esse código !");
		
		if(aux != this.primeiro) {
			aux.getAnterior().setProximo(aux.getProximo());
		}
	
		aux.setAnterior(null);
		aux.setProximo (null);
		
		this.tamanho--;
		
		return aux.getSerie();
	}

	public Serie rm(Serie toRemove) throws Exception {
		if(listaVazia())
			throw new Exception("A lista está vazia !");
		
		Nodo aux = this.primeiro; 
		
		while(aux.getProximo() != null && !aux.equals(toRemove)) {
			aux = aux.getProximo();
		}

		aux.setAnterior(null);
		aux.setProximo (null);
		
		this.tamanho--;
		
		return aux != null 
				? aux.getSerie()
				: null;
	}

	private boolean listaVazia() {
		return this.tamanho == 0;
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
		
		Nodo aux = primeiro.getProximo();
		Object[] helper;
		int i = 0;
		while(aux != null) {
			helper = aux.getSerie().toObject();
			data[i]= helper;
			aux = aux.getProximo();
			i++;
		}
		
		return data;
	}

	public int getTamanho() {
		return tamanho;
	}

	public Serie getSerie(int posicao) throws Exception {
		Nodo aux;
		
		if(!posicaoExiste(posicao)) {
			throw new Exception("A posição informada não existe !");
		}
	
		aux = primeiro;
		for(int i = posicao; i > 0; i--) {
			aux = aux.getProximo();
		}
		return aux.getSerie();
	}

	private boolean posicaoExiste(int posicao) {
		return posicao >= 0 && posicao < tamanho;
	}
}
