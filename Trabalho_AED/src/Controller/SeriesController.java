package Controller;

import java.io.IOException;

import Model.ListaFlexivel;

public class SeriesController {

	private ListaFlexivel series;
	
	public SeriesController() {
		try {
			this.series = LeitorDeArquivo.lerLinha("C:\\Users\\1117019\\Documents\\AED_Exercicios\\Trabalho_AED\\bin\\Model\\Series.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getSeries() {
		System.out.print(this.series.toString());
		return null;
	}
}
