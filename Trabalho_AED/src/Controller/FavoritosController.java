package Controller;

import Model.ListaFlexivel;

public class FavoritosController {
	private ListaFlexivel favoritos;
	
	FavoritosController() {
		initializeFavoritos();
	}
		
	private void initializeFavoritos() {
		// Read from a file +
		this.favoritos = getStoredFavoritos();
	}



	private ListaFlexivel getStoredFavoritos() {
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	public void adicionar() {
		
	}
	
}
