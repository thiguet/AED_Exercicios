package Controller;

import java.io.IOException;

import Model.ListaFlexivel;

public class FavoritosController {
	private ListaFlexivel favoritos;
	
	FavoritosController() {
		try {
			this.favoritos = LeitorDeArquivo.lerLinha("..\\Model\\Series.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private ListaFlexivel getStoredFavoritos() {
		
		
		return null;
	}

	public void adicionar() {
		
	}
	
}
