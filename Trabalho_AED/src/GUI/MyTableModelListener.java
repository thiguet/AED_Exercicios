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
		seriesController = new SeriesController ();
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
    	Serie chosenSerie;
	    int row = e.getFirstRow();
	    int column = e.getColumn();
	    if (column == MyDefaultTableModel.FAVORITOS) {
	        TableModel model = (TableModel) e.getSource();
	        String columnName = model.getColumnName(column);
	        Boolean checked = (Boolean) model.getValueAt(row, column);
	        if (checked) {
				try {
					chosenSerie = seriesController.getSeries().rm(row);
					favController.getFavoritos().add(chosenSerie);
		        	JOptionPane.showMessageDialog(null, "A série " + chosenSerie.getNome() + " foi adicionada aos favoritos.");
			    } catch (Exception e1) {
					e1.printStackTrace();
				}
	        } else {
				try {
					chosenSerie = favController.getFavoritos().rm(row);
					seriesController.getSeries().add(chosenSerie);
		        	JOptionPane.showMessageDialog(null, "A série " + chosenSerie.getNome() + " foi removida dos favoritos.");
			    } catch (Exception e1) {
					e1.printStackTrace();
				}
	        }
	    }
	}
}
