package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.Memoria;
import controller.Planetas;
import controller.Verificacao;
import controller.Bug;
import controller.Desenvolvedor;
import controller.Java;

public class PainelDoPlano extends JPanel {

	private static final int TAMANHO_DO_GRID = 15;

	private Coordenada[][] coordenadas;
	private ArrayList<Coordenada> coordenadasOcupadasPorPlanetas = new ArrayList<>();
	private ArrayList<Coordenada> coordenadasOcupadasPorBugs = new ArrayList<>();
	private ArrayList<Coordenada> coordenadasOcupadasPorDesenvolvedores = new ArrayList<>();

	private Random random = new Random();

	private Memoria memoria;

	private Verificacao verificacao = new Verificacao(this);

	private static final ImageIcon BUG_ICONE = new Bug().getImagem();
	private static final ImageIcon DEV_ICONE = new Desenvolvedor().getImagem();
	private static final ImageIcon JAVA_ICONE = new Java().getImagem();

	public PainelDoPlano(Memoria memoria) {

		this.memoria = memoria;

		setBorder(new LineBorder(Color.gray, 10));
		setLayout(new GridLayout(TAMANHO_DO_GRID, TAMANHO_DO_GRID));

		coordenadas = new Coordenada[TAMANHO_DO_GRID][TAMANHO_DO_GRID];

		criarCoordenadas();
		adicionarImagensDosPlanetas();
	}

	private void criarCoordenadas() {

		for (int i = TAMANHO_DO_GRID - 1; i >= 0; i--) {
			for (int j = 0; j < TAMANHO_DO_GRID; j++) {
				coordenadas[i][j] = new Coordenada((i + 1), (j + 1));

				if ((i + 1) == 8 && (j + 1) == 8) {
					coordenadas[i][j].add(new JLabel(JAVA_ICONE));
				}

				add(coordenadas[i][j]);
			}

		}

	}

	public void adicionarImagensDosBugs(int quantidadeDeBugs) {
		
		for (int i = 0; i < quantidadeDeBugs; i++) {
			int x, y;

			do {
				x = random.nextInt(15);
				y = random.nextInt(15);

			} while (verificacao.verificarCoordenadaOcupada(x, y));

			addBugs(x, y);

		}

	}

	private void addBugs(int x, int y) {

		coordenadas[x][y].setImagemBug(new JLabel(BUG_ICONE));

		coordenadas[x][y].setEixoX(x);
		coordenadas[x][y].setEixoY(y);

		coordenadasOcupadasPorBugs.add(coordenadas[x][y]);

		coordenadas[x][y].revalidate();
		coordenadas[x][y].repaint();

	}

	public void adicionarImagemDosDevs(int quantidadeDeDevs) {

		for (int i = 0; i < quantidadeDeDevs; i++) {
			int x, y;

			do {
				x = random.nextInt(15);
				y = random.nextInt(15);

			} while (verificacao.verificarCoordenadaOcupada(x, y));

			addDevs(x, y);

		}

	}

	public void addDevs(int x, int y) {

		coordenadas[x][y].setImagemDev(new JLabel(DEV_ICONE));

		coordenadas[x][y].setEixoX(x);
		coordenadas[x][y].setEixoY(y);

		coordenadasOcupadasPorDesenvolvedores.add(coordenadas[x][y]);

		coordenadas[x][y].revalidate();
		coordenadas[x][y].repaint();

	}

	public void adicionarImagensDosPlanetas() {

		for (int i = 0; i < TAMANHO_DO_GRID; i++) {
			for (int j = 0; j < TAMANHO_DO_GRID; j++) {
				for (Planetas planetas : memoria.getPlanetas()) {

					if (planetas.isVivoOuMorto() == true) {

						if (planetas.getPosicaoX() == (j + 1 ) && planetas.getPosicaoY() == (i + 1)) {

							coordenadas[i][j].setImagem(planetas.getImagem());
							
							coordenadas[i][j].setEixoX(i);
							coordenadas[i][j].setEixoY(j);
							
							coordenadasOcupadasPorPlanetas.add(coordenadas[i][j]);

							revalidate();
							repaint();

							verificacao.verificarColisaoComEntidadaes(planetas);

							if (planetas.getVelocidade() == 0) {
								
								JOptionPane.showMessageDialog(null, "O planeta " + planetas.getNome() + " explodiu", "Um planeta explodiu :'(", JOptionPane.INFORMATION_MESSAGE);
								
								planetas.setVivoOuMorto(false);
								coordenadas[i][j].remove(planetas.getImagem());
								coordenadasOcupadasPorPlanetas.remove(coordenadas[i][j]);
								

							}

						}

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
