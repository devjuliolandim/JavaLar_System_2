package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Coordenada extends JPanel {

	private JLabel imagemBug;
	private JLabel imagemDev;

	private JLabel parOrdenado;
	private JLabel imagem;
	private int eixoX;
	private int eixoY;

	public Coordenada(int posX, int posY) {

		this.setBorder(new LineBorder(Color.gray, 1));
		this.setOpaque(false);

		this.eixoX = posX;
		this.eixoY = posY;

		//definirCoordenada(posX, posY);

	}

	public int getEixoX() {
		return eixoX;
	}

	public int getEixoY() {
		return eixoY;
	}

	public void setEixoX(int x) {

		this.eixoX = x;

	}

	public void setEixoY(int y) {

		this.eixoY = y;

	}

	private void definirCoordenada(int x, int y) {

		parOrdenado = new JLabel("(" + x + ", " + y + ")");
		parOrdenado.setBackground(Color.black);
		add(parOrdenado);

	}

	public JLabel getImagem() {
		return imagem;
	}

	public void setImagem(JLabel imagem) {

		this.imagem = imagem;

		add(this.imagem);

		revalidate();
		repaint();
	}

	public void setImagemBug(JLabel imagemBug) {

		this.imagemBug = imagemBug;

		add(this.imagemBug);

		revalidate();
		repaint();

	}

	public JLabel getImagemBug() {
		return this.imagemBug;

	}

	public void setImagemDev(JLabel imagemDev) {
		this.imagemDev = imagemDev;

		add(this.imagemDev);

		revalidate();
		repaint();

	}

	public JLabel getImagemDev() {

		return this.imagemDev;

	}

}
