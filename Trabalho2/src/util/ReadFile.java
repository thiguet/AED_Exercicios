package util;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ReadFile implements IReadFile {
	private static final String defaultFilePath = System.getProperty("user.dir") + "\\dist\\data\\";
	private String filePath;
	private final String VALID_WORD_PATTERN = "/^\\w{1,20}$/g";	
	private final String DIVIDE_WORDS_PATTERN = "/(\\s+|\\W)|(\\w{1,20})/g";
	
	public ReadFile(String fileName) {
		filePath = ReadFile.defaultFilePath + fileName; 
	}
	
	@Override
	public List<String> getFileContents() {
		List<String> result = new ArrayList<String> ();
		String str,
			   aux[]; 
		try {
			DataInputStream entrada = new DataInputStream(new FileInputStream(filePath));
		
			while ((entrada.available() > 0) && (str = entrada.readUTF()) != null) {
				aux = str.split(DIVIDE_WORDS_PATTERN);
				
				for(int i = 0 ; i < aux.length ; i++) {
					if(!aux[i].matches(VALID_WORD_PATTERN))
						// Only lower case it's available
						result.add(aux[i].toLowerCase()); 
				}
			}
			
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
