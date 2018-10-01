package GUI;

import javax.swing.JOptionPane;

import Model.Serie;

public class FavoritosGUI extends GridGUI {
	
	private static final long serialVersionUID = 1L;
	
	FavoritosGUI() {
		super(GridGUI.favsController.getListInObjectFormat());
	}

	@Override
	public void checkedEvent(int row) throws Exception {
		Serie favoritada = GridGUI.favsController.removeSerie(row);
		
		GridGUI.seriesController.addNewSerie(favoritada);
		
		this.removeRow(row);
		
		GridGUI.favsController.saveListInFile();
		GridGUI.seriesController.saveListInFile();
		
		JOptionPane.showMessageDialog(null, "A série " + favoritada.getNome() + " foi removida dos favoritos.");
	}
}
