package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Botao extends JButton {
	
	private static final String COR_DOS_BOTOES = "#1bb0ce";
	
	
	public Botao(String nome) {
		
		this.setFont(new Font("SansSerif", Font.BOLD, 13));
		this.setText(nome);
		this.setBackground(Color.decode(COR_DOS_BOTOES));
		this.setFocusable(false);
		
	}

}
