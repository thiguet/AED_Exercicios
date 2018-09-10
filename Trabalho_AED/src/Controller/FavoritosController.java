package Controller;

import Model.ListaFlexivel;

public class FavoritosController {
	private static ListaFlexivel favoritos;
	
	FavoritosController() {}

	public ListaFlexivel getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(ListaFlexivel favoritos) {
		this.favoritos = favoritos;
	}
	
}
