package Model;

import java.util.Random;

import javax.swing.JOptionPane;

public class ListaFlexivel implements IDemandaExercicio {
	private Celula primeiro;
	private Celula ultimo;
	private int tamanho;

	public ListaFlexivel () {
		this.ultimo = this.primeiro = null;
		this.tamanho = 0;
	}

	public int getTamanho() {
		return tamanho;
	}
	
	public ListaFlexivel(Serie novaSerie) {
		this.primeiro = this.ultimo = new Celula(novaSerie);
		this.tamanho++;
	}
	
	public void addFim(Serie novaSerie) {
		Celula aux = new Celula(novaSerie);
		
		novaSerie.setId(this.tamanho + 1);	
		
		if(listaVazia()) {
			this.primeiro = this.ultimo = aux;
		} else {
			aux.setAnterior(this.ultimo);
			this.ultimo.setProximo(aux);
			
			this.ultimo = aux;
		}

		this.tamanho++;
	}

	public void addIni(Serie novaSerie) {
		Celula aux = new Celula(novaSerie);
		
		novaSerie.setId(this.tamanho + 1);
		
		if(listaVazia()) {
			this.primeiro = this.ultimo = aux;
			this.tamanho++;
		} else {
			aux.setProximo(this.primeiro);
			this.primeiro.setAnterior(aux);
			
			this.primeiro = aux;
			
			this.tamanho++;
		}
	}

	public void add(Serie novaSerie, int pos) throws Exception {
		Celula aux = new Celula(novaSerie);
		Celula cont;
		
		novaSerie.setId(this.tamanho + 1);
		
		if(pos == 0) {
			this.addIni(novaSerie);
		} else if(pos == this.tamanho) {
			this.addFim(novaSerie);
		} else {
			if(!posicaoExiste(pos)) 
				throw new Exception("A posição não existe !");
			
			cont = this.primeiro;
			
			while(pos > 0) {
				pos--;
				cont = cont.getProximo();
			}
			
			cont.getAnterior().setProximo(aux);
			cont.setAnterior(aux);
			
			aux.setAnterior(cont.getAnterior());
			aux.setProximo(cont);
			
			this.tamanho++;
		}
	}
		
	public Serie rmIni() throws Exception {
		if(listaVazia())
			throw new Exception("A lista está vazia !");
		
		Celula aux = this.primeiro;
		Serie serie = aux.getSerie();
		
		this.primeiro = this.primeiro.getProximo();
		
		if(this.primeiro == null) 
			this.primeiro = this.ultimo = null;
		else
			this.primeiro.setAnterior(null);
		
		aux = null;
		this.tamanho--;
		
		return serie;
	}

	public Serie rmFim() throws Exception {
		if(listaVazia())
			throw new Exception("A lista está vazia !");
		
		Celula aux = this.ultimo; 
		Serie serie = aux.getSerie();
		
		this.ultimo = this.ultimo.getAnterior();
		
		this.ultimo.setProximo(null);
		
		aux = null;
		this.tamanho--;
		
		return serie;
	}

	public Serie rm(int pos) throws Exception {
		if(listaVazia())
			throw new Exception("A lista está vazia !");
		
		if(!posicaoExiste(pos))
			throw new Exception("A posição é inválida !");
			
		Celula aux = this.primeiro; 
		Serie serie;
	
		while(aux != null && pos > 0 ) {
			aux = aux.getProximo();
			pos--;
		}
		
		if(aux == null) 
			throw new Exception("Não foi possível remover essa Série !");
		
		if(aux == this.primeiro) {
			aux = new Celula(this.rmIni());
		} else if(aux == this.ultimo) {
			aux = new Celula(this.rmFim());
		} else {
			aux.getAnterior().setProximo(aux.getProximo());
			aux.getProximo().setAnterior(aux.getAnterior());
			
			this.tamanho--;
		}
		
		serie = aux.getSerie();
		aux = null;
		
		return serie;
	}

	private boolean listaVazia() {
		return this.tamanho == 0;
	}

	private boolean posicaoExiste(int pos) {
		return ((pos >= 0) && (pos < tamanho));
	}

	public Serie getSerieByPos(int pos) throws Exception {
		Celula aux;
		
		if(!posicaoExiste(pos)) {
			throw new Exception("A posição informada não existe !");
		}
	
		aux = primeiro;
		for(int i = pos; i > 0; i--) {
			aux = aux.getProximo();
		}
		return aux.getSerie();
	}
	
	public Serie getSerieByName(String name) {
		Celula aux = primeiro;
		
		while( aux != null && 
			   !name.equals(aux.getSerie().getNome()) ) {
			aux = aux.getProximo();
		}
		
		return (aux == null) 
				? null
				: aux.getSerie();
	}
	
	public String getListToSaveInFile() {
		String str = "";
		
		Celula aux = this.primeiro;
		
		while(aux != null) {
			str += aux.getSerie().toFileFormat();
			aux = aux.getProximo();
		}
		
		return str;
	}
	
	@Override
	public String toString() {
		String str = "";
		
		Celula aux = this.primeiro;
		
		while(aux != null) {
			str += aux.getSerie().toString();
			aux = aux.getProximo();
		}
		
		return str;
	}

	@Override
	public void orderByMyOrdenation() {
		// Write that code boy
		
		Celula menor, aux2;
		
		int cont = 0;
		int menorPos = 0;
		
		try {
			for(int i = 0 ; i < this.tamanho ; i++)  {
				menor = this.primeiro;
				aux2 = null;
				
				menorPos = i;
				cont = i;
				
				while(cont > 0) {
					menor = menor.getProximo();
					cont--;
				}
				
				aux2 = menor;
				
				for(int j = i ; j < this.tamanho ; j++) {				
					int test = menor.getSerie().getNome().compareTo(aux2.getSerie().getNome());
					if(test > 0) {
						menorPos = j;
						menor = aux2;
					}				
					
					aux2 = aux2.getProximo();
				}
			
				this.add(this.rm(menorPos), i);
					
				menor = null;
			}
			
			this.fixIds();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void orderByRandom() {
		Random rand = new Random();
		int lucky = 0;
		for(int cont = this.tamanho / 2; cont > 0 ; cont--) {
			lucky = rand.nextInt(this.tamanho);
			
			try {
				this.addFim(this.rm(lucky));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		this.fixIds();
	}

	private void fixIds() {
		if(this.tamanho > 0) {
			for (int i = 0 ; i <= this.tamanho / 2 ; i++) {
				try {
					this.getSerieByPos(i).setId(i + 1);
					this.getSerieByPos(this.tamanho - i - 1).setId(this.tamanho - i);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void printList() {
		Celula aux = this.primeiro;
		
		while(aux != null) {
			JOptionPane.showMessageDialog(null, aux.getSerie().toString());
			aux = aux.getProximo();
		}
	}
}
