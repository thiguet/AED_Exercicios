package Controller;

import Model.ListaFlexivel;

public class FavoritosController {
	private static ListaFlexivel favoritos = new ListaFlexivel();
	
	public FavoritosController() {}

	public ListaFlexivel getFavoritos() {
		return favoritos;
	}

}
