package controller;

import java.util.ArrayList;

import model.AlunoDAO;

public class Aluno {

	//POJO
	private int id;
	private String nome;
	private int matricula;
	private AlunoDAO alunoDAO;
	
	public Aluno(int id, String nome, int matricula) {
		alunoDAO = new AlunoDAO();
		this.id= id;
		this.nome = nome;
		this.matricula = matricula;
	}
	public Aluno() {
		alunoDAO = new AlunoDAO();
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getMatricula() {
		return matricula;
	}
	

	public ArrayList<Aluno> buscarTodosAlunos(){
		ArrayList<Aluno> listaAlunos= alunoDAO.selecionarTodosAlunos();
		return listaAlunos;
	}
	public ArrayList<Aluno> buscarAlunosPorNome(String nome){
		ArrayList<Aluno> listaAlunos= alunoDAO.selecionarAlunoPorNome(nome);
		return listaAlunos;
	}
	public void update(Aluno a){
		alunoDAO.update(a);
	}
}
