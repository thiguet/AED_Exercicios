
public class Celula {
	Contato primeiro;
	Contato ultimo;
	
	Celula() {
		primeiro = ultimo = new Contato();
	}

	public Contato getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(Contato primeiro) {
		this.primeiro = primeiro;
	}

	public Contato getUltimo() {
		return ultimo;
	}

	public void setUltimo(Contato ultimo) {
		this.ultimo = ultimo;
	}

	public void add(String nome) {
		if(primeiro == ultimo) {
			
		}
	}
	
}
