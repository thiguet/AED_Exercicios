
public class MaiorNumero {
	
	MaiorNumero() {}
	
	public static void main(String args[]) {
		System.out.println(retornaMaiorNumero(3, 2));
	}
	
	public static int retornaMaiorNumero (int n1, int n2) {
		return n1 > n2 
					? n1	 
					: n2;
	}
}
