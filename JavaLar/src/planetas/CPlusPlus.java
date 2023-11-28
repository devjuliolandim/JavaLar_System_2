package planetas;

import controller.Planetas;

public class CPlusPlus extends Planetas {

	public static final String DIRETORIO = "Foto dos Planetas\\C++.png";

	
	public CPlusPlus() {

		setVelocidade(2);
		setHoras(0.5);
		setPosicao(new int[] { 8, 14 });
		setBugsCont(0);
		setDevsCont(0);
		setAnos(0);
		setNome("C++");
		setxInicial(8);
		setyInicial(14);
		setOrbitaPermitida(6);
		setDiretorioDeSuaImagem(DIRETORIO);
		setImagem(DIRETORIO);

	}

}
