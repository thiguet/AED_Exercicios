import util.IReadFile;
import util.ReadFile;
import java.util.List;

public abstract class AbstractSearch implements Search {
	protected int nrKeysCompared;
	protected int nrAttrNeeded;
	protected IReadFile fileManager;
	
	AbstractSearch(String fileName) {
		this.nrAttrNeeded = 0;
		this.nrKeysCompared = 0;
		this.fileManager = new ReadFile(fileName);
	}
	
	public int getNrKeysCompared() {
		return nrKeysCompared;
	}

	public void setNrKeysCompared( int nrKeysCompared) {
		this.nrKeysCompared = nrKeysCompared;
	}

	public void plusKeysCompared() {
		this.nrKeysCompared++;
	}

	public int getNrAttrNeeded() {
		return nrAttrNeeded;
	}

	public void setNrAttrNeeded() {
		this.nrAttrNeeded++;
	}
	
	public void run() {
		List<String> content = this.fileManager.getFileContents();
		this.add(content);
		this.alphabeticalPrint();
	}
	
	/*
	 * Coloque  contadores  no  seu  programa  para  determinar  o  número  de  comparações  de  chaves  e  atribuições  de registros  
	 * necessárias  para  montar  a  tabela  de  frequências  em  cada  uma  das  estruturas  acima.
	 * 
	 * Calcule  também  o  tempo  que  cada  estrutura  leva  apara  montar  a  tabela.  
	 * Análise  através dos  dados  coletados  o  desempenho  /  eficiência  de  cada  estrutura.
	 */
}
