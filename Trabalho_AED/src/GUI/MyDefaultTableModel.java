package GUI;

import javax.swing.table.DefaultTableModel;

public class MyDefaultTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	
	private final static int NOME = 0;
	private final static int TIPO = 1;
	private final static int IDIOMA = 2;
	private final static int DURACAO = 3;
	private final static int TEMPORADAS = 4;
	private final static int EPISODIOS = 5;
	private final static int FAVORITOS = 6;
	
	public MyDefaultTableModel(Object[][] seriesInObjectType, Object[] objects) {
		super(seriesInObjectType, objects);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
	    switch (columnIndex) {
		    case NOME:
		        return String.class;
		    case TIPO:
		    	return String.class;
		    case IDIOMA:
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
		        throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    }
	}	
}
