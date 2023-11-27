package view;

import java.util.ArrayList;

import controller.Aluno;

public class Main {
	public static void main(String[] args) {

//		Connection conexao = new Conexao().getConexao();

		
		Aluno aluno= new Aluno();
		ArrayList<Aluno> a= aluno.buscarAlunosPorNome("rafael");
		
		for (Aluno alunos : a) {
			System.out.println(alunos.getId() + " - "+  alunos.getMatricula() + " - "+alunos.getNome());
		}
		Aluno aluno2 = new Aluno(3, "pedro", 552);
		
		aluno.update(aluno2);

		ArrayList<Aluno> a2= aluno.buscarTodosAlunos();


		for (Aluno alunos : a2) {
			System.out.println(alunos.getId() + " - "+  alunos.getMatricula() + " - "+alunos.getNome());
		}
		
	}
}
