package model;

import java.util.ArrayList;
import java.util.Random;

public class Bug extends OutrosPersonagens {

	public Bug(int pX, int pY) {
		super(pX, pY);
	}

	public static void criarBugs(int qntdBug, ArrayList<Bug> bugs, ArrayList<Desenvolvedor> devs) {
		Random random = new Random();
		boolean[][] posOcupadas = new boolean[16][16];
		int pX = 0;
		int pY = 0;

		for (Desenvolvedor desenvolvedor : devs) {

			pX = desenvolvedor.getPX();
			pY = desenvolvedor.getPY();

			posOcupadas[pX][pY] = true;

		}

		for (int i = 0; i < qntdBug; i++) {

			do {
				pX = random.nextInt(15) + 1;
				pY = random.nextInt(15) + 1;
			} while (posOcupadas[pX][pY] == true || (pX == 8 && pY == 8));

			Bug bug = new Bug(pX, pY);
			bugs.add(bug);
			posOcupadas[pX][pY] = true;

		}

	}

	public static void verificarEncontroComBugs(ArrayList<Planetas> planetas, ArrayList<Bug> bugs,
			ArrayList<CemiterioDePlanetas> cova) {

		ArrayList<Bug> removerBug = new ArrayList<>();
		ArrayList<Planetas> removerPlaneta = new ArrayList<>();

		for (Planetas planeta : planetas) {
			int velocidade = planeta.getVelocidade();
			int bugsCont = planeta.getBugsCont();

			for (Bug bug : bugs) {
				if (planeta.getPosicaoX() == bug.getPX() && planeta.getPosicaoY() == bug.getPY()) {
					System.out.println("Há uma colisão do planeta " + planeta.getNome() + " com um bug na posicão ("
							+ planeta.getPosicaoX() + ", " + planeta.getPosicaoY() + ")");
					planeta.setBugsCont(bugsCont + 1);
					planeta.setVelocidade(velocidade - 1);
					removerBug.add(bug);
				}

			}

			if (planeta.getVelocidade() == 0) {
				removerPlaneta.add(planeta);
					
				CemiterioDePlanetas planetaMorto = new CemiterioDePlanetas();
				planetaMorto.setNome(planeta.getNome());
				cova.add(planetaMorto);
			}

		}

		System.out.println("\n");
		for (Planetas planeta : removerPlaneta) {
			System.out.println("-> O planeta " + planeta.getNome() + " explodiu!");
		}

		planetas.removeAll(removerPlaneta);
		bugs.removeAll(removerBug);

	}

}
