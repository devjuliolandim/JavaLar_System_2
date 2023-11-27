package controller;


public class Perguntas {
	
	

	public void retornarPlanetaQueMaisMorreu(int[] planetasComMaisMortes) {

		int maior = 0;

		for (int i = 0; i < 7; i++) {

			if (planetasComMaisMortes[i] > planetasComMaisMortes[maior]) {

				maior = i;

			}

		}

		if (maior == 0) {

			System.out.println("O planeta que mais morreu foi o Python!");
			
		} else if (maior == 1) {

			System.out.println("O planeta que mais morreu foi o JavaScript!");

			
		} else if (maior == 2) {

			System.out.println("O planeta que mais morreu foi o Ruby!");

			
		} else if (maior == 3) {

			System.out.println("O planeta que mais morreu foi o PHP!");

			
		} else if (maior == 4) {

			System.out.println("O planeta que mais morreu foi o C#!");

			
		} else if (maior == 5) {

			System.out.println("O planeta que mais morreu foi o C++!");

		} else if (maior == 6) {

			System.out.println("O planeta que mais morreu foi o C!");

		}

	}
	
	public void retornarPlanetaQueMaisViveu(int[] planetasComMaisVidas) {

		int maior = 0;

		for (int i = 0; i < 7; i++) {

			if (planetasComMaisVidas[i] > planetasComMaisVidas[maior]) {

				maior = i;

			}

		}

		if (maior == 0) {

			System.out.println("O planeta que mais viveu foi o Python!");
			
		} else if (maior == 1) {

			System.out.println("O planeta que mais viveu foi o JavaScript!");

			
		} else if (maior == 2) {

			System.out.println("O planeta que mais viveu foi o Ruby!");

			
		} else if (maior == 3) {

			System.out.println("O planeta que mais viveu foi o PHP!");

			
		} else if (maior == 4) {

			System.out.println("O planeta que mais viveu foi o C#!");

			
		} else if (maior == 5) {

			System.out.println("O planeta que mais viveu foi o C++!");

		} else if (maior == 6) {

			System.out.println("O planeta que mais viveu foi o C!");

		}

	}

}
