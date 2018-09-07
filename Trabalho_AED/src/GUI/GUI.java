package GUI;

import java.awt.GridLayout;

import javax.swing.JFrame;

public abstract class GUI extends JFrame {

	public GUI() {
		super("NetLix Series Manager");
		super.setDefaultLookAndFeelDecorated(true);
		super.setSize(400, 600);
		super.setLocation(800, 100);
		super.setVisible(true);
		super.setLayout(new GridLayout ());
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
