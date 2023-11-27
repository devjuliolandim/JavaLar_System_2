package controller;

import model.RelatorioDAO;

public class RelatorioGUI {

	private String nome = "Júlio César";
	private String matricula = "552419";
	private String nomeArquivo = "";

	private RelatorioDAO relatorioDAO = new RelatorioDAO();

	public void enviarRelatorioParaOBanco() {

		relatorioDAO.salvarRelatorio(this);

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
