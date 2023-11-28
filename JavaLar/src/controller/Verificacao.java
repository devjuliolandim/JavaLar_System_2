package controller;

import java.util.ArrayList;

import javax.swing.JLabel;

import view.Coordenada;
import view.PainelDoPlano;

public class Verificacao {

	PainelDoPlano painel;

	public Verificacao(PainelDoPlano painel) {

		this.painel = painel;
	}

	public void verificarColisaoComEntidadaes(Planetas planeta) {

		ArrayList<Coordenada> bugsASeremRemovidos = new ArrayList<>();
		ArrayList<Coordenada> devsASeremRemovidos = new ArrayList<>();

		for (Coordenada coordenada : painel.getCoordenadasOcupadasPorBugs()) {

			if ((coordenada.getEixoX() + 1) == planeta.getPosicaoY()
					&& (coordenada.getEixoY() + 1) == planeta.getPosicaoX()) {

				System.out.println("O planeta " + planeta.getNome() + " bateu em um bug na posição ("
						+ (coordenada.getEixoX() + 1) + ", " + (coordenada.getEixoY() + 1) + ")");

				planeta.setVelocidade(planeta.getVelocidade() - 1);
				planeta.setBugsCont(planeta.getBugsCont() + 1);

				bugsASeremRemovidos.add(coordenada);

				coordenada.remove(coordenada.getImagemBug());
			}

		}

		if (bugsASeremRemovidos.size() >= 1) {

			painel.getCoordenadasOcupadasPorBugs().removeAll(bugsASeremRemovidos);
		}

		for (Coordenada coordenada : painel.getCoordenadasOcupadasPorDesenvolvedores()) {

			if ((coordenada.getEixoX() + 1) == planeta.getPosicaoY()
					&& (coordenada.getEixoY() + 1) == planeta.getPosicaoX()) {

				System.out.println("O planeta " + planeta.getNome() + " bateu em um dev na posição ("
						+ (coordenada.getEixoX() + 1) + ", " + (coordenada.getEixoY() + 1) + ")");

				planeta.setVelocidade(planeta.getVelocidade() + 1);

				planeta.setDevsCont(planeta.getDevsCont() + 1);

				devsASeremRemovidos.add(coordenada);

				coordenada.remove(coordenada.getImagemDev());

			}

		}

		if (devsASeremRemovidos.size() >= 1) {

			painel.getCoordenadasOcupadasPorDesenvolvedores().removeAll(devsASeremRemovidos);

		}

	}

	public boolean verificarCoordenadaOcupada(int x, int y) {

		if (coordenadasOcupadasPorPlanetas(x, y) || coordenadasOcupadasPorDesenvolvedores(x, y)
				|| coordenadasOcupadasPorBugs(x, y)) {
			return true;
		}

		return false;
	}

	private boolean coordenadasOcupadasPorPlanetas(int x, int y) {
		for (Coordenada coordenada : painel.getCoordenadasOcupadasPorPlanetas()) {
			if (coordenada != null && coordenada.getEixoX() == x && coordenada.getEixoY() == y) {
				return true;
			}
		}

		return false;
	}

	private boolean coordenadasOcupadasPorDesenvolvedores(int x, int y) {
		for (Coordenada coordenada : painel.getCoordenadasOcupadasPorDesenvolvedores()) {
			if (coordenada != null && coordenada.getEixoX() == x && coordenada.getEixoY() == y) {
				return true;
			}
		}

		return false;
	}

	private boolean coordenadasOcupadasPorBugs(int x, int y) {
		for (Coordenada coordenada : painel.getCoordenadasOcupadasPorBugs()) {
			if (coordenada != null && coordenada.getEixoX() == x && coordenada.getEixoY() == y) {
				return true;
			}
		}

		return false;
	}

}
