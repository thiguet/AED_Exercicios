package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class OptionsGUI extends BackGUI {
	
	private static final long serialVersionUID = 1L;

	private static final String RANDOM_LABEL = "Ordenar as séries aleatoriamente",
						 		MY_ORDENATION_LABEL = "Ordenar as séries alfabeticamente";
	
	private JButton random, 
					myOrdenation;
	
	public OptionsGUI() {
		super();
		initializeGUI();
	}
	
	private void initializeGUI() {
		random = new JButton(RANDOM_LABEL);
		myOrdenation = new JButton(MY_ORDENATION_LABEL);

		super.painel.add(random);
		super.painel.add(myOrdenation);
		
		initializeComponents();
	}
	
	public JButton getRandom() {
		return random;
	}

	public void setRandom(JButton random) {
		this.random = random;
	}

	public JButton getMyOrdenation() {
		return myOrdenation;
	}

	public void setMyOrdenation(JButton myOrdenation) {
		this.myOrdenation = myOrdenation;
	}
	
	private void initializeComponents () {
		this.myOrdenation.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	GUI.seriesController.orderByMyOrdenation();
		    	GUI.favsController.orderByMyOrdenation();
			}
		});

		this.random.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	GUI.seriesController.orderByRandom();
		    	GUI.favsController.orderByRandom();
			}
		});		
	}
	
}