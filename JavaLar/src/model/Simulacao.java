package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Simulacao {

	private Scanner scanner;
	private int instantes = 0;
	private int quantidadeBug = 0;
	private int quantidadeDesenvolvedores = 0;
	private int espacoDisponivel = 0;
	private int somatorioDeInstantes = 0;
	private int opcao = 0;
	
	public Simulacao(ArrayList<Planetas> planetas, Utilidades utilidades, ArrayList<Bug> bugs, ArrayList<Desenvolvedor> dev, ArrayList<CemiterioDePlanetas> cova) {

		scanner = new Scanner(System.in);
		
		do {
			System.out.print("\nDigite os instantes: ");

			instantes = utilidades.retornarInstantes();
			somatorioDeInstantes += instantes;

			espacoDisponivel = 224 - bugs.size() - dev.size();

			System.out.print("Digite a quantidade de Bugs que você deseja: ");
			quantidadeBug = utilidades.retornarQuantidadeDeBugs(espacoDisponivel);
			Bug.criarBugs(quantidadeBug, bugs, dev);

			espacoDisponivel = 224 - bugs.size() - dev.size();

			System.out.print("Digite a quantidade de Desenvolvedores que você deseja: ");
			quantidadeDesenvolvedores = utilidades.retornarQuantidadeDeDevs(espacoDisponivel);
			Desenvolvedor.criarDesenvolvedores(quantidadeDesenvolvedores, dev, bugs);

			Utilidades.mover(planetas, instantes);
			Utilidades.show(planetas);

			Bug.verificarEncontroComBugs(planetas, bugs, cova);
			Desenvolvedor.verificarEncontroComDesenvolvedores(planetas, dev);

			if (planetas.size() == 0) {
				System.out.println("Todos os planetas explodiram !");
				Relatorio.relatorio(planetas, cova, somatorioDeInstantes);
				System.out.println("\n\nFim de simulação!");
				break;
			}

			Calculos.infos(planetas, instantes);
			
			System.out.println("\n\nDeseja continuar?");
			System.out.println("1 - Sim!");
			System.out.println("2 - Não!");

			opcao = scanner.nextInt();

			if (opcao == 2) {
				Relatorio.relatorio(planetas, cova, somatorioDeInstantes);
				System.out.println("\n\nFim de programa!");
				
			}
			

		} while (opcao == 1);

	}

}
