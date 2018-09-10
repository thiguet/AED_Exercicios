package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPageGUI extends GUI {
	
	private static final long serialVersionUID = 1L;
	JButton listarSeries,
			listarFavoritas;
		
	public MainPageGUI () {
		super();
		this.initializeGUI();
	}
	
	private void initializeGUI () {
		JPanel panel = new JPanel();
		
		this.listarSeries 	 = new JButton ("Buscar Séries");
		this.listarFavoritas = new JButton ("Favoritos");
		
		panel.add(listarSeries);
		panel.add(listarFavoritas);
		
		super.add(panel);
		
		initializeComponents();
	}

	private void initializeComponents() {

		this.listarSeries.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	exibirTelaSeries();
		    }
		});

		this.listarFavoritas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	exibirTelaFavoritos();
		    }
		});		
	}

	private void exibirTelaFavoritos () {
		super.dispose();
	    new FavoritosGUI();
    }

	private void exibirTelaSeries () {
		super.dispose();
		new SeriesGUI();
    }
}
