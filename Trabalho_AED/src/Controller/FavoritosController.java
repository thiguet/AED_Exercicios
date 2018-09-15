package Controller;

import Model.ListaFlexivel;
import Model.Serie;

public class FavoritosController {	
	private static ListaFlexivel lista = new ListaFlexivel ();	;
	
	public FavoritosController() {
		super();
	}

	public static void moveToOtherList(ListaFlexivel lista, int row) {
		try {
			lista.addFim(FavoritosController.lista.rm(row));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addNewSerie(Serie novaSerie) {
		FavoritosController.lista.addFim(novaSerie);
	}
	
	public static Serie removeSerie(int row) throws Exception {
		return FavoritosController.lista.rm(row);
	}

	public static ListaFlexivel getLista() {
		return FavoritosController.lista;
	}
}
