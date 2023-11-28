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

	private List<DadosDeCadaAluno> lista = new ArrayList<>();

	private int[] quemTemMaisMortes = new int[7];
	private int[] quemTemMaisVida = new int[7];
	private int[] qualQuadranteBugs = new int[4];
	private int[] qualQuadranteDevs = new int[4];

	private int instantesAnalisadosPelaTurma = 0;

	private int[] somatorioDaVelocidadesDeCadaPlaneta = new int[7];

	private int somatorioBugs = 0;

	private int somatorioDevs = 0;

	public List<DadosDeCadaAluno> getLista() {
		return lista;
	}

	public int[] getQuemTemMaisMortes() {
		return quemTemMaisMortes;
	}

	public int[] getQuemTemMaisVidas() {

		return quemTemMaisVida;

	}

	public int[] getQualQuadranteBugs() {

		return qualQuadranteBugs;
	}

	public int[] getQualQuadranteDevs() {

		return qualQuadranteDevs;
	}

	public int getInstantes() {

		return instantesAnalisadosPelaTurma;
	}

	public int[] getSomatorioVelocidades() {

		return somatorioDaVelocidadesDeCadaPlaneta;
	}

	public int getSomatorioBugs() {
		return somatorioBugs;
	}

	public int getSomatorioDevs() {
		return somatorioDevs;
	}

	public void obterDadosDoBanco() {

		int[] verificacaoDeMortes = { 0, 0, 0, 0, 0, 0, 0 };
		int[] verificacaoDeVidas = { 0, 0, 0, 0, 0, 0, 0 };
		int[] auxiliarBugs = { 0, 0, 0, 0 };
		int[] auxiliarDevs = { 0, 0, 0, 0 };

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

						qualQuadranteTemMaisBugs(auxiliarBugs, resultSet);

						qualQuadranteTemMaisDevs(auxiliarDevs, resultSet);

						instantesAnalisadosPelaTurma++;

						somatorioVelocidades(resultSet);

						for (int i = 0; i < 4; i++) {

							somatorioBugs += auxiliarBugs[i];

						}

						for (int i = 0; i < 4; i++) {

							somatorioDevs += auxiliarDevs[i];

						}

						lista.add(dadosAluno);

					}

				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void somatorioVelocidades(ResultSet resultSet) throws SQLException {
		somatorioDaVelocidadesDeCadaPlaneta[0] = resultSet.getInt("v_python") + somatorioDaVelocidadesDeCadaPlaneta[0];
		somatorioDaVelocidadesDeCadaPlaneta[1] = resultSet.getInt("v_javascript")
				+ somatorioDaVelocidadesDeCadaPlaneta[1];
		somatorioDaVelocidadesDeCadaPlaneta[2] = resultSet.getInt("v_ruby") + somatorioDaVelocidadesDeCadaPlaneta[2];
		somatorioDaVelocidadesDeCadaPlaneta[3] = resultSet.getInt("v_php") + somatorioDaVelocidadesDeCadaPlaneta[3];
		somatorioDaVelocidadesDeCadaPlaneta[4] = resultSet.getInt("v_csharp") + somatorioDaVelocidadesDeCadaPlaneta[4];
		somatorioDaVelocidadesDeCadaPlaneta[5] = resultSet.getInt("v_cmais") + somatorioDaVelocidadesDeCadaPlaneta[5];
		somatorioDaVelocidadesDeCadaPlaneta[6] = resultSet.getInt("v_c") + somatorioDaVelocidadesDeCadaPlaneta[6];
	}

	private void qualQuadranteTemMaisDevs(int[] auxiliarDevs, ResultSet resultSet) throws SQLException {
		auxiliarDevs[0] = resultSet.getInt("dev_q1");
		auxiliarDevs[1] = resultSet.getInt("dev_q2");
		auxiliarDevs[2] = resultSet.getInt("dev_q3");
		auxiliarDevs[3] = resultSet.getInt("dev_q4");

		int maior = 0;

		for (int i = 0; i < 4; i++) {

			if (auxiliarDevs[i] > auxiliarDevs[maior]) {

				maior = i;

			}

		}

		for (int i = 0; i < 4; i++) {

			if (maior == i) {

				qualQuadranteDevs[i]++;

			}

		}
	}

	private void qualQuadranteTemMaisBugs(int[] auxiliarBugs, ResultSet resultSet) throws SQLException {
		auxiliarBugs[0] = resultSet.getInt("bug_q1");
		auxiliarBugs[1] = resultSet.getInt("bug_q2");
		auxiliarBugs[2] = resultSet.getInt("bug_q3");
		auxiliarBugs[3] = resultSet.getInt("bug_q4");

		int maior = 0;

		for (int i = 0; i < 4; i++) {

			if (auxiliarBugs[i] > auxiliarBugs[maior]) {

				maior = i;

			}

		}

		for (int i = 0; i < 4; i++) {

			if (maior == i) {

				qualQuadranteBugs[i]++;

			}

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
