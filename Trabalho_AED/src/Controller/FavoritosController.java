package Controller;

import Model.ListaFlexivel;

public class FavoritosController {
	private static ListaFlexivel favoritos;
	
	public FavoritosController() {
		this.favoritos = new ListaFlexivel();
	}

	public ListaFlexivel getFavoritos() {
		return favoritos;
	}

}
