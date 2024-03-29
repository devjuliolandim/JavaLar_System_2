package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.DadosDeCadaAluno;

public class LerDadosDeOutrosParticipantes {

	private List<DadosDeCadaAluno> lista = new ArrayList<>();

	private int[] quemTemMaisMortes = new int[7];
	private int[] quemTemMaisVida = new int[7];
	private int[] qualQuadranteBugs = new int[4];
	private int[] qualQuadranteDevs = new int[4];

	private int instantesAnalisadosPelaTurma = 0;

	private int[] somatorioDaVelocidadesDeCadaPlaneta = new int[7];

	private int somatorioBugs = 0;

	private int somatorioDevs = 0;

	private int somatorioHoras = 0;

	private int somatorioAnos = 0;

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

	public int getSomatorioHoras() {

		return somatorioHoras;
	}

	public int getSomatorioAnos() {

		return somatorioAnos;
	}

	public void obterDadosDoBanco() {

		int[] auxiliarMortes = { 0, 0, 0, 0, 0, 0, 0 };
		int[] auxiliarQuemMaisViveu = { 0, 0, 0, 0, 0, 0, 0 };
		int[] auxiliarBugs = { 0, 0, 0, 0 };
		int[] auxiliarDevs = { 0, 0, 0, 0 };
		int[] auxiliarHoras = new int[7];
		int[] auxiliarAnos = new int[7];

		try (Connection conexao = DriverManager.getConnection(Conexao.getUrl(), Conexao.getUsuario(),
				Conexao.getSenha())) {

			String query = "SELECT * FROM javalar";

			try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					while (resultSet.next()) {

						DadosDeCadaAluno dadosAluno = new DadosDeCadaAluno(resultSet.getString("nome"),
								resultSet.getString("matricula"));

						quemTemMaisMortes(auxiliarMortes, resultSet);

						quemTemMaisVida(auxiliarQuemMaisViveu, resultSet);

						qualQuadranteTemMaisBugs(auxiliarBugs, resultSet);

						qualQuadranteTemMaisDevs(auxiliarDevs, resultSet);

						instantesAnalisadosPelaTurma++;

						somatorioVelocidades(resultSet);

						somatorioBugs(auxiliarBugs);

						somatorioDevs(auxiliarDevs);

						somatorioHoras(auxiliarHoras, resultSet);

						somatorioAnos(auxiliarAnos, resultSet);

						lista.add(dadosAluno);

					}
					
					//JOptionPane.showMessageDialog(null, "Todos os dados dos participantes foram lidos com sucesso!", "Todos os dados foram lidos!", JOptionPane.INFORMATION_MESSAGE);

				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void somatorioAnos(int[] auxiliarAnos, ResultSet resultSet) throws SQLException {

		String[] anos = { "a_python", "a_javascript", "a_ruby", "a_php", "a_csharp", "a_cmais", "a_c" };

		for (int i = 0; i < 7; i++) {
			auxiliarAnos[i] = resultSet.getInt(anos[i]);
			somatorioAnos += auxiliarAnos[i];

		}

	}

	private void somatorioHoras(int[] auxiliarHoras, ResultSet resultSet) throws SQLException {

		String[] horas = { "d_python", "d_javascript", "d_ruby", "d_php", "d_csharp", "d_cmais", "d_c" };

		for (int i = 0; i < 7; i++) {

			auxiliarHoras[i] = resultSet.getInt(horas[i]);
			somatorioHoras += auxiliarHoras[i];

		}

	}

	private void somatorioDevs(int[] auxiliarDevs) {
		for (int i = 0; i < 4; i++) {

			somatorioDevs += auxiliarDevs[i];

		}
	}

	private void somatorioBugs(int[] auxiliarBugs) {
		for (int i = 0; i < 4; i++) {

			somatorioBugs += auxiliarBugs[i];

		}
	}

	private void somatorioVelocidades(ResultSet resultSet) throws SQLException {

		String[] velocidades = { "v_python", "v_javascript", "v_ruby", "v_php", "v_csharp", "v_cmais", "v_c" };

		for (int i = 0; i < 7; i++) {
			somatorioDaVelocidadesDeCadaPlaneta[i] += resultSet.getInt(velocidades[i]);

		}

	}

	private void qualQuadranteTemMaisDevs(int[] auxiliarDevs, ResultSet resultSet) throws SQLException {

		String[] devs = { "dev_q1", "dev_q2", "dev_q3", "dev_q4" };

		int maior = 0;

		for (int i = 0; i < 4; i++) {

			auxiliarDevs[i] = resultSet.getInt(devs[i]);
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

		String[] bugs = { "bug_q1", "bug_q2", "bug_q3", "bug_q4" };

		int maior = 0;

		for (int i = 0; i < 4; i++) {

			auxiliarBugs[i] = resultSet.getInt(bugs[i]);

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

		String[] velocidades = { "v_python", "v_javascript", "v_ruby", "v_php", "v_csharp", "v_cmais", "v_c" };

		int maior = 0;

		for (int i = 0; i < 7; i++) {
			verificacaoDeVidas[i] = resultSet.getInt(velocidades[i]);
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

		String[] velocidades = { "v_python", "v_javascript", "v_ruby", "v_php", "v_csharp", "v_cmais", "v_c" };

		for (int i = 0; i < 7; i++) {

			verificacaoDeMortes[i] = resultSet.getInt(velocidades[i]);

			if (verificacaoDeMortes[i] == 0) {
				quemTemMaisMortes[i]++;
			}

		}

	}

}
