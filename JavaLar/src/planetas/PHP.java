package planetas;

import controller.Planetas;

public class PHP extends Planetas {

	public static final String DIRETORIO = "Foto dos Planetas\\PHP.png";


	public PHP() {

		setVelocidade(2);
		setHoras(60);
		setPosicao(new int[] { 8, 12 });
		setBugsCont(0);
		setDevsCont(0);
		setAnos(0);
		setNome("PHP");
		setxInicial(8);
		setyInicial(12);
		setOrbitaPermitida(4);
		setDiretorioDeSuaImagem(DIRETORIO);
		setImagem(DIRETORIO);

		
	}

	


}
