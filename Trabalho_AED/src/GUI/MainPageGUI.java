package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.SeriesController;

public class MainPageGUI extends GUI {
	
	private static final long serialVersionUID = 1L;
	JButton listarSeries,
			listarFavoritas,
			buscarSerie,
			opcao;
		
	public MainPageGUI () {
		super();
		this.initializeGUI();
	}
	
	private void initializeGUI () {
		JPanel panel = new JPanel();
		
		this.listarSeries 	 = new JButton ("Visualizar Séries");
		this.listarFavoritas = new JButton ("Favoritos");
		this.buscarSerie 	 = new JButton ("Buscar uma Série");
		this.opcao			 = new JButton ("Opção");
		
		panel.add(listarSeries);
		panel.add(listarFavoritas);
		panel.add(buscarSerie);
		panel.add(opcao);
		
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

		this.buscarSerie.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SeriesController.getSerie();
		    }
		});	

		this.opcao.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	exibirOpcao();
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
	
	private void exibirOpcao() {
		super.dispose();
    	new OptionsGUI ();
    }
}
