package planetas;

import controller.Planetas;

public class RubyOnRails extends Planetas {
	
	public static final String DIRETORIO = "Foto dos Planetas\\ROR.png";

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
		setImagem(DIRETORIO);

	}


}
