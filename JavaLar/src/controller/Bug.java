package controller;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bug {

	private JLabel imagem;

	public Bug() {
	
		setImagem();
		
	}
	
	
	private void setImagem() {

		ImageIcon imgBug = new ImageIcon("Bugs e Devs\\Bug.png");

		Image imagemRedimensionada;

		imagemRedimensionada = imgBug.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);

		imgBug = new ImageIcon(imagemRedimensionada);

		imagem = new JLabel(imgBug);

	}

	public JLabel getImagem() {

		return this.imagem;
	}

}
