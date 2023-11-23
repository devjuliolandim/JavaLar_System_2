package model;

import java.util.ArrayList;

public class Calculos {


	public static void infos(ArrayList<Planetas> planetas, int instantes) {
		
		hemisferios(planetas);
		
		for (Planetas planeta : planetas) {
			System.out.println("-//-//-//-//- " + planeta.getNome() + " -//-//-//-//-");
			velocidadeTranslacao(planeta);
			quantosDias(planeta, instantes);
			areaEntreDoisPontos(planetas, planeta);
			distanciaEntreDoisPontos(planetas, planeta);
			System.out.println("\n\n");

		}

		System.out.println("-//-//-//-//- ALINHAMENTOS -//-//-//-//-//-");
		if (diagonais(planetas) == true) {
		
		} else if (norteSul(planetas) == true) {
		
		} else {
			System.out.println("Não há nenhum alinhamento em relação a Java");
		}

		System.out.println("\n\n");

	}

	public static void velocidadeTranslacao(Planetas planeta) {
		System.out.println("A velocidade de translação do planeta " + planeta.getNome() + " é de "
				+ planeta.getVelocidade() + " unidades por instante");
	}

	public static void quantosDias(Planetas planeta, int instantes) {
		System.out.println("Passaram-se " + planeta.getHoras() * instantes + " horas no planeta " + planeta.getNome());

	}

	public static void hemisferios(ArrayList<Planetas> planetas) {

		int norte = 0;
		int sul = 0;

		System.out.println("\n-//-//-//-//- HEMISFÉRIOS -//-//-//-//-");
		
		
		for (Planetas planeta : planetas) {
			if (planeta.getPosicaoY() > 8) {
				norte++;
			}
			if (planeta.getPosicaoY() < 8) {
				sul++;
			}

		}

		if (norte > 0) {

			System.out.println("Existem " + norte + " planetas acima de Java!");

		}

		if (sul > 0) {

			System.out.println("Existem " + sul + " planetas abaixo de Java!");
		}
		
		if(norte == 0 && sul == 0) {
			
			System.out.println("Todos os planetas estão na mesma coordenada 'Y' de Java!");
		}
		
		
		System.out.println("-//-//-//-//-//-//-//-//-//-//-//-//-//-\n\n");

	}

	public static void areaEntreDoisPontos(ArrayList<Planetas> planetas, Planetas planeta) {
		System.out.println("\n--- A área é calculada em JavaMetros ao quadrado = Jm² ---");

		for (Planetas planeta1 : planetas) {
			for (Planetas planeta2 : planetas) {

				if (planeta1 != planeta2 && planeta1 == planeta) {

					double area = calcularArea(planeta1, planeta2);

					System.out.println("A àrea entre " + planeta1.getNome() + " e " + planeta2.getNome() + " é de "
							+ area + " Jm²");
				}

			}
		}

	}

	public static double calcularArea(Planetas planeta1, Planetas planeta2) {
		double altura = Math.abs(planeta2.getPosicaoY() - planeta1.getPosicaoY());
		double base = Math.abs(planeta2.getPosicaoX() - planeta1.getPosicaoX());

		if (altura == 0) {
			altura = 1;
		} else if (base == 0) {
			base = 1;

		}

		double area = base * altura;

		return area;

	}

	public static void distanciaEntreDoisPontos(ArrayList<Planetas> planetas, Planetas planeta) {

		System.out.println("\n--- A distância é calculada em JavaMetros = Jm ---");

		for (Planetas planeta1 : planetas) {
			for (Planetas planeta2 : planetas) {

				if (planeta1 != planeta2 && planeta1 == planeta) {

					double distancia = calcularDistancia(planeta1, planeta2);

					String resultado = String.format("%.2f", distancia);

					System.out.println("A distância entre o planeta " + planeta1.getNome() + " e " + planeta2.getNome()
							+ " é de " + resultado + " Jm");
				}

			}

		}

	}

	public static double calcularDistancia(Planetas planeta1, Planetas planeta2) {

		double X = Math.abs(planeta1.getPosicaoX() - planeta2.getPosicaoX());
		double Y = Math.abs(planeta1.getPosicaoY() - planeta2.getPosicaoY());

		double XAoQuadrado = Math.pow(X, 2);
		double YAoQuadrado = Math.pow(Y, 2);
		double distancia = Math.sqrt((XAoQuadrado + YAoQuadrado));

		return distancia;
	}

	public static boolean norteSul(ArrayList<Planetas> planetas) {

		int alinhamento = alinhamentoNorteSul(planetas);

		if (alinhamento == 1) {

			System.out.println("Há alinhamento ao norte de Java");

			return true;
		} else if (alinhamento == 2) {

			System.out.println("Há alinhamento ao sul de Java");

			return true;
		} else {

		}

		return false;
	}

