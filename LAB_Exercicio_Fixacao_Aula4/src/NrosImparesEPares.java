/*
 * Escreva  um  programa  que  imprima  na  tela  a  soma  dos  n�meros  �mpares  
 * entre 0 e 30 e a  
 * multiplica��o  dos  n�meros  pares  entre 0 e 30.
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
			
			System.out.println("A soma dos n�meros pares :" + somaPares);
			System.out.println("A soma dos n�meros �mpares :" + somaImpares);
	}
}
