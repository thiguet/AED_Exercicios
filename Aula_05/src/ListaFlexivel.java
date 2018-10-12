
public class ListaFlexivel {
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
	
	public ListaFlexivel(String novaSerie) {
		this.primeiro = this.ultimo = new Celula(novaSerie);
		this.tamanho++;
	}
	
	public void addFim(String novaSerie) {
		Celula aux = new Celula(novaSerie);
		
		if(listaVazia()) {
			this.primeiro = this.ultimo = aux;
		} else {
			aux.setAnterior(this.ultimo);
			this.ultimo.setProximo(aux);
			
			this.ultimo = aux;
		}

		this.tamanho++;
	}

	public void addIni(String novaSerie) {
		Celula aux = new Celula(novaSerie);
		
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

	public void add(String novaSerie, int pos) throws Exception {
		Celula aux = new Celula(novaSerie);
		Celula cont;
		
		if(pos == 0) {
			this.addIni(novaSerie);
		} else if(pos == this.tamanho) {
			this.addFim(novaSerie);
		} else {
			if(!posicaoExiste(pos)) 
				throw new Exception("A posição não existe !");
			
			cont = this.primeiro;
			
			while(pos > 0) {
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
	
	public String rmIni() throws Exception {
		if(listaVazia())
			throw new Exception("A lista está vazia !");
		
		Celula aux = this.primeiro;
		String str = aux.getStr();
		
		this.primeiro = this.primeiro.getProximo();
		if(this.primeiro == null)
			this.primeiro = this.ultimo;
		
		aux.setProximo(null);
		this.primeiro.setAnterior(null);
			
		aux = null;
		this.tamanho--;
		
		return str;
	}

	public String rmFim() throws Exception {
		if(listaVazia())
			throw new Exception("A lista está vazia !");
		
		Celula aux = this.ultimo; 
		String str = aux.getStr();
		
		this.ultimo = this.ultimo.getAnterior();		
		
		if(this.ultimo == null)
			this.ultimo = this.primeiro = null;
		else
			this.ultimo.setProximo(null);
		
		aux = null;
		this.tamanho--;
		
		return str;
	}

	public String rm(int pos) throws Exception {
		if(listaVazia())
			throw new Exception("A lista está vazia !");
		
		if(!posicaoExiste(pos))
			throw new Exception("A posição é inválida !");
			
		Celula aux = this.primeiro;
		String str;
		
		if(pos == 0) {
			aux = new Celula(this.rmIni());
		} else if(pos == this.tamanho || pos == this.tamanho - 1 ) {
			aux = new Celula(this.rmFim());
		} else {
			while(pos > 0 ) {
				aux = aux.getProximo();
				pos--;
			}
			
			if(aux == null) 
				throw new Exception("Não foi possível remover essa Série !");
			
			if(aux.getAnterior() != null)
				aux.getAnterior().setProximo(aux.getProximo());
			if(aux.getProximo() != null)
				aux.getProximo().setAnterior(aux.getAnterior());
			
			this.tamanho--;
		}
		
		str = aux.getStr();
		aux = null;
		
		return str;
	}

	private boolean listaVazia() {
		return this.tamanho == 0;
	}

	private boolean posicaoExiste(int pos) {
		return ((pos >= 0) && (pos < tamanho));
	}
}
