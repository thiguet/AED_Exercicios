import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		ContaBancaria p1 = new ContaBancaria("João",  1,  0.0F, 1000.0F);
		ContaBancaria p2 = new ContaBancaria("Maria", 2, 0.0F, 1000.0F);
		
		try {
			p1.Depositar(20000.0F);
			JOptionPane.showMessageDialog(null, p1.getNome() + " TEM  " + p1.ConsultarSaldo() + " GOLPINHOS");
			
			p1.Sacar(10.0F);
			JOptionPane.showMessageDialog(null, p1.getNome() + " TEM  " + p1.ConsultarSaldo() + " GOLPINHOS" );
			
			p2.Depositar(10000.0F);
			JOptionPane.showMessageDialog(null, p2.getNome() + " TEM  " + p2.ConsultarSaldo() + " GOLPINHOS" );
			
			p2.Sacar(20.0F);
			JOptionPane.showMessageDialog(null, p2.getNome() + " TEM  " + p2.ConsultarSaldo() + " GOLPINHOS" );
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage() );
		}
	}

}
