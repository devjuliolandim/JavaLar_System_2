package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.Memoria;
import controller.Relatorio;

public class RelatorioDAO {

	private static final String URL = "jdbc:mysql://da_java.mysql.dbaas.com.br:3306/da_java";
	private static final String USUARIO = "da_java";
	private static final String SENHA = "Tecnicas*2023@";

	public void salvarRelatorio(Relatorio relatorio, Memoria memoria) {

		try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {

			String query = "INSERT INTO javalar (nome, matricula, nome_arquivo,bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, bug_cmais, bug_c,dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp,dev_cmais, dev_c ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {

				preparedStatement.setString(1, relatorio.getNome());
				preparedStatement.setString(2, relatorio.getMatricula());
				preparedStatement.setString(3, relatorio.getNomeArquivo());
				preparedStatement.setInt(4, memoria.getPlanetas().get(0).getBugsCont());
				preparedStatement.setInt(5, memoria.getPlanetas().get(1).getBugsCont());
				preparedStatement.setInt(6, memoria.getPlanetas().get(2).getBugsCont());
				preparedStatement.setInt(7, memoria.getPlanetas().get(3).getBugsCont());
				preparedStatement.setInt(8, memoria.getPlanetas().get(4).getBugsCont());
				preparedStatement.setInt(9, memoria.getPlanetas().get(5).getBugsCont());
				preparedStatement.setInt(10,memoria.getPlanetas().get(6).getBugsCont());
				preparedStatement.setInt(11,memoria.getPlanetas().get(0).getDevsCont());
				preparedStatement.setInt(12,memoria.getPlanetas().get(1).getDevsCont());
				preparedStatement.setInt(13,memoria.getPlanetas().get(2).getDevsCont());
				preparedStatement.setInt(14,memoria.getPlanetas().get(3).getDevsCont());
				preparedStatement.setInt(15,memoria.getPlanetas().get(4).getDevsCont());
				preparedStatement.setInt(16,memoria.getPlanetas().get(5).getDevsCont());
				preparedStatement.setInt(17,memoria.getPlanetas().get(6).getDevsCont());

				preparedStatement.executeUpdate();

			}

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Não foi possível fazer a conexão");

		}

	}

}
