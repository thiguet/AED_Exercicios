package Controller;

import java.io.IOException;

import Model.ListaFlexivel;

public class SeriesController {

	private ListaFlexivel series;
	
	public SeriesController() {}
	
	public void getArquivos () {
	
		try {
			series = LeitorDeArquivo.lerLinha("C:\\Desktop");
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
