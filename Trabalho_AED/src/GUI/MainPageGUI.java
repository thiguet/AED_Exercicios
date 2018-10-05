package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainPageGUI extends GUI {
	
	private static final String NOME_NAO_EXISTE = "N�o existe nenhuma s�rie cadastrada com esse nome !";

	private static final long serialVersionUID = 1L;
	
	private static final String LISTAR_SERIES_LABEL = "Listar S�ries",
								FAVORITOS_LABEL = "Favoritos",
								BUSCAR_SERIE_LABEL = "Buscar S�rie",
								ORDENAR_LABEL = "Ordenar S�ries",
								SUGERIR_SERIE = "Sugerir S�rie";
	
	private JButton listarSeries,
					listarFavoritas,
					buscarSerie,
					opcao,
					sugerirSerie;

	public static void main (String args[]) {
		new MainPageGUI ();
	}		
	
	public MainPageGUI () {
		super();
		this.initializeGUI();
	}
	
	private void initializeGUI () {
		JPanel panel = new JPanel();
		
		this.listarSeries 	 = new JButton (LISTAR_SERIES_LABEL);
		this.listarFavoritas = new JButton (FAVORITOS_LABEL);
		this.buscarSerie 	 = new JButton (BUSCAR_SERIE_LABEL);
		this.opcao			 = new JButton (ORDENAR_LABEL);
		this.sugerirSerie    = new JButton (SUGERIR_SERIE); 
		
		panel.add(listarSeries);
		panel.add(listarFavoritas);
		panel.add(buscarSerie);
		panel.add(opcao);
		panel.add(sugerirSerie);
		
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
		    	buscarSerie();
		    }
		});	

		this.opcao.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	exibirOpcao();
		    }
		});	
		
		this.sugerirSerie.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	sugerirSerie();
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
	
	private void buscarSerie() {
		String resultado = null,
			   input = JOptionPane.showInputDialog("Digite o nome da s�rie:");
		
		if(input != null) {			
			input = input.trim();
			
			resultado = GUI.seriesController.getSerieToString(input);
			
			if(resultado == null) 
				resultado = GUI.favsController.getSerieToString(input);
			
			if(resultado == null) 
				resultado = NOME_NAO_EXISTE;

			JOptionPane.showMessageDialog(null, resultado);
		}		
	}
	
	private void sugerirSerie() {
		Random rand = new Random();
		
		int tamanho = GUI.seriesController.getLista().getTamanho();
		try {
			if( tamanho > 0 ) {
				int random = rand.nextInt(tamanho);
				JOptionPane.showMessageDialog(null, "Talvez voc� tamb�m curta a s�rie: " +  GUI.seriesController.getLista().getSerieByPos(random));
				
			} else {
				JOptionPane.showMessageDialog(null, "N�o existem sugest�es para voc� ! *_* ");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
