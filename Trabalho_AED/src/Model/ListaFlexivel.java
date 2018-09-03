package Model;

public class ListaFlexivel {
	
	private Nodo ultimo;
	
	ListaFlexivel () {
		ultimo = new Nodo(null, null);
	}
	
	ListaFlexivel(Serie novaSerie) {
		ultimo = new Nodo(null, null);
		ultimo.setProx(new Nodo(novaSerie, null));
	}
	
	public void add(Serie novaSerie) {
		
	}
	
	
	public Serie remover() throws Exception {
		if(listaEstaVazia())
			throw new Exception("A lista está vazia !");
		
		Nodo aux = ultimo; 
		
		while(aux.getProx() != null) {
			aux = aux.getProx();
		}
		
		return aux.getSerie();
	}

	private boolean listaEstaVazia() {
		return this.ultimo.getProx() == null;
	}
	
	
}
