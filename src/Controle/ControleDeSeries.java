/*--------------------
	Esta classe controla todas as ações de adicionar e remover séries
---------------------*/

package Controle;

import java.util.ArrayList;
import Modelo.Serie;
import Persistencia.Arquivo;

public class ControleDeSeries {
	
	public ArrayList <Serie> listaDeSeries = new ArrayList<Serie>();
	Serie serie = new Serie();

	//---------------------------------
	
	public Serie geraSerieParaClasseSerie (String nomeSerie, String nomeDiretor, int classificacao, String numeroTemporadas, String seAssistido) {
		serie.setNome(nomeSerie);
		serie.setProdutor(nomeDiretor);
		serie.setAvaliacao(classificacao);
		serie.setNumeroDeTemporadas(numeroTemporadas);
		serie.setAssistido(seAssistido);
		
		return serie;
	}
	
	public boolean adicionaSerie (Serie serie) {
		listaDeSeries.add(serie);
		if (Arquivo.gravar("arquivo_de_séries.mae", serie)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void gravarNoArquivo (String caminho, Serie serie) {
		Arquivo.gravar(caminho, serie);
	}
	
	public ArrayList<Serie> lerArquivo (String caminho) {
		ArrayList<Serie> listaSeries = new ArrayList<Serie>();
		listaSeries = Arquivo.ler(caminho);
		
		return listaSeries;
	}
	
	public void apagarArquivo () {
		Arquivo.apagarArquivo();
	}
	
	public int checaSeSerieExiste (String nome) {
		for (int j=0; j<lerArquivo("arquivo_de_séries.mae").size(); j++) {
			if (nome.equalsIgnoreCase(lerArquivo("arquivo_de_séries.mae").get(j).getNome())) {
				return j;
			}
		}

		return -1;
	}

	public ArrayList<Serie> getListaDeSeries() {
		return listaDeSeries;
	}
	
	public void atualizar(int linha, Serie s) {
		ArrayList<Serie> listaSerie = new ArrayList<Serie>();
		listaSerie = lerArquivo("arquivo_de_séries.mae");
		
		listaSerie.get(linha).setNome(s.getNome()); 
		listaSerie.get(linha).setProdutor(s.getProdutor()); 
		listaSerie.get(linha).setAvaliacao(s.getAvaliacao()); 
		listaSerie.get(linha).setNumeroDeTemporadas(s.getNumeroDeTemporadas()); 
		listaSerie.get(linha).setAssistido(s.getAssistido()); 
		
		apagarArquivo();
		for (int i=0; i<listaSerie.size(); i++) {
			gravarNoArquivo("arquivo_de_séries.mae", listaSerie.get(i));
		}
	}
}
