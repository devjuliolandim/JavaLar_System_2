package model;

import java.util.ArrayList;
import java.util.Random;

public class Desenvolvedor extends OutrosPersonagens {

	public Desenvolvedor(int pX, int pY) {
		super(pX, pY);

	}

	public static void criarDesenvolvedores(int qntddevs, ArrayList<Desenvolvedor> devs, ArrayList<Bug> bugs) {
		Random random = new Random();

		boolean[][] posOcupadas = new boolean[16][16];

		int pX = 0;
		int pY = 0;

		for (Bug bug : bugs) {

			pX = bug.getPX();
			pY = bug.getPY();

			posOcupadas[pX][pY] = true;

		}

		for (int i = 0; i < qntddevs; i++) {

			do {
				pX = random.nextInt(15)+1;
				pY = random.nextInt(15)+1;
			} while (posOcupadas[pX][pY] == true);

			Desenvolvedor desenvolvedor = new Desenvolvedor(pX, pY);
			devs.add(desenvolvedor);
			posOcupadas[pX][pY] = true;
		}

	}

	public static void verificarEncontroComDesenvolvedores(ArrayList<Planetas> planetas,ArrayList<Desenvolvedor> desenvolvedor) {

		ArrayList<Desenvolvedor> removerDev = new ArrayList<>();
		
		System.out.println("\n");
		for (Planetas planeta : planetas) {
			int velocidade = planeta.getVelocidade();
			int devsCont = planeta.getDevsCont();
			for (Desenvolvedor dev : desenvolvedor) {
				if (planeta.getPosicaoX() == dev.getPX() && planeta.getPosicaoY() == dev.getPY()) {
					System.out.println("Há uma colisão do planeta " + planeta.getNome() + " com um Desenvolvedor na posição ("+ planeta.getPosicaoX() + ", " + planeta.getPosicaoY() + ")");
					
					planeta.setDevsCont(devsCont + 1);
					planeta.setVelocidade(velocidade + 1);
					removerDev.add(dev);
					
					
				}

			}
		}

		
		desenvolvedor.removeAll(removerDev);
		
	}

}
