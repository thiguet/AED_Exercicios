package Model;

public class Nodo {
	private Serie serie; 
	private Nodo  prox;

	public Nodo() {
		this.serie = null;
		this.prox = null;
	}
	
	public Nodo(Serie serie) {
		this.serie = serie;
		this.prox = null;
	}
	
	public Nodo(Serie serie, Nodo prox) {
		this.serie = serie;
		this.prox = prox;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Nodo getProx() {
		return prox;
	}

	public void setProx(Nodo prox) {
		this.prox = prox;
	}
}
