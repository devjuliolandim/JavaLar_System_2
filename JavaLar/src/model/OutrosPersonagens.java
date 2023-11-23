package model;

public abstract class OutrosPersonagens {

	protected int[] posicao = new int[2];
	
	public OutrosPersonagens(int pX, int pY) {
		this.posicao[0] = pX;
		this.posicao[1] = pY;
		
	}

	public int[] getPosicao() {
		return posicao;
	}

	public void setPosicao(int[] posicao) {
		this.posicao = posicao;
	}
	
	public int getPX() {
		
		return this.posicao[0];
	}

	public int getPY() {
		
		return this.posicao[1];
	}	
	
}
