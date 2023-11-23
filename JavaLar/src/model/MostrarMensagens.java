package model;

public class MostrarMensagens {

	private int opcao = 0;
	
	public static void bemVindo() {

		System.out.println("Bem-vindo ao Sistema JavaLar!!");
		System.out.println("Digite um número correspondente à uma ação!");
		System.out.println("1 - Iniciar Simulação");
		System.out.println("2 - Informações");
		System.out.println("3 - Sair");

	}
	
	public static void mostrarOQueSaoLinguagensDeProgramacao() {
		
		System.out.println("\n-//-//-//- O QUE SÃO LINGUAGENS DE PROGRAMAÇÃO -//-//-//-");
		System.out.println("Linguagens de programação são sistemas formais usados por programadores para criar programas de computador.\nElas definem regras de escrita e significado para instruções que controlam o comportamento de máquinas, permitindo a comunicação entre humanos e computadores.\nExistem muitas linguagens diferentes, cada uma com seus propósitos e características, e elas são essenciais para desenvolver software e sistemas de computador.");
		
	}

	public MostrarMensagens(Utilidades utilidades) {
		
		mostrarInformacoes();
		opcao = utilidades.retornarOpcao();
		
		do {
			if (opcao == 1) {
				comoFuncionaOSistema();
			} else if (opcao == 2) {
				mostrarOQueSaoLinguagensDeProgramacao();
			} else if (opcao == 3) {
				continue;
			}
		
			System.out.println("\n\nDeseja saber algo mais?");
			mostrarInformacoes();
			
			opcao = 0;
			opcao = utilidades.retornarOpcao();
			
		}while(opcao < 3);
		
		System.out.println("\n");
	}

	public static void mostrarInformacoes() {

		System.out.println("\n1 - Como funciona o sistema?");
		System.out.println("2 - O que são linguagens de programação?");
		System.out.println("3 - Voltar ao Menu Principal");

	}

	public static void comoFuncionaOSistema() {

		
		System.out.println("\n-//-//-//- COMO FUNCIONA O SISTEMA -//-//-//-");
		
		System.out.println(
				"Basicamente, no sistema JavaLar, o usuário digita a quantidade de instantes, bugs e desenvolvedores que serão criados");
		System.out.println(
				"Os planetas têm velocidades e se movem em função dos instantes que são cedidos pelo usuário!");
		System.out.println(
				"Ao se chocar com um bug o planeta perde 1 de velocidade! Ao se chocar com um desenvolvedor ele ganha 1 de velocidade!");
		System.out.println("Ao chegar a 0 de velocidade o planeta explode :'(");
		System.out.println(
				"A cada instante são mostradas ao usuário informações sobre cada planeta: velocidade atual, posição, distancia para outros planetas, area... etc");
	}

}
