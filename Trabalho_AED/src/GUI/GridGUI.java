package GUI;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.FavoritosController;
import Controller.SeriesController;
import Model.MyDefaultTableModel;

public abstract class GridGUI extends BackGUI {
	
	private static final long serialVersionUID = 4L;
	
	public static final FavoritosController favsController = new FavoritosController();
	public static final SeriesController seriesController = new SeriesController ();
	
	private JTable tabela;
	private JScrollPane scroll;

	public GridGUI (Object[][] jTableData) {
		super();
		
		MyDefaultTableModel model = new MyDefaultTableModel(jTableData);		
		
		initializeGUI(model);
	}
	
	private void initializeGUI(DefaultTableModel model ) {
		Dimension d = new Dimension(1100, 400);
		
		this.setLocation(100, 120);
		this.setSize(1150, 550);	
		
		this.initializeJTable(model, d);
		
		this.scroll = new JScrollPane(this.tabela, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.scroll.setMaximumSize(d);
		this.scroll.setMinimumSize(d);

		this.scroll.setPreferredSize(d);
		
		this.painel.add(this.scroll);
		
		this.scroll.setBackground(java.awt.Color.cyan);
	}

	private void initializeJTable(DefaultTableModel model, Dimension d) {
		this.tabela = new JTable( model );
				
		this.tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		this.tabela.setMaximumSize(d);
		this.tabela.setMinimumSize(d);
		
		this.tabela.getModel().addTableModelListener(new MyTableModelListener(this));

		this.tabela.setSize(d);
		
		this.tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
		this.tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
		this.tabela.getColumnModel().getColumn(2).setPreferredWidth(80);
		this.tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
		this.tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
		this.tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
		this.tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
		this.tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
		this.tabela.getColumnModel().getColumn(8).setPreferredWidth(100);
		this.tabela.getColumnModel().getColumn(9).setPreferredWidth(100);
		
		this.tabela.setBackground(java.awt.Color.cyan);
	}

	public void removeRow(int rowNumber) {
		((MyDefaultTableModel) this.tabela.getModel()).removeRow(rowNumber);	
	}
	
	public void addNewRow(Object[] row) {
		((MyDefaultTableModel) this.tabela.getModel()).addRow(row);	
	}
	
	public abstract void checkedEvent(int row) throws Exception;
	
}
