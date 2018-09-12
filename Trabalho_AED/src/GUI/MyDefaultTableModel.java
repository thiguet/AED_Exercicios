package GUI;

import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MyDefaultTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	
	public final static int ID = 0;
	public final static int NOME = 1;
	public final static int TIPO = 2;
	public final static int IDIOMA = 3;
	public final static int DURACAO = 4;
	public final static int TEMPORADAS = 5;
	public final static int EPISODIOS = 6;
	public final static int FAVORITOS = 7;
	
	public MyDefaultTableModel(Object[][] seriesInObjectType, Object[] objects) {
		super(seriesInObjectType, objects);
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
