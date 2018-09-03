package Model;

public class Serie {
    private String  nome,
    				tipo,
    				pais,
            		idioma,
            		emissora,
            		transmissao;
	private float   duracao;
    private int    	nroTemporadas,
    				nroEpisodios;
    	            
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
	
	public float getDuracao() {
		return duracao;
	}
	
	public void setDuracao(float duracao) {
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
   
}
