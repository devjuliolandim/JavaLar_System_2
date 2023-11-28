package controller;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Desenvolvedor {

	private JLabel imagem;
	
	public Desenvolvedor() {
		
		
		setImagem();
		
	}
	
	private void setImagem() {

		ImageIcon imgDev = new ImageIcon("Bugs e Devs\\Desenvolvedor.png");

		Image imagemRedimensionada;

		imagemRedimensionada = imgDev.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);

		imgDev = new ImageIcon(imagemRedimensionada);

		imagem = new JLabel(imgDev);

	}
	
	public JLabel getImagem() {
		
		return this.imagem;
	}

	
}
