package Visao;

import java.awt.Toolkit;

import javax.swing.JComboBox;
import Controle.ControleDeSeries;
import Modelo.Serie;

@SuppressWarnings("serial")
public class PainelDeAtualizacao extends PainelInserir{
	
	ControleDeSeries controle = new ControleDeSeries();
	PainelVisualizar painelVisualizar = new PainelVisualizar();
	ConteudoTelaInserir conteudoTelaInserir = new ConteudoTelaInserir();
	
	
	
	 public PainelDeAtualizacao(Serie serie) {
		 setIconImage(Toolkit.getDefaultToolkit().getImage("Arquivos\\liano.jpg"));
		 
		 
		setTitle("Tela de edição!");
		setTitulo("Tela de edição!");
		
		conteudoInserir.getNomeDaSerie().setText(serie.getNome());
		conteudoInserir.getNomeDaProdutora().setText(serie.getProdutor());
		conteudoInserir.getComboBoxNota().setSelectedIndex(getIndex(conteudoInserir.getComboBoxNota(), serie.getAvaliacao().toString()));
		conteudoInserir.getComboBoxTemporadas().setSelectedIndex(getIndex(conteudoInserir.getComboBoxTemporadas(), serie.getNumeroDeTemporadas()));
		conteudoInserir.getComboBoxAssistido().setSelectedIndex(getIndex(conteudoInserir.getComboBoxAssistido(), serie.getAssistido()));
	
		conteudoInserir.setNumeroLinhaEdicao(controle.checaSeSerieExiste(conteudoInserir.getNomeDaSerie().getText()));
		conteudoInserir.setEstadoBotaoGravar(2);

	 }
	
	//ESTE MÉTODO RETORNA O INDEX DOS COMBOBOX
	public int getIndex(JComboBox<String> box, String texto) {
		for(int i = 0; i < box.getModel().getSize(); i++) {
			if(texto.equalsIgnoreCase((String) box.getSelectedItem())) {
				return box.getSelectedIndex();
			}
			box.setSelectedIndex(i+1);
		}

		return 0;
	}
}
