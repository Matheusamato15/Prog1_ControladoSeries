package Visao;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextField;

public class ApresentacaoTexto {
	boolean podeSelecionar =  true;
	
		public void limpaTextoMouse (JTextField texto) {
			texto.addMouseListener(new MouseListener(){
				public void mouseClicked(MouseEvent arg0) {	
					
					if (podeSelecionar ) {
						texto.selectAll();
						texto.setForeground(Color.BLACK);
					}
				}
				public void mouseEntered(MouseEvent e) {
				}

				public void mouseExited(MouseEvent e) {
					podeSelecionar = false;
				}

				public void mouseReleased(MouseEvent e) {
				}

				public void mousePressed(MouseEvent e) {
				}
			});
			
			//------------------------------
			
			texto.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {	
				}

				public void focusGained(FocusEvent e) {
					texto.setForeground(Color.BLACK);
					texto.selectAll();
				}
			});
		}		
}
