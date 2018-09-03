package Model;

public class Nodo {
	private Serie serie; 
	private Nodo  ant;
	
	private Nodo() {}

	public Nodo(Serie serie) {
		this.serie = serie;
	}
	
	public Nodo(Serie serie, Nodo prox) {
		this.serie = serie;
		this.ant = prox;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Nodo getAnterior() {
		return ant;
	}

	public void setAnterior(Nodo prox) {
		this.ant = prox;
	}
}
