package model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Aluno;

public class AlunoDAO {

	public ArrayList<Aluno> selecionarTodosAlunos() {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();

		try {
			Connection conexao = new Conexao().getConexao();

			String query = "select * from aluno order by matricula asc";
			ResultSet dados = conexao.prepareStatement(query).executeQuery();

			while (dados.next()) {
				String nome = dados.getString("nome");
				int id = dados.getInt("id_aluno");
				int matricula = dados.getInt("matricula");

				Aluno a = new Aluno(id, nome, matricula);
				alunos.add(a);

			}
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return alunos;
	}

	public ArrayList<Aluno> selecionarAlunoPorNome(String nome) {

		ArrayList<Aluno> alunos = new ArrayList<Aluno>();

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement resultado = conexao.prepareStatement("select * from aluno where nome =?");

			resultado.setString(1, nome);

			ResultSet resposta = resultado.executeQuery();

			while (resposta.next()) {
				String nome_ = resposta.getString("nome");
				int id = resposta.getInt("id_aluno");
				int matricula = resposta.getInt("matricula");

				Aluno a = new Aluno(id, nome_, matricula);
				alunos.add(a);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return alunos;

	}

	public void update(Aluno a) {

		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement up = conexao.prepareStatement("update aluno set nome=?, matricula=? where id_aluno=?");
			up.setString(1, a.getNome());
			up.setInt(2, a.getMatricula());
			up.setInt(3, a.getId());

			up.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inserir(Aluno a) {
		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement inserir = conexao.prepareStatement("insert into aluno (nome, matricula) values (?, ?)");
			inserir.setString(1, a.getNome());
			inserir.setInt(2, a.getMatricula());
			inserir.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletar(int id) {

		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement resultado = conexao.prepareStatement("delete from aluno where id_aluno=?");
			resultado.setInt(1, id);
			resultado.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
