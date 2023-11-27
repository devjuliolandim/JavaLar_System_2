package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.DadosDeCadaAluno;

public class ObterDadosDoBanco {

	private int[] quemTemMaisMortes = { 0, 0, 0, 0, 0, 0, 0 };
	private int[] quemTemMaisVida = { 0, 0, 0, 0, 0, 0, 0 };

	public int[] getQuemTemMaisMortes() {
		return quemTemMaisMortes;
	}
	
	public int[] getQuemTemMaisVidas() {
		
		return quemTemMaisVida;
	}

	public void obterDadosDoBanco() {

		List<DadosDeCadaAluno> lista = new ArrayList<>();

		int[] verificacaoDeMortes = { 0, 0, 0, 0, 0, 0, 0 };
		int[] verificacaoDeVidas = { 0, 0, 0, 0, 0, 0, 0 };

		try (Connection conexao = DriverManager.getConnection(Conexao.getUrl(), Conexao.getUsuario(),
				Conexao.getSenha())) {

			String query = "SELECT * FROM javalar";

			try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					while (resultSet.next()) {

						DadosDeCadaAluno dadosAluno = new DadosDeCadaAluno(resultSet.getString("nome"),
								resultSet.getString("matricula"));

						quemTemMaisMortes(verificacaoDeMortes, resultSet);

						quemTemMaisVida(verificacaoDeVidas, resultSet);

						lista.add(dadosAluno);

					}

				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void quemTemMaisVida(int[] verificacaoDeVidas, ResultSet resultSet) throws SQLException {
		verificacaoDeVidas[0] = resultSet.getInt("v_python");
		verificacaoDeVidas[1] = resultSet.getInt("v_javascript");
		verificacaoDeVidas[2] = resultSet.getInt("v_ruby");
		verificacaoDeVidas[3] = resultSet.getInt("v_php");
		verificacaoDeVidas[4] = resultSet.getInt("v_csharp");
		verificacaoDeVidas[5] = resultSet.getInt("v_cmais");
		verificacaoDeVidas[6] = resultSet.getInt("v_c");

		int maior = 0;

		for (int i = 0; i < 7; i++) {

			if (verificacaoDeVidas[i] > verificacaoDeVidas[maior]) {

				maior = i;

			}

		}

		for (int i = 0; i < 7; i++) {

			if (maior == i) {

				quemTemMaisVida[i]++;
			}

		}
	}

	private void quemTemMaisMortes(int[] verificacaoDeMortes, ResultSet resultSet) throws SQLException {
		verificacaoDeMortes[0] = resultSet.getInt("v_python");
		verificacaoDeMortes[1] = resultSet.getInt("v_javascript");
		verificacaoDeMortes[2] = resultSet.getInt("v_ruby");
		verificacaoDeMortes[3] = resultSet.getInt("v_php");
		verificacaoDeMortes[4] = resultSet.getInt("v_csharp");
		verificacaoDeMortes[5] = resultSet.getInt("v_cmais");
		verificacaoDeMortes[6] = resultSet.getInt("v_c");

		for (int i = 0; i < 7; i++) {

			if (verificacaoDeMortes[i] == 0) {
				quemTemMaisMortes[i]++;
			}

		}
	}

}
