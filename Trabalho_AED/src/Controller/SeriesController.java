package Controller;

public class SeriesController extends ListaController {
	private final static String seriesFilePath = System.getProperty("user.dir") + 
												"\\" + 
												"src" + 
												"\\" + 
												"Model" +
												"\\" + 
												"Series.txt";
	
	public SeriesController() {
		super();
		this.filePath = SeriesController.seriesFilePath;
		this.getListFromFile();
	}
}
