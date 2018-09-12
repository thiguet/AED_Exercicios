package GUI;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Controller.FavoritosController;
import Controller.SeriesController;
import Model.Serie;

public class MyTableModelListener implements TableModelListener {
	SeriesController seriesController;
	FavoritosController favController;
	
	MyTableModelListener () {
		super();
		this.seriesController = new SeriesController ();
		this.favController    = new FavoritosController ();
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
    	Serie chosenSerie;
	    int row = e.getFirstRow();
	    int column = e.getColumn();
	    if (column == MyDefaultTableModel.FAVORITOS) {
	        TableModel model = (TableModel) e.getSource();
	        Boolean checked = (Boolean) model.getValueAt(row, column);
	        if (checked) {
				try {
					chosenSerie = SeriesController.getSeries().rm(row);
					favController.getFavoritos().addFim(chosenSerie);
		        	JOptionPane.showMessageDialog(null, "A s�rie " + chosenSerie.getNome() + " foi adicionada aos favoritos.");
			    } catch (Exception e1) {
					e1.printStackTrace();
				}
	        } else {
				try {
					chosenSerie = favController.getFavoritos().rm(row);
					SeriesController.getSeries().addFim(chosenSerie);
		        	JOptionPane.showMessageDialog(null, "A s�rie " + chosenSerie.getNome() + " foi removida dos favoritos.");
			    } catch (Exception e1) {
					e1.printStackTrace();
				}
	        }
	    }
	}
}
