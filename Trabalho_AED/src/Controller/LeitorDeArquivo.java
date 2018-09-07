package Controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import Model.ListaFlexivel;
import Model.Serie;

public class LeitorDeArquivo {
	
	private LeitorDeArquivo() {}
	
	public static ListaFlexivel lerLinha(String diretorioArq) throws IOException {
		File arq = new File(diretorioArq);
		ListaFlexivel listaSeries = new ListaFlexivel();
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(arq), "ISO-8859-1"));
	
		String linha = null;
		
		linha = buff.readLine();
		
		while (linha != null) {
			linha = buff.readLine();
			String campos [] = linha.split(";");
			listaSeries.add( LeitorDeArquivo.getSerie(campos) );
		}
		
		buff.close();
		
		return listaSeries;
	}
	

	public static Serie getSerie(String[] linha) {
		Serie novaSerie = new Serie();

		novaSerie.setNome(linha[0]);
		novaSerie.setTipo(linha[1]);
		novaSerie.setDuracao(linha[2]);
		novaSerie.setPais(linha[3]);
		novaSerie.setIdioma(linha[4]);
		novaSerie.setEmissora(linha[5]);
		novaSerie.setTransmissao(linha[6]);
		novaSerie.setNroTemporadas(Integer.parseInt(linha[7].trim()));
		novaSerie.setNroEpisodios(Integer.parseInt(linha[8].trim()));
		
		return novaSerie;
	}
	
	
}
