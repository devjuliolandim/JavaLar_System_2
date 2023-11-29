package controller;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Entidades {

	protected ImageIcon imagem;

	protected String diretorio;

	public Entidades() {

	}

	public ImageIcon getImagem() {
		return imagem;
	}

	public void setImagem(String diretorio) {

		imagem = new ImageIcon(diretorio);

		Image imagemRedimensionada;
		imagemRedimensionada = imagem.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);

		imagem = new ImageIcon(imagemRedimensionada);

	}

}
