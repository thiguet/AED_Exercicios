/*
 * 1 -   Implemente  a  classe  conta  descrita  anteriormente.  
 * 		 Crie  os  atributos  citados  e  mais  um  identificador  
 * 			para  o  n�mero  da  conta  corrente.  
 * 		 Crie  um  m�todomainque  constroi  dois  objetos  da  
 * 			classe  contautilizando  a  cl�usula new como  descrito
 *   		na  classe  Data.  Teste  as  fun��es  sacar  e  depositar,  
 *   		imprimindo-os  resultados  na  tela 
 * Author : Thiguet Cabral
 * Date	  : 13/08/2018
 * GITHUB : https://github.com/thiguet
 */

public class ContaBancaria {
	private float Saldo,  
				  SaldoMinimo;
	private String NomeDono;  
	private int Identificador;

	ContaBancaria () {}
	
	ContaBancaria (String Nome, int Identificador, float Saldo, float SaldoMinimo) {
		this.NomeDono = Nome;
		this.Identificador = Identificador;
		this.Saldo = Saldo;
		this.SaldoMinimo = SaldoMinimo;
	}
	
	public void Sacar(float Quantia) throws Exception {
		if(Quantia > this.Saldo) {
			throw new Exception("Saldo Insuficiente !");
		} else if (Quantia > this.Saldo + this.SaldoMinimo) {
			throw new Exception("Essa opera��o excede o saldo m�nimo !");
		}
		this.Saldo -= Quantia; 
	}
	
	public void Depositar(float Quantia) {
		this.Saldo += Quantia;
	}
	
	public void AlterarSaldoMinimo(float NovoSaldo) {
		this.SaldoMinimo = NovoSaldo;
	}
	
	public float ConsultarSaldo () {
		return this.Saldo;
	}
	
	public void setNome( String Nome) {
		this.NomeDono = Nome;
	}
	
	public String getNome () {
		return this.NomeDono;
	}
	
	public int getID () {
		return this.Identificador;
	}
}
