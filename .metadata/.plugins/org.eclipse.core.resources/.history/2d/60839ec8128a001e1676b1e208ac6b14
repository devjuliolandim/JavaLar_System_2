package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import model.Memoria;
import model.Planetas;

public class PainelDoPlano extends JPanel {

	private static final int TAMANHO_DO_GRID = 15;
	private static final int TAMANHO_DA_IMAGEM = 25;
	private static final int TAMANHO_DO_PLANO = 225;

	private static final String DIRETORIO_IMAGEM_JAVA = "C:\\Users\\Júlio César\\Desktop\\FACULDADE\\2º SEMESTRE\\TÉCNICAS DE PROGRAMAÇÃO\\JavaLar\\Foto dos Planetas\\Java.png";
	private static final String DIRETORIO_IMAGEM_BUG = "C:\\Users\\Júlio César\\Desktop\\FACULDADE\\2º SEMESTRE\\TÉCNICAS DE PROGRAMAÇÃO\\JavaLar\\Bugs e Devs\\Bug.png";
	private static final String DIRETORIO_IMAGEM_DEV = "C:\\Users\\Júlio César\\Desktop\\FACULDADE\\2º SEMESTRE\\TÉCNICAS DE PROGRAMAÇÃO\\JavaLar\\Bugs e Devs\\Desenvolvedor.jpg";
	
	private Coordenada[][] coordenadas;
	private ArrayList<Coordenada> coordenadasOcupadasPorPlanetas = new ArrayList<>();
	private ArrayList<Coordenada> coordenadasOcupadasPorBugs = new ArrayList<>();
	private ArrayList<Coordenada> coordenadasOcupadasPorDesenvolvedores = new ArrayList<>();

	private ImageIcon imagem;
	private Image imagemRedimensionada;
	private JLabel label;

	private Random random = new Random();

	private Memoria memoria;

	public PainelDoPlano(Memoria memoria) {

		this.memoria = memoria;

		
		setBorder(new LineBorder(Color.gray, 5));
		setLayout(new GridLayout(TAMANHO_DO_GRID, TAMANHO_DO_GRID));

		coordenadas = new Coordenada[TAMANHO_DO_PLANO][TAMANHO_DO_PLANO];

		criarCoordenadas();
		adicionarImagensDosPlanetas();
	}

	private void criarCoordenadas() {

		for (int i = TAMANHO_DO_GRID - 1; i >= 0; i--) {
			for (int j = 0; j < TAMANHO_DO_GRID; j++) {
				coordenadas[i][j] = new Coordenada((i + 1), (j + 1));

				if ((i + 1) == 8 && (j + 1) == 8) {
					adicionarImagemJava();
				}

				add(coordenadas[i][j]);
			}

		}

	}

	private void adicionarImagemJava() {

		imagem = new ImageIcon(DIRETORIO_IMAGEM_JAVA);

		imagemRedimensionada = imagem.getImage().getScaledInstance(TAMANHO_DA_IMAGEM, TAMANHO_DA_IMAGEM,
				Image.SCALE_SMOOTH);

		imagem = new ImageIcon(imagemRedimensionada);

		label = new JLabel(imagem);

		coordenadas[7][7].add(label);

	}

	public void adicionarImagensDosBugs(int quantidadeDeBugs) {

		for (int i = 0; i < quantidadeDeBugs; i++) {
			int x, y;

			do {
				x = random.nextInt(15);
				y = random.nextInt(15);

			} while (verificarCoordenadaOcupada(x, y));

			addBugs(x, y);

			coordenadasOcupadasPorBugs.add(new Coordenada(x, y));

		}

	}

	public void adicionarImagemDosDevs(int quantidadeDeDevs) {

		for (int i = 0; i < quantidadeDeDevs; i++) {
			int x, y;

			do {
				x = random.nextInt(15);
				y = random.nextInt(15);

			} while (verificarCoordenadaOcupada(x, y));

			addDevs(x, y);

			coordenadasOcupadasPorDesenvolvedores.add(new Coordenada(x, y));

		}

	}

	private boolean verificarCoordenadaOcupada(int x, int y) {

		if (coordenadasOcupadasPorPlanetas(x, y) || coordenadasOcupadasPorDesenvolvedores(x, y)
				|| coordenadasOcupadasPorBugs(x, y)) {
			return true;
		}

		return false;
	}

	private boolean coordenadasOcupadasPorPlanetas(int x, int y) {
		for (Coordenada coordenada : coordenadasOcupadasPorPlanetas) {
			if (coordenada != null && coordenada.getEixoX() == x && coordenada.getEixoY() == y) {
				return true;
			}
		}

		return false;
	}

	private boolean coordenadasOcupadasPorDesenvolvedores(int x, int y) {
		for (Coordenada coordenada : coordenadasOcupadasPorDesenvolvedores) {
			if (coordenada != null && coordenada.getEixoX() == x && coordenada.getEixoY() == y) {
				return true;
			}
		}

		return false;
	}

	private boolean coordenadasOcupadasPorBugs(int x, int y) {
		for (Coordenada coordenada : coordenadasOcupadasPorBugs) {
			if (coordenada != null && coordenada.getEixoX() == x && coordenada.getEixoY() == y) {
				return true;
			}
		}

		return false;
	}

	public void addDevs(int x, int y) {

		if (coordenadas[x][y] != null) {
			imagem = new ImageIcon(DIRETORIO_IMAGEM_DEV);

			imagemRedimensionada = imagem.getImage().getScaledInstance(TAMANHO_DA_IMAGEM, TAMANHO_DA_IMAGEM,
					Image.SCALE_SMOOTH);

			imagem = new ImageIcon(imagemRedimensionada);

			label = new JLabel(imagem);

			coordenadas[x][y].add(label);

			coordenadas[x][y].revalidate();
			coordenadas[x][y].repaint();
		}

	}

	private void addBugs(int x, int y) {

		if (coordenadas[x][y] != null) {
			imagem = new ImageIcon(DIRETORIO_IMAGEM_BUG);

			imagemRedimensionada = imagem.getImage().getScaledInstance(TAMANHO_DA_IMAGEM, TAMANHO_DA_IMAGEM,
					Image.SCALE_SMOOTH);

			imagem = new ImageIcon(imagemRedimensionada);

			label = new JLabel(imagem);

			coordenadas[x][y].add(label);

			coordenadas[x][y].revalidate();
			coordenadas[x][y].repaint();
		}

	}

	public void adicionarImagensDosPlanetas() {

		for (int i = 0; i < TAMANHO_DO_GRID; i++) {
			for (int j = 0; j < TAMANHO_DO_GRID; j++) {
				for (Planetas planetas : memoria.getPlanetas()) {

					if (planetas.getPosicaoX() == (j + 1) && planetas.getPosicaoY() == (i + 1)) {

						imagem = new ImageIcon(planetas.getDiretorioDeSuaImagem());

						imagemRedimensionada = imagem.getImage().getScaledInstance(TAMANHO_DA_IMAGEM, TAMANHO_DA_IMAGEM,
								Image.SCALE_SMOOTH);

						imagem = new ImageIcon(imagemRedimensionada);

						label = new JLabel(imagem);

						coordenadas[i][j].setImagem(label);

						coordenadasOcupadasPorPlanetas.add(coordenadas[i][j]);

						revalidate();
						repaint();
					}

				}

			}

		}

	}

	public ArrayList<Coordenada> getCoordenadasOcupadasPorPlanetas() {
		return coordenadasOcupadasPorPlanetas;
	}

}
