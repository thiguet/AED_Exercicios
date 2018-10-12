public class Nodo {
	private Contato str; 
	private Nodo esq; 
	private Nodo dir;

	public Nodo() {
		this.str = null;
		this.esq = null;
	}

	public Nodo(String nome) {
		this.str = nome;
		this.dir = this.esq = null;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Nodo getEsq() {
		return esq;
	}

	public void setEsq(Nodo esq) {
		this.esq = esq;
	}

	public Nodo getDir() {
		return dir;
	}

	public void setDir(Nodo dir) {
		this.dir = dir;
	}
}
