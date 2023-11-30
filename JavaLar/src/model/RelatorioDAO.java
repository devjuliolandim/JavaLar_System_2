package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.Memoria;
import controller.Relatorio;

public class RelatorioDAO {

	public void salvarRelatorio(Relatorio relatorio, Memoria memoria) {

		try (Connection conexao = DriverManager.getConnection(Conexao.getUrl(), Conexao.getUsuario(),
				Conexao.getSenha())) {

			String query = "INSERT INTO javalar (nome, matricula, nome_arquivo,bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, bug_cmais, bug_c,dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp,dev_cmais, dev_c,v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c,d_python, d_javascript, d_ruby, d_php, d_csharp,d_cmais,d_c, a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c,bug_q1, bug_q2, bug_q3, bug_q4,dev_q1,dev_q2,dev_q3,dev_q4) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {

				preparedStatement.setString(1, relatorio.getNome());
				preparedStatement.setString(2, relatorio.getMatricula());
				preparedStatement.setString(3, relatorio.getNomeArquivo());

				enviarChoquesComBugs(memoria, preparedStatement);

				enviarChoqueComDevs(memoria, preparedStatement);

				enviarVelocidadeDosPlanetas(memoria, preparedStatement);

				enviarHorasDosPlanetas(memoria, preparedStatement);

				enviarAnos(memoria, preparedStatement);

				enviarQuadrantesBugs(relatorio, preparedStatement);

				enviarQuadrantesDevs(relatorio, preparedStatement);

				preparedStatement.executeUpdate();

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	private void enviarChoquesComBugs(Memoria memoria, PreparedStatement preparedStatement) throws SQLException {

		for (int i = 4; i <= 10; i++) {

			preparedStatement.setInt(i, memoria.getPlanetas().get(i - 4).getBugsCont());

		}

	}

	private void enviarChoqueComDevs(Memoria memoria, PreparedStatement preparedStatement) throws SQLException {

		for (int i = 11; i <= 17; i++) {

			preparedStatement.setInt(i, memoria.getPlanetas().get(i - 11).getDevsCont());

		}

	}

	private void enviarVelocidadeDosPlanetas(Memoria memoria, PreparedStatement preparedStatement) throws SQLException {

		for (int i = 18; i <= 24; i++) {

			preparedStatement.setInt(i, memoria.getPlanetas().get(i - 18).getVelocidade());

		}

	}

	private void enviarHorasDosPlanetas(Memoria memoria, PreparedStatement preparedStatement) throws SQLException {

		for (int i = 25; i <= 31; i++) {
			preparedStatement.setInt(i, (int) memoria.getPlanetas().get(i - 25).getHoras());
		}

	}

	private void enviarAnos(Memoria memoria, PreparedStatement preparedStatement) throws SQLException {

		for (int i = 32; i <= 38; i++) {
			preparedStatement.setInt(i, memoria.getPlanetas().get(i - 32).getAnos());
		}

	}

	private void enviarQuadrantesBugs(Relatorio relatorio, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setInt(39, relatorio.getBug_q1());
		preparedStatement.setInt(40, relatorio.getBug_q1());
		preparedStatement.setInt(41, relatorio.getBug_q1());
		preparedStatement.setInt(42, relatorio.getBug_q1());
	}

	private void enviarQuadrantesDevs(Relatorio relatorio, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setInt(43, relatorio.getDev_q1());
		preparedStatement.setInt(44, relatorio.getDev_q2());
		preparedStatement.setInt(45, relatorio.getDev_q3());
		preparedStatement.setInt(46, relatorio.getDev_q4());
	}

}
