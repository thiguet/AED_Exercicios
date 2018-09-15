package GUI;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Model.MyDefaultTableModel;

public class MyTableModelListener implements TableModelListener {
	GridGUI responsableGUI;
	
	MyTableModelListener (GridGUI ele) {
		super();
		this.responsableGUI = ele;
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
	    if (e.getColumn() == MyDefaultTableModel.FAVORITOS)
	    	handleFavoritosColumnEvent(e);
	}

	private void handleFavoritosColumnEvent(TableModelEvent e) {
	    
		TableModel model = (TableModel) e.getSource();
        Boolean checked = (Boolean) model.getValueAt(e.getFirstRow(), e.getColumn());
        
        try { 
	        if (checked) {
	        	this.responsableGUI.checkedEvent(e.getFirstRow());
	        }
        } catch (Exception exc) {
        	exc.printStackTrace();
    	}
    }
}
