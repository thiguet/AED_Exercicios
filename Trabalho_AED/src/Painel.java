import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Painel {

	public static void main (String args[]) {
		JPanel japel = new JPanel();
		
		JButton j = new JButton ("Jorginho");
		
		japel.setSize(1000,1000);
		
		japel.add(j);
		
	}
}
