
public class NumeroDecrescente {
	
	NumeroDecrescente() {};
	
	public static void main(String args[]) {
		imprimeNroDecrescenteAte0(6);
	}
	
	public static void imprimeNroDecrescenteAte0(int n) {
		while (n > 0) {
			System.out.println(n--);
		}		
	}

}
