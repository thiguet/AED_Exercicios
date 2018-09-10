package GUI;

import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MyDefaultTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	
	public final static int NOME = 0;
	public final static int TIPO = 1;
	public final static int IDIOMA = 2;
	public final static int DURACAO = 3;
	public final static int TEMPORADAS = 4;
	public final static int EPISODIOS = 5;
	public final static int FAVORITOS = 6;
	
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
