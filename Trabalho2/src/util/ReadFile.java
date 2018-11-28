package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class ReadFile implements IReadFile {
	private static final String defaultFilePath = System.getProperty("user.dir") + "\\data\\";
	private String filePath;
	private final String VALID_WORD_PATTERN = "^\\p{L}{1,20}$";	
	private final String DIVIDE_WORDS_PATTERN = "(\\s+|[^\\p{L}])";
	
	public ReadFile(String fileName) {
		filePath = ReadFile.defaultFilePath + fileName; 
	}
	
	@Override
	public List<String> getFileContents() {
		List<String> result = new ArrayList<String> ();
		String str,
			   aux[]; 
		try {

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.filePath), "UTF-8"));
			
			while ( (str = bufferedReader.readLine()) != null) {
				aux = str.split(DIVIDE_WORDS_PATTERN);
				
				for(int i = 0 ; i < aux.length ; i++) {
					if(aux[i].matches(VALID_WORD_PATTERN))
						// Only lower case it's available
						result.add(aux[i].toLowerCase()); 
				}
			}
			
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
