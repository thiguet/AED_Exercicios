package Controller;

import java.io.IOException;

import Model.ListaFlexivel;

public class SeriesController {

	private static ListaFlexivel series;
	
	public SeriesController() {
		try {
			String filePath = 
					System.getProperty("user.dir") + 
					"\\" + 
					"src" + 
					"\\" + 
					"Model" +
					"\\" + 
					"Series.txt";
			if(SeriesController.series == null)
				SeriesController.series = LeitorDeArquivo.lerLinha(filePath);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object[][] getSeriesInObjectType() {
		Object [][] series = SeriesController.series.getDataInRowFormat();
		Object [][] result = new Object [series.length][series[0].length + 1];
		
		for(int i = 0 ; i < series.length ; i++) {
			result[i][0] = series[i][0];
			result[i][1] = series[i][1];
			result[i][2] = series[i][2];
			result[i][3] = series[i][3];
			result[i][4] = series[i][4];
			result[i][5] = series[i][5];
			result[i][6] = Boolean.FALSE;
		}
		
		return result;
	}
	
	public static String getSeriesToString() {
		return SeriesController.series.toString();
	}
	
	public static ListaFlexivel getSeries() {
		return SeriesController.series;
	}
	
}
