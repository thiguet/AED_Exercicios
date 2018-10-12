package Controller;

import java.io.IOException;

import ListaFlexivel;
import Model.Serie;

public abstract class ListaController {
	protected ListaFlexivel lista;
	protected String filePath;
	
	ListaController () {}

	public ListaFlexivel getLista() {
		return lista;
	}

	public void setLista(ListaFlexivel lista) {
		this.lista = lista;
	}
	
	public void addNewSerie(Serie novaSerie) {
		this.lista.addFim(novaSerie);
	}
	
	public Serie removeSerie(int row) throws Exception {
		return this.lista.rm(row);
	}
	
	protected void getListFromFile() {
		try {
			this.lista = LeitorDeArquivo.getSeriesListFromFile(this.filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveListInFile() {
		LeitorDeArquivo.saveLista(this.lista, this.filePath);
	}
	
	public Object[][] getListInObjectFormat() {	
		Object[][] data = new Object[this.lista.getTamanho()][11];
		
		Object[] aux;
		
		for(int pos = 0 ; pos < this.lista.getTamanho() ; pos++) {
			try {
				aux = this.lista.getSerieByPos(pos).toObject();
				
				data[pos][0] = aux[0];
				data[pos][1] = aux[1];
				data[pos][2] = aux[2];
				data[pos][3] = aux[3];
				data[pos][4] = aux[4];
				data[pos][5] = aux[5];
				data[pos][6] = aux[6];
				data[pos][7] = aux[7];
				data[pos][8] = aux[8];
				data[pos][9] = aux[9];
				data[pos][10] = Boolean.FALSE;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}

	public String getSerieToString(String name) {
		Serie escolhida = (this.lista.getSerieByName(name));
		
		return (escolhida == null) 
					? null 
					: escolhida.toString();
	}
	

	public void orderByRandom() {
		this.lista.orderByRandom();
	}
	
	public void orderByMyOrdenation() {
		this.lista.orderByMyOrdenation();
	}

}
