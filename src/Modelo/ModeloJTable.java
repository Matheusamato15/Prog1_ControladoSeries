package Modelo;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModeloJTable extends AbstractTableModel{

	
	//fazer construtor da classe
	private String [] colunas = {"Nome", "Produtora", "Pontuação", "Nº de temporadas", "Já assisti?"};
	private ArrayList<Serie> listaDeSeries = new ArrayList<Serie>();
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return listaDeSeries.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
			case 0: 
				return listaDeSeries.get(linha).getNome();
			case 1:
				return listaDeSeries.get(linha).getProdutor();
			case 2:
				return listaDeSeries.get(linha).getAvaliacao();
			case 3:
				return listaDeSeries.get(linha).getNumeroDeTemporadas();
			case 4:
				return listaDeSeries.get(linha).getAssistido();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int coluna) {
		return colunas[coluna];
	}
	
	public void adicionarLinha (Serie s) {
		this.listaDeSeries.add(s);
	}
	
	public Serie obterLinha(int linha) {
		return this.listaDeSeries.get(linha);
	}
}
