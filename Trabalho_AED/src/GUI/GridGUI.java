package GUI;

import java.awt.Dimension;

import javax.swing.*;

import Controller.SeriesController;

public abstract class GridGUI extends BackGUI {
	
	private static final long serialVersionUID = 1L;
	
	private JTable tabela;
	private JScrollPane scroll;
	
	public GridGUI () {
		super();
		initializeGUI();
	}

	private void initializeGUI() {
		new SeriesController ();	
		
		MyDefaultTableModel model = new MyDefaultTableModel(SeriesController.getSeriesInObjectType(), 
				new Object [] {"Cod.","Nome","Tipo","Idioma","Duração","Temporadas","Episódios", "Favoritos"});
		
		this.tabela = new JTable( model );
		
		this.setLocation(200, 120);
		this.setSize(950, 550);
		
		this.tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		Dimension d = new Dimension(900, 400);

		this.tabela.setMaximumSize(d);
		this.tabela.setMinimumSize(d);
		
		this.scroll = new JScrollPane(this.tabela, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.scroll.setMaximumSize(d);
		this.scroll.setMinimumSize(d);

		this.tabela.setSize(d);
		this.scroll.setPreferredSize(d);
		
		this.painel.add(this.scroll);
		
		this.tabela.getModel().addTableModelListener(new MyTableModelListener());

		this.tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
		this.tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
		this.tabela.getColumnModel().getColumn(2).setPreferredWidth(80);
		this.tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
		this.tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
		this.tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
		this.tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
		
		this.scroll.setBackground(java.awt.Color.cyan);
		this.tabela.setBackground(java.awt.Color.cyan);
	}
}
