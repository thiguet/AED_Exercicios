package Model;

public class Celula {
	private Serie serie; 
	private Celula  proximo; 
	private Celula  anterior;

	public Celula() {
		this.serie = null;
		this.proximo = null;
	}
	
	public Celula(Serie serie) {
		this.serie = serie;
		this.proximo = null;
	}
	
	public Celula(Serie serie, Celula prox) {
		this.serie = serie;
		this.proximo = prox;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Celula getProximo() {
		return proximo;
	}

	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}

	public Celula getAnterior() {
		return anterior;
	}

	public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}
}
