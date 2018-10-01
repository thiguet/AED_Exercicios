package Controller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import Model.ListaFlexivel;
import Model.Serie;

public class LeitorDeArquivo {
	private static ListaFlexivel listaSeries;
	
	private LeitorDeArquivo() {}
	
	public static ListaFlexivel lerLinha(String fileName) throws IOException {
		File arq = new File(fileName);
		LeitorDeArquivo.listaSeries = new ListaFlexivel();
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(arq) 
				,"UTF-8"
				));
	
		String linha = null;
		
		linha = buff.readLine();
		
		while (linha != null) {
			String campos [] = linha.split(";");
			LeitorDeArquivo.listaSeries.addFim( LeitorDeArquivo.getSerie(campos) );
			linha = buff.readLine();
		}
		
		buff.close();
		
		return listaSeries;
	}
	
	public static Serie getSerie(String[] linha) {
		Serie novaSerie = new Serie();
		
		novaSerie.setId(LeitorDeArquivo.listaSeries.getTamanho() + 1);
		
		if (linha.length > 0)
			novaSerie.setNome(linha[0] );
		if (linha.length > 1)
			novaSerie.setTipo(linha[1]);
		if (linha.length > 2)
			novaSerie.setDuracao(linha[2]);
		if (linha.length > 3)
			novaSerie.setPais(linha[3]);
		if (linha.length > 4)
			novaSerie.setIdioma(linha[4]);
		if (linha.length > 5)
			novaSerie.setEmissora(linha[5]);
		if (linha.length > 6)
			novaSerie.setTransmissao(linha[6]);
		if (linha.length > 7)
			novaSerie.setNroTemporadas(Integer.parseInt(linha[7].trim()));
		if (linha.length > 8)
			novaSerie.setNroEpisodios(Integer.parseInt(linha[8].trim()));
		
		return novaSerie;
	}
	
	public void saveLista(ListaFlexivel lista, String fileName) {
		String fileContents = "";
		
		fileContents += lista.toString();

		try {
			File arq = new File(fileName);
			LeitorDeArquivo.listaSeries = new ListaFlexivel();
					
			if(!arq.exists()) {
				arq.createNewFile();
			}
			
			BufferedWriter bw = new BufferedWriter(new PrintWriter(new FileWriter(arq, true)));
				
			bw.write(fileContents);
		
			bw.close();
		} catch (IOException e) {
			
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