	public static boolean diagonais(ArrayList<Planetas> planetas) {
		if (alinhamentoDiagonal(planetas) == 1) {
			System.out.println("Há alinhamento na diagonal Nordeste de Java!");
			return true;
		} else if (alinhamentoDiagonal(planetas) == 2) {
			System.out.println("Há alinhamento na diagonal Noroeste de Java!");
			return true;
		} else if (alinhamentoDiagonal(planetas) == 3) {
			System.out.println("Há alinhamento na diagonal Sudoeste de Java!");
			return true;
		} else if (alinhamentoDiagonal(planetas) == 4) {
			System.out.println("Há alinhamento na diagonal Sudeste de Java!");
			return true;
		} else {
		}

		return false;
	}

	public static int alinhamentoNorteSul(ArrayList<Planetas> planetas) {

		int verify = 0;

		for (int i = 0; i < planetas.size(); i++) {

			if (i + 1 < planetas.size()) {
				Planetas proximoPlaneta = planetas.get(i + 1);

				if (planetas.get(i).getPosicaoY() == (proximoPlaneta.getPosicaoY() - 1)) {

					verify++;
				}

			}

		}

		if (verify == 6) {

			return 1; 
		}

		verify = 0;

		for (int i = 0; i < planetas.size(); i++) {

			if (i + 1 < planetas.size()) {

				Planetas proximoPlaneta = planetas.get(i + 1);

				if (planetas.get(i).getPosicaoY() == (proximoPlaneta.getPosicaoY() + 1)) {

					verify++;
				}

			}
		}

		if (verify == 6) {

			return 2; 
		}

		return 0;
	}

	public static int alinhamentoDiagonal(ArrayList<Planetas> planetas) {

		int verify = 0;

		for (int i = 0; i < planetas.size(); i++) {

			if (i + 1 < planetas.size()) {

				Planetas Proximoplaneta = planetas.get(i + 1);

				if (planetas.get(i).getPosicaoX() == (Proximoplaneta.getPosicaoX() - 1)
						&& planetas.get(i).getPosicaoY() == (Proximoplaneta.getPosicaoY() - 1)) {
					verify++;
				}

			}

		}

		if (verify == 6) {

			return 1;
		}

		verify = 0;
		for (int i = 0; i < planetas.size(); i++) {

			if (i + 1 < planetas.size()) {

				Planetas Proximoplaneta = planetas.get(i + 1);

				if (planetas.get(i).getPosicaoX() == (Proximoplaneta.getPosicaoX() + 1)
						&& planetas.get(i).getPosicaoY() == (Proximoplaneta.getPosicaoY() - 1)) {
					verify++;

				}

			}

		}

		if (verify == 6) {
			return 2;
		}

		verify = 0;
		for (int i = 0; i < planetas.size(); i++) {

			if (i + 1 < planetas.size()) {

				Planetas Proximoplaneta = planetas.get(i + 1);

				if (planetas.get(i).getPosicaoX() == (Proximoplaneta.getPosicaoX() + 1)
						&& planetas.get(i).getPosicaoY() == (Proximoplaneta.getPosicaoY() + 1)) {
					verify++;
				}
			}

		}
		if (verify == 6) {
			return 3;
		}

		verify = 0;

		for (int i = 0; i < planetas.size(); i++) {

			if (i + 1 < planetas.size()) {

				Planetas Proximoplaneta = planetas.get(i + 1);

				if (planetas.get(i).getPosicaoX() == (Proximoplaneta.getPosicaoX() - 1)
						&& planetas.get(i).getPosicaoY() == (Proximoplaneta.getPosicaoY() + 1)) {
					verify++;
				}

			}

		}
		if (verify == 6) {
			return 4;
		}

		return 0;
	}
	
	
	
	
	public static double calculoDias(Planetas planeta, int instantes) {
		
		double dias = planeta.getHoras() * instantes/ 24;
		
		if(dias<1) {
			return 0;
		}
		
		
		return dias;
	}
	
	
	
	

	public static void areaDeCobertura (ArrayList <Planetas> planetas){
				
		System.out.println("\n\n-//-//-//-//- ÁREA DE COBERTURA -//-//-//-//-");
		int numeroDePlanetas = planetas.size();
		double area = 0;
		
		for(int i = 0; i < numeroDePlanetas; i++) {
			Planetas pontosAtuais = planetas.get(i);
			Planetas pontosFuturos = planetas.get((i+1) % numeroDePlanetas);
			
			int x1 = pontosAtuais.getPosicaoX();
			int y1 = pontosAtuais.getPosicaoY();
			int x2 = pontosFuturos.getPosicaoX();
			int y2 = pontosFuturos.getPosicaoY();
			
			
			area += (x1 * y2) - (x2 * y1);
			
		}
	
		area = 0.5 * Math.abs(area);
		
		System.out.println("-> A área de cobertura é de " + area + " Jm²");
	
	}	
	
}