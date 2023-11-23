package planetas;

import model.Planetas;

public class RubyOnRails extends Planetas {
	
	public static final String DIRETORIO = "C:\\Users\\Júlio César\\Desktop\\FACULDADE\\2º SEMESTRE\\TÉCNICAS DE PROGRAMAÇÃO\\JavaLar\\Foto dos Planetas\\ROR.png";

	public RubyOnRails() {

		setVelocidade(2);
		setHoras(48);
		setPosicao(new int[] { 8, 11 });
		setBugsCont(0);
		setDevsCont(0);
		setAnos(0);
		setNome("Ruby on Rails");
		setxInicial(8);
		setyInicial(11);
		setOrbitaPermitida(3);
		setDiretorioDeSuaImagem(DIRETORIO);
	}


}
