package GUI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPageGUI extends JFrame {

		public MainPageGUI () {
			super("NetLix Series Manager");
			super.setDefaultLookAndFeelDecorated(true);
			super.setLayout( new GridLayout ());
			super.setVisible(true);
			super.setSize(400, 1200);
			super.setLocation(800, 100);
			super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.initializeGUI();
		}
		
		private void initializeGUI () {
			JPanel panel = new JPanel();
			
			JButton listarSeries 	= new JButton ("Buscar Séries");
			JButton listarFavoritas = new JButton ("Favoritos");
			
			panel.add(listarSeries);
			panel.add(listarFavoritas);
			
			super.add(panel);
		}
}
