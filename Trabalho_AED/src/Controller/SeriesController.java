package Controller;

import java.io.IOException;

import Model.ListaFlexivel;
import Model.Serie;

public class SeriesController {
	protected static ListaFlexivel lista;
	
	public SeriesController() {
		super();
	}
	
	public static ListaFlexivel getLista() {
		SeriesController.initializeLista();
		return SeriesController.lista;
	}
	
	private static ListaFlexivel getSeriesFromFile() {
		ListaFlexivel lista = null;

		try {
			String filePath = 
					System.getProperty("user.dir") + 
					"\\" + 
					"src" + 
					"\\" + 
					"Model" +
					"\\" + 
					"Series.txt";
			
			lista = LeitorDeArquivo.lerLinha(filePath);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public static void addNewSerie(Serie novaSerie) {
		SeriesController.lista.addFim(novaSerie);
	}
	
	public static Serie removeSerie(int row) throws Exception {
		return SeriesController.lista.rm(row);
	}

	public static void initializeLista() {
		if(SeriesController.lista == null)
			SeriesController.lista = SeriesController.getSeriesFromFile();	
	}
}
