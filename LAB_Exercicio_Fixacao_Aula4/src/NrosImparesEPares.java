/*
 * Escreva  um  programa  que  imprima  na  tela  a  soma  dos  números  ímpares  
 * entre 0 e 30 e a  
 * multiplicação  dos  números  pares  entre 0 e 30.
 * */

public class NrosImparesEPares {
	
	NrosImparesEPares () {}
	
	public static void main (String args[]) {
		int somaPares = 0, 
			somaImpares = 0;
			
			for(int a = 0 ; a <=30 ; a++) {
				if(a % 2 == 0) {
					somaPares += a;
				} else {
					somaImpares +=a;
				}
			}
			
			System.out.println("A soma dos números pares :" + somaPares);
			System.out.println("A soma dos números ímpares :" + somaImpares);
	}
}
