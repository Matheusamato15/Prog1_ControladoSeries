package Visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import Controle.ControleDeJanelas;
import Imagem.CriadorImagem;

@SuppressWarnings("serial")
public class PainelInicial extends JFrame {
	
	//DECLARACAO DOS PAINÉIS

	private JPanel              painelPrincipal;
	private JPanel 				painelTituloImagem;
	private JLabel 				labelImagem; 
	private PainelInserir       painelInserir          = new PainelInserir ();
	private PainelVisualizar    painelDeVisualizacao   = new PainelVisualizar ();
	private ControleDeJanelas   controleJanelas        = new ControleDeJanelas();
	
	public PainelInicial() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Arquivos\\liano.jpg"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CrudFlix");
		
		/*-------------------------
		 * --JPanel--
		 * ------------------------*/
		
			painelPrincipal = new JPanel();
			setContentPane(painelPrincipal);
			painelPrincipal.setLayout(new BorderLayout(0, 0));
			painelTituloImagem = new JPanel();
			painelPrincipal.add(painelTituloImagem, BorderLayout.CENTER);
			painelTituloImagem.setLayout(new BorderLayout(0, 0));
			labelImagem = new JLabel(new CriadorImagem().imagemFundo("spn5.jpg", "spn5.jpg"));
			painelTituloImagem.add(labelImagem);
			
			designPainel(painelPrincipal);
		
		/*-------------------------
		 * --JMenu--
		 * ------------------------*/
			
			JMenuBar menuPrincipal = new JMenuBar();
			painelPrincipal.add(menuPrincipal, BorderLayout.NORTH);
			
			JMenu mainMenu = new JMenu("Menu");
			mainMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
			menuPrincipal.add(mainMenu);
			
		
		/*-------------------------
		 * --JMenuItem--
		 * ------------------------*/
			
			//INSERIR
			JMenuItem menuItemInserir    = new JMenuItem("Inserir");
			mainMenu.add(menuItemInserir);
			controleJanelas.abrirJanela(menuItemInserir, painelInserir);
			
			//VISUALIZAR
			JMenuItem menuItemVisualisar = new JMenuItem("Visualizar");
			mainMenu.add(menuItemVisualisar);
			controleJanelas.abrirJanela(menuItemVisualisar, painelDeVisualizacao);
			
			JSeparator separator   = new JSeparator();
			mainMenu.add(separator);
			
			//SAIR 
			JMenuItem menuItemSair =  new JMenuItem("Sair");
			mainMenu.add(menuItemSair);
			controleJanelas.sairPrograma(menuItemSair);

	}

	public void designPainel(JPanel painel) {
		painel.setBackground(Color.LIGHT_GRAY);
		setSize(380,500);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}
	
