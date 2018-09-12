package Model;

public class Nodo {
	private Serie serie; 
	private Nodo  proximo; 
	private Nodo  anterior;

	public Nodo() {
		this.serie = null;
		this.proximo = null;
	}
	
	public Nodo(Serie serie) {
		this.serie = serie;
		this.proximo = null;
	}
	
	public Nodo(Serie serie, Nodo prox) {
		this.serie = serie;
		this.proximo = prox;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Nodo getProximo() {
		return proximo;
	}

	public void setProximo(Nodo proximo) {
		this.proximo = proximo;
	}

	public Nodo getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}
}
