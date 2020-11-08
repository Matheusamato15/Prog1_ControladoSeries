package Modelo;

public class Serie {
	private String  nome;
	private String  produtora;
	private Integer avaliacao;
	private String numeroDeTemporadas;
	private String assistido;

	public Serie(String nome, String produtora, Integer avaliacao, String numeroDeTemporadas, String assistido) {
		super();
		this.nome = nome;
		this.produtora = produtora;
		this.avaliacao = avaliacao;
		this.numeroDeTemporadas = numeroDeTemporadas;
		this.assistido = assistido;
	}
	
	public Serie() {
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getProdutor() {
		return produtora;
	}
	
	public void setProdutor(String diretor) {
		this.produtora = diretor;
	}
	
	public Integer getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(int nota) {
		this.avaliacao = nota;
	}
	
	public String getNumeroDeTemporadas() {
		return numeroDeTemporadas;
	}
	
	public void setNumeroDeTemporadas(String numeroDeTemporadas) {
		this.numeroDeTemporadas = numeroDeTemporadas;
	}
	
	public String getAssistido() {
		return assistido;
	}
	
	public void setAssistido(String assistido) {
		this.assistido = assistido;
	}
	
	public String toString () {
		return "Nome da série: " + this.nome + "; Nome do diretor: " + this.produtora + "; Avaliação; " + this.avaliacao +
				"; Número de temporadas: " + this.numeroDeTemporadas + "; Assistido " + this.assistido + "\r\n";
	}
}
