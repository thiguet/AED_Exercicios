package Controller;

public class FavoritosController extends ListaController {	
	private static String favsFilePath = System.getProperty("user.dir") + 
											"\\" + 
											"src" + 
											"\\" + 
											"Model" +
											"\\" + 
											"Favoritos.txt";

	
	public FavoritosController() {
		super();
		this.filePath = FavoritosController.favsFilePath;
	}

}
