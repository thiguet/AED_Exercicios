package GUI;

import javax.swing.JOptionPane;

import Model.Serie;

public class SeriesGUI extends GridGUI {
	
	private static final long serialVersionUID = 3L;
	
	public SeriesGUI () {
		super(GridGUI.seriesController.getListInObjectFormat());
	}

	@Override
	public void checkedEvent(int row) throws Exception {
		Serie favoritada = GridGUI.seriesController.removeSerie(row);
		
		GridGUI.favsController.addNewSerie(favoritada);
		
		this.removeRow(row);
		
		JOptionPane.showMessageDialog(null, "A série " + favoritada.getNome() + " foi adicionada aos favoritos.");
	}
}
