package planetas;

import model.Planetas;

public class CSharp extends Planetas {

	public static final String DIRETORIO = "C:\\Users\\Júlio César\\Desktop\\FACULDADE\\2º SEMESTRE\\TÉCNICAS DE PROGRAMAÇÃO\\JavaLar\\Foto dos Planetas\\C#.png";

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
		
	}

}
