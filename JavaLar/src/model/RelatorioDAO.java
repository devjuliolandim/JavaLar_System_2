package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.RelatorioGUI;

public class RelatorioDAO {

	private static final String URL = "jdbc:mysql://da_java.mysql.dbaas.com.br:3306/da_java";
	private static final String USUARIO = "da_java";
	private static final String SENHA = "Tecnicas*2023@";

	public void salvarRelatorio(RelatorioGUI relatorio) {

		try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {

			String query = "INSERT INTO javalar (nome, matricula, nome_arquivo) VALUES (?,?,?)";

			try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {

				preparedStatement.setString(1, relatorio.getNome());
				preparedStatement.setString(2, relatorio.getMatricula());
				preparedStatement.setString(3, relatorio.getNomeArquivo());

				preparedStatement.executeUpdate();

			}

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Não foi possível fazer a conexão");

		}

	}

}
