package planetas;

import controller.Planetas;

public class C extends Planetas {

	public static final String DIRETORIO = "Foto dos Planetas\\C.png";
	
	public C() {

		setVelocidade(10);
		setHoras(0.1);
		setPosicao(new int[] { 8, 15 });
		setBugsCont(0);
		setAnos(0);
		setNome("C");
		setxInicial(8);
		setyInicial(15);
		setOrbitaPermitida(7);
		setDiretorioDeSuaImagem(DIRETORIO);	
		setImagem(DIRETORIO);
		
	}

}
