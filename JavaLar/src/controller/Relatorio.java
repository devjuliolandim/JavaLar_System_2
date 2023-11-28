package controller;

import java.util.ArrayList;

import model.RelatorioDAO;
import view.Coordenada;

public class Relatorio {

	private String nome = "Júlio César";
	private String matricula = "552419";
	private String nomeArquivo = "";

	private RelatorioDAO relatorioDAO = new RelatorioDAO();

	private Memoria memoria;

	private int bug_q1 = 0;
	private int bug_q2 = 0;
	private int bug_q3 = 0;
	private int bug_q4 = 0;

	private int dev_q1 = 0;
	private int dev_q2 = 0;
	private int dev_q3 = 0;
	private int dev_q4 = 0;

	public Relatorio(Memoria memoria) {

		this.memoria = memoria;

	}

	public void relatorioQuadrantesBugs(ArrayList<Coordenada> bugsCoord) {

		for (Coordenada coord : bugsCoord) {

			if (coord.getEixoX() >= 9 && coord.getEixoY() >= 9) {
				bug_q1++;

			} else if (coord.getEixoX() <= 9 && coord.getEixoY() >= 7) {
				bug_q2++;

			} else if (coord.getEixoX() <= 7 && coord.getEixoY() <= 7) {
				bug_q3++;

			} else if (coord.getEixoX() >= 7 && coord.getEixoY() <= 9) {
				bug_q4++;

			}

		}

	}

	public void relatorioQuadrantesDevs(ArrayList<Coordenada> devsCoord) {

		for (Coordenada coord : devsCoord) {

			if (coord.getEixoX() >= 9 && coord.getEixoY() >= 9) {
				dev_q1++;

			} else if (coord.getEixoX() <= 9 && coord.getEixoY() >= 7) {
				dev_q2++;

			} else if (coord.getEixoX() <= 7 && coord.getEixoY() <= 7) {
				dev_q3++;

			} else if (coord.getEixoX() >= 7 && coord.getEixoY() <= 9) {
				dev_q4++;

			}

		}

	}


	public void enviarRelatorioParaOBanco() {

		relatorioDAO.salvarRelatorio(this, memoria);

	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nome) {
		this.nomeArquivo = nome;
	}

	public int getBug_q1() {
		return bug_q1;
	}

	public int getBug_q2() {
		return bug_q2;
	}

	public int getBug_q3() {
		return bug_q3;
	}

	public int getBug_q4() {
		return bug_q4;
	}

	public int getDev_q1() {
		return dev_q1;
	}

	public int getDev_q2() {
		return dev_q2;
	}

	public int getDev_q3() {
		return dev_q3;
	}

	public int getDev_q4() {
		return dev_q4;
	}

}
