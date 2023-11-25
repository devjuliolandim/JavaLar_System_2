package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Coordenada extends JPanel {

	
	private JLabel parOrdenado;
	private JLabel imagem;
	private int eixoX;
	private int eixoY;
	
	public Coordenada(int posX, int posY) {
	
		this.setBorder(new LineBorder(Color.gray, 1));
		this.setOpaque(false);
		
		
		this.eixoX= posX;
		this.eixoY = posY;
		
		//definirCoordenada(posX, posY);
		
	}
	
	public int getEixoX() {
		return eixoX;
	}

	public int getEixoY() {
		return eixoY;
	}
	
	
	private void definirCoordenada(int x, int y) {
		
		
		parOrdenado = new JLabel("("+ y + ", " + x + ")");
		parOrdenado.setBackground(Color.black);
		add(parOrdenado);
		
	}

	public JLabel getImagem() {
		return imagem;
	}

	public void setImagem(JLabel imagem) {
		
	    // Defina a nova imagem
	   this.imagem = imagem;

	    // Adicione a nova imagem apenas se não for nula
	    if (this.imagem != null) {
	        add(this.imagem);
	    }

	    // Revalide e repinte o painel para refletir as mudanças
	    revalidate();
	    repaint();
	}

	


	
	
}
