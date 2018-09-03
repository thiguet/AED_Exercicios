package GUI;

import javax.swing.JLabel;

public class GridLineGUI {

	JLabel idSerie,
		   nome;

	GridLineGUI() {
		idSerie = new JLabel();
		nome = new JLabel();
	}

	public String getNome() {
		return nome.getText();
	}

	public void setNome(String nome) {
		this.nome.setText(nome);
	}

	public String getIdSerie() {
		return idSerie.getText();
	}

	public void setIdSerie(String idSerie) {
		this.idSerie.setText(idSerie);
	}

}
