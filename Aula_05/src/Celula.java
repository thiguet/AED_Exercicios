public class Celula {
	private String str; 
	private Celula proximo; 
	private Celula anterior;

	public Celula () {
		this.str = null;
		this.proximo = null;
	}
	
	public Celula (String serie) {
		this.str = serie;
		this.proximo = null;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String serie) {
		this.str = serie;
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
