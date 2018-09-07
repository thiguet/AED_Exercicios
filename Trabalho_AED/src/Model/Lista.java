package Model;

public class Lista {
	private Serie series [];
	private int tamanho;

	public Lista(int tamanho) {
		this.series = new Serie[tamanho];
	}
	
	public void adicionarFinal(Serie novaSerie) throws Exception {
		if(this.series.length == (this.tamanho + 1)) 
			throw new Exception("Não é possível adicionar, pois a lista está cheia !");
				
		this.series[++this.tamanho] = novaSerie;
	}	
	
	public void adicionar(Serie novaSerie, int pos) throws Exception {
		if(listaEstaCheia() || posicaoNaoExiste(pos)) 
			throw new Exception("Não é possível adicionar, pois a lista está cheia !");
		
		for(int i = this.tamanho ; i > pos; i--) {
			this.series[(i + 1)]  = this.series[i];
		}
		
		this.series[pos] = novaSerie;
		this.tamanho++;
	}	
	
	public Serie remover() throws Exception {
		if(listaEstaVazia()) 
			throw new Exception("Não é possível remover, pois a lista está vazia !"); 
		
		return series[--this.tamanho];
	}
	
	public Serie remover(int pos) throws Exception {
		if(listaEstaVazia()) 
			throw new Exception("Não é possível remover, pois a lista está vazia !"); 
		
		for(int i = pos ; i < this.tamanho; i++) {
			this.series[i]  = this.series[i++];
		}

		this.tamanho--;
		return series[pos];
	}

	public int getTamanho() {
		return this.tamanho;
	}
	
	private boolean listaEstaCheia() {
		return this.series.length == (this.tamanho + 1);
	}
	
	private boolean posicaoNaoExiste(int pos) {
		return (pos < 0 || 
			    pos > this.series.length);
	}

	private boolean listaEstaVazia() {
		return series.length == 0;
	}
	
}
