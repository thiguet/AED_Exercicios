package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.SeriesController;

public abstract class GridGUI extends GUI {
	GridLineGUI lines[];
	JPanel painel;
	JButton voltar;
	
	public GridGUI () {
		super();
		initializeGUI();
	}

	private void initializeGUI() {
		SeriesController controller = new SeriesController();
		
		this.painel = new JPanel();
		this.voltar = new JButton("Voltar");
		
		painel.add(voltar);
		super.add(painel);
		
		initializeComponents();
	}

	private void initializeComponents() {
		this.voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	
	
}
