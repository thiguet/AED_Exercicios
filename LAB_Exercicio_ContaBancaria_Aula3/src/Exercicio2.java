import javax.swing.JOptionPane;

/*
 * 2 -  Crie  um  vetor  de  objetos  Conta  com 10 posições.  
 * 		Cada  conta  terá  um  saldo  inicial,  um  identificador  (número)  
 * 		e  o  nome  do  cliente.  Crie  um  menu  de  opções  no  qual  o  
 * 		usuário  pode  alterar  os  dados da  conta,  fazer  depósito  e  saques.
 * 
 * Author : Thiguet Cabral
 * Date	  : 13/08/2018
 * GITHUB : https://github.com/thiguet
 */

public class Exercicio2 {
	static final int qtdContas = 10;
	
	public static void main(String[] args) {
		ContaBancaria contas[] = new ContaBancaria[10];
		ContaBancaria atual;
		
		int op, codigoContaAtual;
		
		for(int i = 0 ; i < qtdContas; i++) {
			contas[i] = new ContaBancaria("P " + i, i + 1, 0.0F, 0.0F);
		}
		
		op = Integer.parseInt(JOptionPane.showInputDialog(null, " 0 - Para Sair \n 1 - Alterar dados da conta \n 2 - Depósito \n 3 - Saque \n 4 - Consultar Saldo"));
		while(op != 0) {
			if( op < 5 && op >= 0 ) {
				codigoContaAtual = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o número da sua conta : "));
				atual = HelperGetConta(contas, codigoContaAtual);
				
				if(!(atual == null)) {
					switch(op) {
						case 1:
							AlterarDados(atual);
							break;
						case 2:
							Depositar(atual);
							break;
						case 3:
							Sacar(atual);
							break;
						case 4:
							ConsultarSaldo(atual);
							break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Esse código não está vinculado a nenhuma conta !");
				}
			}	
			op = Integer.parseInt(JOptionPane.showInputDialog(null, " 0 - Para Sair \n 1 - Alterar dados da conta \n 2 - Depósito \n 3 - Saque \n 4 - Consultar Saldo"));
		}
	}
	
	Exercicio2() {};

	public static void AlterarDados (ContaBancaria conta) {
		
	}

	public static void Depositar (ContaBancaria conta) {
		float valor = Float.parseFloat(JOptionPane.showInputDialog(null, "Insira o valor do Depósito :"));
		
		conta.Depositar(valor);
		
		JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso !");
	}

	public static void Sacar (ContaBancaria conta) {
		float valor = Float.parseFloat(JOptionPane.showInputDialog(null, "Insira o valor do Saque :"));
	
		try {
			conta.Sacar(valor);

			JOptionPane.showMessageDialog(null, "Saque realizado com sucesso !");
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public static void ConsultarSaldo (ContaBancaria conta) {
		JOptionPane.showMessageDialog(null, "O valor em conta é : " + conta.ConsultarSaldo());
	}
	
	public static ContaBancaria HelperGetConta (ContaBancaria[] contas, int nroConta) {
		for(int i = 0; i < qtdContas ; i++) {
			if (nroConta == contas[i].getID()) {
				return contas[i];
			}
		}
		return null;
	}
}
