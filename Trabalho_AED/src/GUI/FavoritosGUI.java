package GUI;

import javax.swing.JOptionPane;

import Controller.FavoritosController;
import Controller.SeriesController;
import Model.Serie;

public class FavoritosGUI extends GridGUI {
	private static final long serialVersionUID = 1L;
	
	FavoritosGUI() {
		super(FavoritosController.getLista());
	}

	@Override
	public void checkedEvent(int row) throws Exception {
		Serie favoritada = FavoritosController.removeSerie(row);
		
		SeriesController.addNewSerie(favoritada);
		
		this.removeRow(row);
		
		JOptionPane.showMessageDialog(null, "A série " + favoritada.getNome() + " foi removida dos favoritos.");
	}	
	
}
