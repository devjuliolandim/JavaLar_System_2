package controller;

public class DadosDeCadaAluno {

	private String nome;
	private String matricula;

	public DadosDeCadaAluno(String nome, String matricula) {

		this.nome = nome;
		this.matricula = matricula;

	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

}
