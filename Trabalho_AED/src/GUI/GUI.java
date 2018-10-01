package GUI;

import java.awt.GridLayout;

import javax.swing.JFrame;

import Controller.FavoritosController;
import Controller.SeriesController;

public abstract class GUI extends JFrame {	
	private static final long serialVersionUID = 1L;

	public static final FavoritosController favsController = new FavoritosController();
	public static final SeriesController seriesController = new SeriesController ();
	
	public GUI() {
		super("NetLix Series Manager");
		super.setVisible(true);
		super.setSize(400, 600);
		super.setLocation(800, 100);
		super.setLayout(new GridLayout (1, 1));
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}