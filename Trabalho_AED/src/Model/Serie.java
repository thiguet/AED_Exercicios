package Model;

public class Serie {
	private int id;

	private String  nome,
    				tipo,
    				pais,
            		idioma,
            		emissora,
            		transmissao,
            		duracao;
	
    private int    	nroTemporadas,
    				nroEpisodios;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	        
    
    public String getNome() {
		return nome;
	}
    
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getIdioma() {
		return idioma;
	}
	
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String getEmissora() {
		return emissora;
	}
	
	public void setEmissora(String emissora) {
		this.emissora = emissora;
	}
	
	public String getTransmissao() {
		return transmissao;
	}
	
	public void setTransmissao(String transmissao) {
		this.transmissao = transmissao;
	}
	
	public String getDuracao() {
		return duracao;
	}
	
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
	public int getNroTemporadas() {
		return nroTemporadas;
	}
	
	public void setNroTemporadas(int nroTemporadas) {
		this.nroTemporadas = nroTemporadas;
	}
	
	public int getNroEpisodios() {
		return nroEpisodios;
	}
	
	public void setNroEpisodios(int nroEpisodios) {
		this.nroEpisodios = nroEpisodios;
	}
	
	@Override
	public String toString() {
		return  this.nome + "\n" +
				this.tipo + "\n" +
				this.pais + "\n" +
        		this.idioma + "\n" +
        		this.emissora + "\n" +
        		this.transmissao + "\n" +
        		this.duracao + "\n" +
				this.nroTemporadas + "\n" +
				this.nroEpisodios + "\n" + "\n";
	}

	public Object[] toObject() {
		Object[] obj = new Object[9];

		obj[0] = this.id;
		obj[1] = this.nome;
		obj[2] = this.tipo;
		//obj[3] = this.pais;
		obj[3] = this.idioma;
		//obj[5] = this.emissora;
		//obj[6] = this.transmissao;
		obj[4] = this.duracao;
		obj[5] = this.nroTemporadas;
		obj[6] = this.nroEpisodios;
		
		return obj;
	}
   
}
