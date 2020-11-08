package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

import Visao.PainelVisualizar;

public class ControleDeJanelas {
		
	public void abrirJanela (JMenuItem menuItem, Object tela){
		menuItem.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if(tela.getClass() == new PainelVisualizar().getClass()) {
					((PainelVisualizar) tela).abrir();
				}else {
					((JFrame) tela).setVisible(true);
				}
			}
		});
	}
	
	public void sairPrograma (JMenuItem menuItem){
		menuItem.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void abrirJanelaBotao (JFrame tela){
		tela.setVisible(true);
	}
}
