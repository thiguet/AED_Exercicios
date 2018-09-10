package GUI;

import java.awt.GridLayout;

import javax.swing.JFrame;

public abstract class GUI extends JFrame {	
	private static final long serialVersionUID = 1L;

	public GUI() {
		super("NetLix Series Manager");
		super.setVisible(true);
		super.setSize(400, 600);
		super.setLocation(800, 100);
		super.setLayout(new GridLayout (1, 1));
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
