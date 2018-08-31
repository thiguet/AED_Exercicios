import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class LeitorDeArquivo {
	
	// private static LeitorDeArquivo leitorArq = new LeitorDeArquivo ();
	
	private static File arq;
	
	private LeitorDeArquivo() {}
	
	/*
	public LeitorDeArquivo getInstance() {
		return leitorArq;
	}
	*/
	
	public static String[] lerLinha(String diretorioArq) throws IOException {
		File arq = new File(diretorioArq);
		String resultado [] = null; 
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(arq), "ISO-8859-1"));
	
		String linha = null;
		
		linha = buff.readLine();
		
		while (linha != null) {
			linha = buff.readLine();
			String campos [] = linha.split(";");
			System.out.println(campos[0]);
		}
		
		buff.close();
		
		return resultado;
	}
	
	
}
