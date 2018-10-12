
public class Arvore {
	private Nodo raiz;

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	public void inserir(String nome) throws Exception {
		this.raiz = inserir(nome, raiz);
	}
	
	public Nodo inserir (String nome, Nodo novoNo) throws Exception {
		if(nome == null) {
			novoNo = new Nodo(nome);
//		} else if( novoNo.getEsq().equals() ) {
//			
//		} else if() {
//			
		} else {
			throw new Exception("Deu Ruim");
		}
		
		return novoNo;
	}
	
	
}
