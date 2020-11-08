package Visao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import Controle.ControleDeJanelas;
import Controle.ControleDeSeries;
import Modelo.ModeloJTable;
import Modelo.Serie;
import java.awt.Toolkit;
import java.awt.Font;

@SuppressWarnings("serial")
public class PainelVisualizar extends JFrame{
	private JTable table;
	
	public ArrayList<Serie> listaDeSerie = new ArrayList<Serie>();
	ControleDeSeries controladorSeries = new ControleDeSeries();
	ModeloJTable modelo = new ModeloJTable();

	public PainelVisualizar() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("Arquivos\\liano.jpg"));
		
		setTitle("Visualizar Séries Arquivadas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1080,720);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
		
		
		/*-------------------------
		 * --JPANEL--
		 * ------------------------*/
			
		
			JPanel painelPrincipal = new JPanel();
			getContentPane().add(painelPrincipal, BorderLayout.CENTER);
			painelPrincipal.setLayout(new BorderLayout(0, 0));
			
			JPanel painelBotoes = new JPanel();
			FlowLayout fl_painelBotoes = (FlowLayout) painelBotoes.getLayout();
			fl_painelBotoes.setAlignment(FlowLayout.LEFT);
			painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
			
			
		/* -----*/
			
			
			
		/*-------------------------
		 * --JPANEL--
		 * ------------------------*/
			
			table = new JTable();
			table.setModel(modelo);
			table.setSelectionMode(0);
			
		/* -----*/
			
			
			
			
		/*-------------------------
		 * --JScrollPane--
		 * ------------------------*/	
			
			JScrollPane barraDeRolagem = new JScrollPane();
			painelPrincipal.add(barraDeRolagem, BorderLayout.CENTER);
			barraDeRolagem.setViewportView(table);
			
		/* -----*/
			
			
			
			
		/*-------------------------
		 * --JBUTTON--
		 * ------------------------*/
		
			//EDITAR
				JButton botaoEditar = new JButton("Editar");
				botaoEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
				botaoEditar.setHorizontalAlignment(SwingConstants.LEFT);
				painelBotoes.add(botaoEditar);
				botaoEditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						if (listaDeSerie.size() == 0) {
							JOptionPane.showMessageDialog(null, "Não foi possivel editar pois não há nenhuma série cadastrada!", "Erro!", JOptionPane.ERROR_MESSAGE);
						}else {
							if (table.getSelectedRow() == -1)
								JOptionPane.showMessageDialog(null, "Selecione uma série para poder editar!", "Erro!", JOptionPane.ERROR_MESSAGE);
							else {
								if (listaDeSerie.size() > 0) {
									new ControleDeJanelas().abrirJanelaBotao(new PainelDeAtualizacao(getSerieSelecionada()));
									dispose();
								}
							}
						}
						
					}
				});
			
			//EXCLUIR
				JButton btnExcluir = new JButton("Excluir");
				btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
				painelBotoes.add(btnExcluir);
				btnExcluir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if (listaDeSerie.size() == 0) {
							JOptionPane.showMessageDialog(null, "Não foi possivel excluir pois não há nenhuma série cadastrada!", "Erro!", JOptionPane.ERROR_MESSAGE);
						}else {
							if (table.getSelectedRow() == -1)
								JOptionPane.showMessageDialog(null, "Selecione uma série para poder excluir!", "Erro!", JOptionPane.ERROR_MESSAGE);
							else {
								if (listaDeSerie.size() > 0) {
									if (JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir a série selecionada?", "Aviso!", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
										listaDeSerie.remove(table.getSelectedRow());
										controladorSeries.apagarArquivo();
										
											for (int i=0; i<listaDeSerie.size(); i++) {
												controladorSeries.gravarNoArquivo("arquivo_de_séries.mae", listaDeSerie.get(i));
											}
										abrir();
									}
								}
							}
						}
					}
				});
			
			
		/* -----*/
	}
	
	public void visualizarTable() {
		listaDeSerie = controladorSeries.lerArquivo("arquivo_de_séries.mae");
		modelo = new ModeloJTable();
		for (int i=0; i<listaDeSerie.size(); i++) {
				modelo.adicionarLinha(listaDeSerie.get(i));
		}
		
		table.setModel(modelo);
	}
	
	public void abrir() {
		this.setVisible(true);
		visualizarTable();
	}
	
	public Serie getSerieSelecionada() {
		int linha = table.getSelectedRow();
		
		ModeloJTable modelo = (ModeloJTable) table.getModel();
		return modelo.obterLinha(linha);
	}
	
	public int getLinha() {
		return table.getSelectedRow();
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
		
}
