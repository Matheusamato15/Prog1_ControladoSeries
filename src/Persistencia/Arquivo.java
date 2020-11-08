package Persistencia;

import java.io.*;
import java.util.ArrayList;

import Controle.ControleDeSeries;
import Modelo.Serie;
public class Arquivo {

	static ControleDeSeries controleSeries = new ControleDeSeries();
	
	public static ArrayList<Serie> ler (String caminho) {
		ArrayList<Serie> conteudo =  new ArrayList<Serie>();
		String linha = new String();
		
		try {
			FileReader arquivo = new FileReader(caminho);
			BufferedReader lerArquivo = new BufferedReader(arquivo);
			try {	
				while((linha = lerArquivo.readLine()) != null) {
					Serie s = new Serie();
					
					String[] linhaDividida = linha.split(";");
					
					s.setNome(linhaDividida[0]);
					s.setProdutor(linhaDividida[1]);
					s.setAvaliacao(Integer.parseInt(linhaDividida[2]));
					s.setNumeroDeTemporadas(linhaDividida[3]);
					s.setAssistido(linhaDividida[4]);

					conteudo.add(s);
					
				} 
				lerArquivo.close();
				
			} catch (IOException e) {
				
			}
		}catch (FileNotFoundException e) {
			
		}
		
		return conteudo;
	}
	
	public static boolean gravar (String caminho, Serie s) {		
		try {
			FileWriter  arquivo   = new FileWriter(caminho, true);
			PrintWriter gravarArq = new PrintWriter(arquivo, true);
			
			gravarArq.println(s.getNome() + ";" + s.getProdutor() + ";" + s.getAvaliacao() + ";" + s.getNumeroDeTemporadas() + ";" + s.getAssistido());
			
			gravarArq.close();
			return true;
		}catch(IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static void apagarArquivo () {
		File arquivo = new File("arquivo_de_séries.mae");
		arquivo.delete();
	}
}
