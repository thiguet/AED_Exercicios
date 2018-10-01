package Model;

public class ListaFlexivel {
	private Nodo primeiro;
	private Nodo ultimo;
	private int tamanho;

	public ListaFlexivel () {
		this.ultimo = this.primeiro = null;
		this.tamanho = 0;
	}

	public int getTamanho() {
		return tamanho;
	}
	
	public ListaFlexivel(Serie novaSerie) {
		this.primeiro = this.ultimo = new Nodo(novaSerie);
		this.tamanho++;
	}
	
	public void addFim(Serie novaSerie) {
		Nodo aux = new Nodo(novaSerie);
		
		if(listaVazia()) {
			this.primeiro = this.ultimo = aux;
		} else {
			aux.setAnterior(this.ultimo);
			this.ultimo.setProximo(aux);
			
			this.ultimo = aux;
		}

		this.tamanho++;
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
		Serie serie = aux.getSerie();
		
		this.primeiro = this.primeiro.getProximo();
		
		if(this.primeiro == null) 
			this.primeiro = this.ultimo = null;
		else
			this.primeiro.setAnterior(null);
		
		aux = null;
		this.tamanho--;
		
		return serie;
	}

	public Serie rmFim() throws Exception {
		if(listaVazia())
			throw new Exception("A lista está vazia !");
		
		Nodo aux = this.ultimo; 
		Serie serie = aux.getSerie();
		
		this.ultimo = this.ultimo.getAnterior();
		
		this.ultimo.setProximo(null);
		
		aux = null;
		this.tamanho--;
		
		return serie;
	}

	public Serie rm(int pos) throws Exception {
		if(listaVazia())
			throw new Exception("A lista está vazia !");
		
		if(!posicaoExiste(pos))
			throw new Exception("A posição é inválida !");
			
		Nodo aux = this.primeiro; 
		Serie serie;
	
		while(aux != null && pos > 0 ) {
			aux = aux.getProximo();
			pos--;
		}
		
		if(aux == null) 
			throw new Exception("Não foi possível remover essa Série !");
		
		if(aux == this.primeiro) {
			aux = new Nodo(this.rmIni());
		} else if(aux == this.ultimo) {
			aux = new Nodo(this.rmFim());
		} else {
			aux.getAnterior().setProximo(aux.getProximo());
			aux.getProximo().setAnterior(aux.getAnterior());
			
			this.tamanho--;
		}
		
		serie = aux.getSerie();
		aux = null;
		
		return serie;
	}

	public Serie rm(double pos) throws Exception {
		if(listaVazia())
			throw new Exception("A lista está vazia !");
			
		Nodo aux = this.primeiro; 
		Serie serie;
	
		while(aux != null && !(aux.getSerie().getId() == pos) ) {
			aux = aux.getProximo();
		}
		
		if(aux == null) 
			throw new Exception("Não existe nenhuma série com esse código !");
		
		if(aux == this.primeiro) {
			this.rmIni();
		} else if(aux == this.ultimo) {
			this.rmFim();
		} else {
			aux.getAnterior().setProximo(aux.getProximo());
			aux.getProximo().setAnterior(aux.getAnterior());
		}
		
		serie = aux.getSerie();
		aux = null;
		this.tamanho--;
		
		return serie;
	}

	private boolean listaVazia() {
		return this.tamanho == 0;
	}

	private boolean posicaoExiste(int pos) {
		return ((pos >= 0) && (pos < tamanho));
	}

	public Serie getSerieByPos(int pos) throws Exception {
		Nodo aux;
		
		if(!posicaoExiste(pos)) {
			throw new Exception("A posição informada não existe !");
		}
	
		aux = primeiro;
		for(int i = pos; i > 0; i--) {
			aux = aux.getProximo();
		}
		return aux.getSerie();
	}
	
	public Serie getSerieById(int id) {
		Nodo aux = primeiro;
		
		while(aux != null && (id != aux.getSerie().getId())) {
			aux = aux.getProximo();
		}
		
		return aux == null  
				     ? null
				     : aux.getSerie();
	}
	
	public String getListToSaveInFile() {
		String str = "";
		
		Nodo aux = this.primeiro;
		
		while(aux != null) {
			str += aux.getSerie().toFileFormat();
			aux = aux.getProximo();
		}
		
		return str;
	}
	
	@Override
	public String toString() {
		String str = "";
		
		Nodo aux = this.primeiro;
		
		while(aux != null) {
			str += aux.getSerie().toString();
			aux = aux.getProximo();
		}
		
		return str;
	}

}
