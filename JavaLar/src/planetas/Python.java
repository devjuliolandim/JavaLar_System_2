package planetas;

import controller.Planetas;

public class Python extends Planetas {

	public static final String DIRETORIO = "Foto dos Planetas\\Python.png";

	
	public Python() {

		setPosicao(new int[] {8,9});
		setHoras(24);
		setVelocidade(4);
		setBugsCont(0);
		setDevsCont(0);
		setAnos(0);
		setNome("Python");
		setxInicial(8);
		setyInicial(9);
		setOrbitaPermitida(1);
		setDiretorioDeSuaImagem(DIRETORIO);
		setImagem(DIRETORIO);

	}


}
