package Model;

import javax.swing.table.DefaultTableModel;

public class MyDefaultTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 2L;
	private static Object [] colunas = new Object [] {"Cod.","Nome","Tipo","Pa�s","Idioma","Emissora","Transmiss�o","Dura��o","Temporadas","Epis�dios","Favoritos"};
	
	public final static int ID = 0;
	public final static int NOME = 1;
	public final static int TIPO = 2;
	public final static int PAIS = 3;
	public final static int IDIOMA = 4;
	public final static int EMISSORA = 5;
	public final static int TRANSMISSAO = 6;
	public final static int DURACAO = 7;
	public final static int TEMPORADAS = 8;
	public final static int EPISODIOS = 9;
	public final static int FAVORITOS = 10;
	
	public MyDefaultTableModel(Object[][] seriesInObjectType) {
		super(seriesInObjectType, colunas);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
	    switch (columnIndex) {
		    case ID:
		        return Integer.class;
		    case NOME:
		        return String.class;
		    case TIPO:
		    	return String.class;
		    case PAIS:
		    	return String.class;
		    case IDIOMA:
		    	return String.class;
		    case EMISSORA:
		    	return String.class;
		    case TRANSMISSAO:
		    	return String.class;
		    case DURACAO:
		    	return String.class;
		    case TEMPORADAS:
		    	return Integer.class;
		    case EPISODIOS:
		    	return Integer.class;
		    case FAVORITOS:
		    	return Boolean.class;
		    default:
		        throw new IndexOutOfBoundsException("Essa coluna n�o existe !");
	    }
	}	
}
