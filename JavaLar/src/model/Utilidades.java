package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Utilidades {

	public Scanner scanner;
	
	public Utilidades() {
		
		
	}
	
	
	public int retornarInstantes() {
		scanner = new Scanner(System.in);

		int opcao;

		do {
			opcao = scanner.nextInt();
			if (opcao == 0) {
				System.out.print("O número de instantes '0' não é permitido. Por favor digite novamente: ");
			} else if (opcao < 0) {
				System.out.println("Números menores do que '0' não são permitidos");
			}

		} while (opcao <= 0);

		return opcao;
	}

	public int retornarOpcao() {
		scanner = new Scanner(System.in);

		int opcao = 0;

		do {

			opcao = scanner.nextInt();

			if (opcao <= 0 || opcao > 3) {

				System.out.println("Utilize apenas as opções permitidas: (1 ou 2 ou 3)!");
			}

		} while (opcao <= 0 || opcao > 3);

		return opcao;
	}

	public static void show(ArrayList<Planetas> planetas) {

		System.out.println("\n\n-//-//-//-  Posições dos Planetas Linguagens  -//-//-//-");
		for(Planetas planeta : planetas) {
			System.out.println("A posicao atual do planeta " + planeta.getNome() + " é (" +planeta.getPosicaoX() + ", "+ planeta.getPosicaoY()+")");
		}
		System.out.println("-//-//-//-//-//-//-\n");

	}

	public static void mover(ArrayList<Planetas> planetas, int instantes) {
		for(Planetas planeta : planetas) {
			planeta.mover(instantes);
		}

	}

	public int retornarQuantidadeDeBugs(int espaco) {
		scanner = new Scanner(System.in);
		int quantidade = 0;

		do {

			quantidade = scanner.nextInt();

			if (quantidade > espaco) {

				System.out.print(
						"O limite máximo de bugs que você pode criar é " + espaco + " Por favor digite novamente: ");

			}

		} while (quantidade > espaco);

		return quantidade;
	}

	public int retornarQuantidadeDeDevs(int espaco) {
		scanner = new Scanner(System.in);

		int quantidade = 0;

		do {

			quantidade = scanner.nextInt();

			if (quantidade > espaco) {

				System.out.print("O limite máximo de desenvolvedores que você pode criar é " + espaco
						+ " Por favor digite novamente: ");
			}

		} while (quantidade > espaco);

		return quantidade;
	}

	

	

	public static void showBugs(ArrayList<Bug> bug) {

		for (Bug bug2 : bug) {
			System.out.println("(" + bug2.getPX() + ", " + bug2.getPY() + ")");
		}

	}

	

}
