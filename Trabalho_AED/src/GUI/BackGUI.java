package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BackGUI extends GUI {
	private static final long serialVersionUID = 1L;
	
	protected JPanel painel;
	protected JButton voltar;
	
	public BackGUI () {
		super();
		initializeGUI();
	}

	private void initializeGUI() {
		this.painel = new JPanel();
		
		Dimension d = new Dimension(1000, 200);

		this.painel.setMaximumSize(d);
		this.painel.setMinimumSize(d);
		
		super.add(painel);
	
		initializeComponents();
	}	
	
	private void initializeComponents() {
		this.voltar = new JButton("Voltar");
		
		this.painel.add(this.voltar);
		
		this.voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainPageGUI();
				dispose();
			}
		});
	}
}