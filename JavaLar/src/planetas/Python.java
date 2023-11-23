package planetas;

import model.Planetas;

public class Python extends Planetas {

	public static final String DIRETORIO = "C:\\Users\\Júlio César\\Desktop\\FACULDADE\\2º SEMESTRE\\TÉCNICAS DE PROGRAMAÇÃO\\JavaLar\\Foto dos Planetas\\Python.png";

	
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
	}


}
