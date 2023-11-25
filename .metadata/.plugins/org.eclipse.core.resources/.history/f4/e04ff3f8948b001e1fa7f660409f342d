package controller;

import view.Coordenada;
import view.PainelDoPlano;

public class Verificacao {
	
	PainelDoPlano painel;
	
	public Verificacao(PainelDoPlano painel) {
		
		this.painel=painel;
		
		
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
