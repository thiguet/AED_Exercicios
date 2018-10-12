package Model;

public class No {
	private String str; 
	private No esq; 
	private No dir;

	public No() {
		this.str = null;
		this.esq = null;
	}

	public String getSerie() {
		return str;
	}

	public void setSerie(String str) {
		this.str = str;
	}

	public No getProximo() {
		return esq;
	}

	public void setProximo(No esq) {
		this.esq = esq;
	}

	public No getAnterior() {
		return dir;
	}

	public void setAnterior(No dir) {
		this.dir = dir;
	}
}
