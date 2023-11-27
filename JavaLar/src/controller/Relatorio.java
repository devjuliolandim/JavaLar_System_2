package controller;

import model.RelatorioDAO;

public class Relatorio {

	private String nome = "Júlio César";
	private String matricula = "552419";
	private String nomeArquivo = "";

	private RelatorioDAO relatorioDAO = new RelatorioDAO();

	private Memoria memoria;

	public Relatorio(Memoria memoria) {
		this.memoria = memoria;

	}

	public void lerDoBancoDeDados() {

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

}
