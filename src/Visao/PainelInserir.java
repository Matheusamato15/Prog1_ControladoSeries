package Visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PainelInserir extends JFrame {

	protected JPanel painelPrincipalTelaInserir;
	protected JPanel painelConteudoTelaInserir;
	protected JLabel textoTelaInserir;
	protected ConteudoTelaInserir conteudoInserir;
	
	public PainelInserir() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Arquivos\\liano.jpg"));
		
	
		setTitle("Cadastro de Séries");
		//////////////////////////////////////////////CRIAÇÃO DOS PAINEL PRINCIPAL
		
		painelPrincipalTelaInserir = new JPanel();
		designpainelPrincipalTelaInserir();
		setContentPane(painelPrincipalTelaInserir);
		this.setResizable(false);
		
		painelConteudoTelaInserir = new JPanel();
		painelConteudoTelaInserir.setLayout(new GridLayout(1, 2, 0, 0));
		//CONTEUDO DO CADASTRO
		conteudoInserir = new ConteudoTelaInserir();
		painelConteudoTelaInserir.add(conteudoInserir);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		designPainelTelaInserir();
		
		////////////////////////////////////////////LABEL TÍTULO
		textoTelaInserir = new JLabel("Bem vindo ao cadastro");
		textoTelaInserir.setBackground(Color.LIGHT_GRAY);
		textoTelaInserir.setHorizontalAlignment(SwingConstants.CENTER);
		textoTelaInserir.setFont(new Font("Tahoma", Font.BOLD, 24));
		painelPrincipalTelaInserir.add(textoTelaInserir, BorderLayout.NORTH);
		
	}
	
	private void designPainelTelaInserir() {
		painelConteudoTelaInserir.setBackground(Color.GRAY);
		painelPrincipalTelaInserir.setForeground(Color.LIGHT_GRAY);
		painelPrincipalTelaInserir.setLayout(new BorderLayout(0, 0));
		painelPrincipalTelaInserir.add(painelConteudoTelaInserir);
	}
	
	private void designpainelPrincipalTelaInserir() {
		setSize(380,500);
		painelPrincipalTelaInserir.setBackground(Color.LIGHT_GRAY);
		painelPrincipalTelaInserir.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	
	protected void setTitulo(String titulo) {
		textoTelaInserir.setText(titulo);
	}


}
