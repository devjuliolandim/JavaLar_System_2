package planetas;

import controller.Planetas;

public class JavaScript extends Planetas {

	public static final String DIRETORIO = "Foto dos Planetas\\JavaScript.png";

	
	public JavaScript() {

		setVelocidade(3);
		setHoras(10);
		setPosicao(new int[] { 8, 10 });
		setBugsCont(0);
		setDevsCont(0);
		setAnos(0);
		setNome("JavaScript");
		setxInicial(8);
		setyInicial(10);
		setOrbitaPermitida(2);
		setDiretorioDeSuaImagem(DIRETORIO);
		setImagem(DIRETORIO);

		
	}


	



}
