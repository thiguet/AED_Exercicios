
public class No {
	public char letra;
	public No esq;
	public No dir;
	public Celula lista;

	No (char letra) {
		this.letra = letra;
		lista = new Celula();
		esq = dir = null;
	}
}
