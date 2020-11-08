package Visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controle.ControleDeSeries;
import Modelo.Serie;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class ConteudoTelaInserir extends JPanel {

	
	///////////////////////////////////////////////TIRAR
	
	private JTextField        nomeDaSerie;
	private JTextField        nomeDaProdutora;
	private JComboBox<String> comboBoxTemporadas;
	private JComboBox<String> comboBoxNota;
	private JComboBox<String> comboBoxAssistido;
	private ControleDeSeries  controladorSeries;
	private ApresentacaoTexto acao;
	public  int estadoBotaoGravar = 1;
	private int numeroLinhaEdicao;	
	
	public  ConteudoTelaInserir() {

		
		
		//-------------------------------------------
			
			acao              = new ApresentacaoTexto();
			controladorSeries = new ControleDeSeries();	
						
		/*-------------------------
		 * --JPANEL--
		 * ------------------------*/

			layoutPainelPrincipal();
			
			//DADOS
			JPanel painelDados = new JPanel();
			add(painelDados, BorderLayout.NORTH);
			painelDados.setLayout(new MigLayout("", "[][55.00,grow][grow][][fill][fill][fill][fill][fill][27.00][]", "[][][][fill][]"));
			
			//BOTÕES
			JPanel painelBotoes = new JPanel();
			add(painelBotoes, BorderLayout.SOUTH);
			painelBotoes.setLayout(new MigLayout("", "[][][][][][][][][][][][][]", "[]"));
			
		/*------------------------*/
			
			
			
		/*-------------------------
		 * --JLABEL--
		 * ------------------------*/
		
			//TÍTULO
			JLabel labelTitulo = new JLabel("Título:");
			painelDados.add(labelTitulo, "cell 0 0,alignx left");
			labelTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		
			//DIRETOR
			JLabel labelProdutora = new JLabel("Produtora:");
			painelDados.add(labelProdutora, "cell 0 1,alignx left");
			labelProdutora.setHorizontalAlignment(SwingConstants.LEFT);
			
			//TEMPORADAS
			JLabel labelTemporadas = new JLabel("Temporadas: ");
			painelDados.add(labelTemporadas, "cell 0 2,alignx left");
			
			//AVALIAÇÃO
			JLabel labelAvaliacao = new JLabel("Avaliação: ");
			painelDados.add(labelAvaliacao, "cell 0 3,alignx left");
			
			//ASSISTIDO???
			JLabel labelAssistido = new JLabel("Já assisti?");
			painelDados.add(labelAssistido, "cell 0 4,alignx left");
			
		/*------------------------*/
			
			
			
			
		/*-------------------------
		 * --JTEXTFIELD--
		 * ------------------------*/
			
			//NOME DA SÉRIE
			nomeDaSerie = new JTextField();
			nomeDaSerie.setText("Digite o nome da série");
			nomeDaSerie.setForeground(Color.GRAY);
			painelDados.add(nomeDaSerie, "cell 1 0 9 1,growx");
			acao.limpaTextoMouse(nomeDaSerie);

			//NOME DO DIRETOR
			nomeDaProdutora = new JTextField();
			nomeDaProdutora.setForeground(Color.GRAY);
			nomeDaProdutora.setText("Digite o nome da produtora");
			painelDados.add(nomeDaProdutora, "cell 1 1 9 1,growx");
			acao.limpaTextoMouse(nomeDaProdutora);
			
		/*------------------------*/
			
			
		
		
		/*-------------------------
		 * --JCOMBOBOX--
		 * ------------------------*/
			
			//TEMPORADAS
			comboBoxTemporadas = new JComboBox<String>();
			comboBoxTemporadas.setModel(new DefaultComboBoxModel<String>(new String[] {"1","2","3","4","5","6","7","8","9","10+"}));
			painelDados.add(comboBoxTemporadas, "cell 1 2,alignx left,aligny center");
			designBox(comboBoxTemporadas);
		
			//AVALIAÇÃO
			comboBoxNota = new JComboBox<String>();
			comboBoxNota.setMaximumRowCount(10);
			comboBoxNota.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5"}));
			comboBoxNota.setMaximumSize(new Dimension(50,50));
			painelDados.add(comboBoxNota, "cell 1 3,growx,aligny center");
			designBox(comboBoxNota);
			
			//ASSISTIDO
			comboBoxAssistido = new JComboBox <String>();
			comboBoxAssistido.setModel(new DefaultComboBoxModel<String>(new String[] {"Sim", "Não", "Assistindo"}));
			painelDados.add(comboBoxAssistido, "cell 1 4,alignx left");
			designBox(comboBoxAssistido);
			
		/*------------------------*/
		
			
			
		/*-------------------------
		 * --JBUTTON--
		 * ------------------------*/
			
			//GRAVAR
			JButton botaoGravar = new JButton("Salvar");
			designBotoes(botaoGravar);
			painelBotoes.add(botaoGravar, "cell 0 0,grow");
			
			//LIMPAR
			JButton botaoLimpar = new JButton("Limpar conte\u00FAdo");
			painelBotoes.add(botaoLimpar, "cell 1 0");
			designBotoes(botaoLimpar);
			botaoLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limparCampos();
				}
			});
			
			
			
			botaoGravar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (estadoBotaoGravar == 1) {
						if (nomeDaProdutora.getText().equals("") || nomeDaSerie.getText().equals("") || nomeDaSerie.getText().equals("Digite o nome da série") || 
							nomeDaProdutora.getText().equals("Digite o nome da produtora")) {
							JOptionPane.showMessageDialog(null, "Os campos 'Título' e 'Produtora' não podem estar vazios!", "Erro!", JOptionPane.ERROR_MESSAGE);
						}else {
							if (controladorSeries.checaSeSerieExiste(nomeDaSerie.getText()) >= 0) {
								JOptionPane.showMessageDialog(null, "A série " + "'"+nomeDaSerie.getText()+"'" + " já foi inserida", "Erro!", JOptionPane.ERROR_MESSAGE);
							}else {
								if (controladorSeries.adicionaSerie(informacoesSerie())){
									JOptionPane.showMessageDialog(null, " A série " + "'" +nomeDaSerie.getText()+ "'" + " foi inserida com sucesso!", 
									"Atenção!", JOptionPane.INFORMATION_MESSAGE);
								}else {
									JOptionPane.showMessageDialog(null, "Erro ao inserir Série!", "Erro!", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
					
					}else if (estadoBotaoGravar == 2) {
							if (nomeDaProdutora.getText().equals("") || nomeDaSerie.getText().equals("")) 
								JOptionPane.showMessageDialog(null, "Os campos 'Título' e 'Produtora' não podem estar vazios!", "Erro!", JOptionPane.ERROR_MESSAGE);
							
								if (controladorSeries.checaSeSerieExiste(nomeDaSerie.getText()) >= 0 && controladorSeries.checaSeSerieExiste(nomeDaProdutora.getText()) >= 0) 
									JOptionPane.showMessageDialog(null, "A série " + "'"+nomeDaSerie.getText()+"'" + " não foi editada", "Erro!", JOptionPane.ERROR_MESSAGE);
									else {
										gravar();
										JOptionPane.showMessageDialog(null, "Edição realizada com sucesso!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
									}
							}
				}
				
			});
		
		/*------------------------*/
	}
	
	public void gravar () {
		if (estadoBotaoGravar == 2) 
			controladorSeries.atualizar(numeroLinhaEdicao, informacoesSerie());

	}
	

	private void designBox(JComboBox<String> box) {
		box.setForeground(Color.BLACK);
		box.setMaximumRowCount(10);
	}
	
	private void designBotoes(JButton botao) {
		botao.setHorizontalAlignment(SwingConstants.LEFT);
		botao.setFont(new Font("Tahoma", Font.PLAIN, 12));
	}

	private void layoutPainelPrincipal() {
		setLayout(new BorderLayout(0, 0));
	}
	
	//ESTE MÉTODO PASSA TODAS AS INFORMAÇÕES DA SÉRIE PARA O CONTROLADOR DE SÉRIES
	 public Serie informacoesSerie () {	
		Serie s = new Serie ();
		controladorSeries.geraSerieParaClasseSerie(nomeDaSerie.getText(), 
									nomeDaProdutora.getText(), 
									comboBoxNota.getSelectedIndex()+1,
									String.valueOf(comboBoxTemporadas.getSelectedIndex()),
									(String)(comboBoxAssistido.getSelectedItem())
									);
											
		s.setNome(nomeDaSerie.getText());
		s.setProdutor(nomeDaProdutora.getText());
		s.setAvaliacao(comboBoxNota.getSelectedIndex()+1);
		s.setNumeroDeTemporadas(String.valueOf(comboBoxTemporadas.getSelectedItem()));
		s.setAssistido((String)(comboBoxAssistido.getSelectedItem()));
		
		return s;
	}

	 public void limparCampos() {
		 nomeDaSerie.setText("");
		 nomeDaProdutora.setText("");
		 comboBoxTemporadas.setSelectedItem("1");
		 comboBoxNota.setSelectedItem("1");
		  
		 JOptionPane.showMessageDialog(null, "Os campos foram limpos!", "Atenção!", JOptionPane.INFORMATION_MESSAGE, null);
	 }
	 
	 
		/*-------------------------
		 * --GETTERS--
		 * ------------------------*/
		public JTextField getNomeDaSerie() {
			return nomeDaSerie;
		}
		
		public JTextField getNomeDaProdutora() {
			return nomeDaProdutora;
		}
		
		public JComboBox<String> getComboBoxTemporadas() {
			return comboBoxTemporadas;
		}
		
		public JComboBox<String> getComboBoxNota() {
			return comboBoxNota;
		}
		
		public JComboBox<String> getComboBoxAssistido() {
			return comboBoxAssistido;
		}
		
		public ControleDeSeries getControladorSeries() {
			return controladorSeries;
		}

		public int getEstadoBotaoGravar() {
			return estadoBotaoGravar;
		}
		
		public void setEstadoBotaoGravar (int estado) {
			estadoBotaoGravar = estado;
		}
		
		public int getNumeroLinhaEdicao() {
			return numeroLinhaEdicao;
		}
		
		public void setNumeroLinhaEdicao(int numeroLinhaEdicao) {
			this.numeroLinhaEdicao = numeroLinhaEdicao;
		}
}
