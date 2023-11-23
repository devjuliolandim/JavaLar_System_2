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

import controller.Verificacao;
import model.Memoria;
import model.Planetas;

public class PainelDoPlano extends JPanel {

	private static final int TAMANHO_DO_GRID = 15;
	private static final int TAMANHO_DA_IMAGEM = 50;
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

	private Verificacao verificacao = new Verificacao(this);

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
	
	
	
	private JLabel redimensionarImagens(String diretorio) {
		
		imagem = new ImageIcon(diretorio);

		imagemRedimensionada = imagem.getImage().getScaledInstance(TAMANHO_DA_IMAGEM, TAMANHO_DA_IMAGEM,
				Image.SCALE_SMOOTH);

		imagem = new ImageIcon(imagemRedimensionada);

		label = new JLabel(imagem);
		
		return label;
	}
	

	private void adicionarImagemJava() {

		coordenadas[7][7].add(redimensionarImagens(DIRETORIO_IMAGEM_JAVA));

	}

	public void adicionarImagensDosBugs(int quantidadeDeBugs) {

		for (int i = 0; i < quantidadeDeBugs; i++) {
			int x, y;

			do {
				x = random.nextInt(15);
				y = random.nextInt(15);

			} while (verificacao.verificarCoordenadaOcupada(x, y));

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

			} while (verificacao.verificarCoordenadaOcupada(x, y));

			addDevs(x, y);

			coordenadasOcupadasPorDesenvolvedores.add(new Coordenada(x, y));

		}

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
				for (Planetas planetas : memoria.getPlanetasVivos()) {

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

	public ArrayList<Coordenada> getCoordenadasOcupadasPorBugs() {
		return coordenadasOcupadasPorBugs;
	}

	public ArrayList<Coordenada> getCoordenadasOcupadasPorDesenvolvedores() {
		return coordenadasOcupadasPorDesenvolvedores;
	}

}