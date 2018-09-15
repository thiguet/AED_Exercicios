package GUI;

import javax.swing.JOptionPane;

import Controller.FavoritosController;
import Controller.SeriesController;
import Model.Serie;

public class SeriesGUI extends GridGUI {
	
	private static final long serialVersionUID = 1L;
	
	public SeriesGUI () {
		super(SeriesController.getLista());
	}

	@Override
	public void checkedEvent(int row) throws Exception {
		// TODO Auto-generated method stub
		Serie favoritada = SeriesController.removeSerie(row);
		
		FavoritosController.addNewSerie(favoritada);
		
		this.removeRow(row);
		
		JOptionPane.showMessageDialog(null, "A série " + favoritada.getNome() + " foi adicionada aos favoritos.");
	}

}
