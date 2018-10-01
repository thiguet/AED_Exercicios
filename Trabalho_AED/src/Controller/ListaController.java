package Controller;

import java.io.IOException;

import Model.ListaFlexivel;
import Model.Serie;

public abstract class ListaController {
	protected ListaFlexivel lista;
	protected String filePath;
	
	ListaController () {
		setLista(new ListaFlexivel ());
	}

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
			this.lista = LeitorDeArquivo.lerLinha(this.filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object[][] getListInObjectFormat() {	
		Object[][] data = new Object[this.lista.getTamanho()][11];
		
		Object[] aux;
		
		for(int i = 0 ; i < this.lista.getTamanho() ; i++) {
			try {
				aux = this.lista.getSerie(i).toObject();
				
				data[i][0] = aux[0];
				data[i][1] = aux[1];
				data[i][2] = aux[2];
				data[i][3] = aux[3];
				data[i][4] = aux[4];
				data[i][5] = aux[5];
				data[i][6] = aux[6];
				data[i][7] = aux[7];
				data[i][8] = aux[8];
				data[i][9] = aux[9];
				data[i][10] = Boolean.FALSE;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return data;
	}
	
	public void moveToOtherList(ListaFlexivel lista, int row) {
		try {
			lista.addFim(this.lista.rm(row));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getSerieToString(int cod) {
		Serie escolhida = this.lista.getSerieById(cod);
		return (escolhida == null) 
					? null : escolhida.toString();
	}
}
