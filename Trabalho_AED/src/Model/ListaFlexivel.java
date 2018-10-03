package Model;

public class ListaFlexivel implements IDemandaExercicio {
	private Celula primeiro;
	private Celula ultimo;
	private int tamanho;

	public ListaFlexivel () {
		this.ultimo = this.primeiro = null;
		this.tamanho = 0;
	}

	public int getTamanho() {
		return tamanho;
	}
	
	public ListaFlexivel(Serie novaSerie) {
		this.primeiro = this.ultimo = new Celula(novaSerie);
		this.tamanho++;
	}
	
	public void addFim(Serie novaSerie) {
		Celula aux = new Celula(novaSerie);
		
		novaSerie.setId(this.tamanho + 1);	
		
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
		Celula aux = new Celula(novaSerie);
		
		novaSerie.setId(this.tamanho + 1);
		
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
		Celula aux = new Celula(novaSerie);
		Celula cont;
		
		novaSerie.setId(this.tamanho + 1);
		
		if(!posicaoExiste(pos)) 
			throw new Exception("A posi��o n�o existe !");
		
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
			throw new Exception("A lista est� vazia !");
		
		Celula aux = this.primeiro;
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
			throw new Exception("A lista est� vazia !");
		
		Celula aux = this.ultimo; 
		Serie serie = aux.getSerie();
		
		this.ultimo = this.ultimo.getAnterior();
		
		this.ultimo.setProximo(null);
		
		aux = null;
		this.tamanho--;
		
		return serie;
	}

	public Serie rm(int pos) throws Exception {
		if(listaVazia())
			throw new Exception("A lista est� vazia !");
		
		if(!posicaoExiste(pos))
			throw new Exception("A posi��o � inv�lida !");
			
		Celula aux = this.primeiro; 
		Serie serie;
	
		while(aux != null && pos > 0 ) {
			aux = aux.getProximo();
			pos--;
		}
		
		if(aux == null) 
			throw new Exception("N�o foi poss�vel remover essa S�rie !");
		
		if(aux == this.primeiro) {
			aux = new Celula(this.rmIni());
		} else if(aux == this.ultimo) {
			aux = new Celula(this.rmFim());
		} else {
			aux.getAnterior().setProximo(aux.getProximo());
			aux.getProximo().setAnterior(aux.getAnterior());
			
			this.tamanho--;
		}
		
		serie = aux.getSerie();
		aux = null;
		
		return serie;
	}

	private boolean listaVazia() {
		return this.tamanho == 0;
	}

	private boolean posicaoExiste(int pos) {
		return ((pos >= 0) && (pos < tamanho));
	}

	public Serie getSerieByPos(int pos) throws Exception {
		Celula aux;
		
		if(!posicaoExiste(pos)) {
			throw new Exception("A posi��o informada n�o existe !");
		}
	
		aux = primeiro;
		for(int i = pos; i > 0; i--) {
			aux = aux.getProximo();
		}
		return aux.getSerie();
	}
	
	public Serie getSerieByName(String name) {
		Celula aux = primeiro;
		
		while( aux != null && 
			   !name.equals(aux.getSerie().getNome()) ) {
			aux = aux.getProximo();
		}
		
		return (aux == null) 
				? null
				: aux.getSerie();
	}
	
	public String getListToSaveInFile() {
		String str = "";
		
		Celula aux = this.primeiro;
		
		while(aux != null) {
			str += aux.getSerie().toFileFormat();
			aux = aux.getProximo();
		}
		
		return str;
	}
	
	@Override
	public String toString() {
		String str = "";
		
		Celula aux = this.primeiro;
		
		while(aux != null) {
			str += aux.getSerie().toString();
			aux = aux.getProximo();
		}
		
		return str;
	}

	@Override
	public void orderByMyOrdenation() {
		// Write that code boy	
	}

	@Override
	public void orderByRandom() {
		int lucky = (int) (Math.random() * this.tamanho);
		Serie aux = null;
		
		for(int cont = this.tamanho / 2; cont > 0 ; cont--) {
			try {
				aux = this.rm(lucky);
			} catch (Exception e) {
				// Write that code boy
			}
			
			lucky = (int) (Math.random() * this.tamanho);
			
			
			try {
				this.add(aux, lucky);
			} catch (Exception e) {
				// Write that code boy
			}
		}
	}

}
