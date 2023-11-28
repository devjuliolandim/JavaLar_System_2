package planetas;

import controller.Planetas;

public class CSharp extends Planetas {

	public static final String DIRETORIO = "Foto dos Planetas\\C#.png";

	public CSharp() {

		setVelocidade(1);
		setHoras(4);
		setPosicao(new int[] { 8, 13 });
		setBugsCont(0);
		setDevsCont(0);
		setAnos(0);
		setNome("C#");
		setxInicial(8);
		setyInicial(13);
		setOrbitaPermitida(5);
		setDiretorioDeSuaImagem(DIRETORIO);
		setImagem(DIRETORIO);

		
	}

}
