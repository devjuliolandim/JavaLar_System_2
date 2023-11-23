package model;

public abstract class Planetas  {

	protected int[] posicao = new int[2];
	protected int velocidade;
	protected double horas;
	protected String nome;
	protected int bugsCont;
	protected int devsCont;
	protected int anos;
	protected int orbitaPermitida[][];
	protected int indicePosAtual = 0;
	protected int xInicial;
	protected int yInicial;
	protected String diretorioDeSuaImagem;
	
	public Planetas() {

	}
	
	public String getDiretorioDeSuaImagem() {
		return diretorioDeSuaImagem;
	}

	public void setDiretorioDeSuaImagem(String diretorioDeSuaImagem) {
		this.diretorioDeSuaImagem = diretorioDeSuaImagem;
	}


	public int getxInicial() {
		return xInicial;
	}

	public int getyInicial() {
		return yInicial;
	}

	public int[][] getOrbitaPermitida() {
		return orbitaPermitida;
	}

	public void setOrbitaPermitida(int distanciaDaEstrela) {

		int[][] orbita = new int[distanciaDaEstrela * 8][2];

		int xInicial = this.xInicial;
		int yInicial = this.yInicial;

		for (int i = 0; i < distanciaDaEstrela * 8; i++) {
			orbita[i][0] = xInicial;
			orbita[i][1] = yInicial;

			if (i < (1 * distanciaDaEstrela)) {
				xInicial--;
			} else if (i < (3 * distanciaDaEstrela)) {
				yInicial--;
			} else if (i < (5 * distanciaDaEstrela)) {
				xInicial++;
			} else if (i < (7 * distanciaDaEstrela)) {
				yInicial++;
			} else {
				xInicial--;
			}

		}

		this.orbitaPermitida = orbita;

	}

	public int getIndicePosAtual() {
		return indicePosAtual;
	}

	public void setIndicePosAtual(int indicePosAtual) {
		this.indicePosAtual = indicePosAtual;
	}

	public int getXInicial() {
		return xInicial;
	}

	public void setxInicial(int xInicial) {
		this.xInicial = xInicial;
	}

	public int getYInicial() {
		return yInicial;
	}

	public void setyInicial(int yInicial) {
		this.yInicial = yInicial;
	}

	public int getAnos() {
		return anos;
	}

	public void setAnos(int anos) {
		this.anos = anos;
	}

	public int getDevsCont() {
		return devsCont;
	}

	public void setDevsCont(int devsCont) {
		this.devsCont = devsCont;
	}

	public int getBugsCont() {
		return bugsCont;
	}

	public void setBugsCont(int bugsCont) {
		this.bugsCont = bugsCont;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int[] getPosicao() {
		return posicao;
	}

	public int getPosicaoX() {
		return this.posicao[0];
	}

	public int getPosicaoY() {
		return this.posicao[1];
	}

	public void setPosicao(int[] posicao) {
		this.posicao = posicao;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public void mover(int instantes) {

		for (int i = 0; i < instantes; i++) {

			indicePosAtual = (indicePosAtual + getVelocidade()) % orbitaPermitida.length;
			setPosicao(orbitaPermitida[indicePosAtual]);

			if (getPosicaoX() == getXInicial() && getPosicaoY() == getYInicial()) {

				anos++;
			}

		}

	}

}
