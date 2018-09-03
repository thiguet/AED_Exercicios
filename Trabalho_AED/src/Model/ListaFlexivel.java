package Model;

public class ListaFlexivel {
	
	private Nodo ultimo;
	
	public ListaFlexivel () {
		this.ultimo = new Nodo(null);
	}
	
	public ListaFlexivel(Serie novaSerie) {
		this.ultimo = new Nodo(null);
		this.ultimo.setAnterior(new Nodo(novaSerie));
	}
	
	public void add(Serie novaSerie) {
		Nodo aux = new Nodo(novaSerie, this.ultimo);
		this.ultimo = aux;
	}
	
	public Serie rm() throws Exception {
		if(listaEstaVazia())
			throw new Exception("A lista está vazia !");
		
		Nodo aux = this.ultimo; 
		
		while(aux.getAnterior() != null) {
			aux = aux.getAnterior();
		}
		
		return aux.getSerie();
	}

	private boolean listaEstaVazia() {
		return this.ultimo.getAnterior() == null;
	}
	
	/*
	public Nodo printLista() {
		Nodo aux = ultimo;
		
		while(aux.getAnterior() != null) {
			
			aux = aux.getAnterior();
		}
	}
	*/
	
}
