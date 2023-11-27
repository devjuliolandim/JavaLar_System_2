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

			String query = "INSERT INTO javalar (nome, matricula, nome_arquivo,bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, bug_cmais, bug_c,dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp,dev_cmais, dev_c,v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c,d_python, d_javascript, d_ruby, d_php, d_csharp,d_cmais,d_c, a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c,bug_q1, bug_q2, bug_q3, bug_q4,dev_q1,dev_q2,dev_q3,dev_q4) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
				preparedStatement.setInt(10, memoria.getPlanetas().get(6).getBugsCont());

				preparedStatement.setInt(11, memoria.getPlanetas().get(0).getDevsCont());
				preparedStatement.setInt(12, memoria.getPlanetas().get(1).getDevsCont());
				preparedStatement.setInt(13, memoria.getPlanetas().get(2).getDevsCont());
				preparedStatement.setInt(14, memoria.getPlanetas().get(3).getDevsCont());
				preparedStatement.setInt(15, memoria.getPlanetas().get(4).getDevsCont());
				preparedStatement.setInt(16, memoria.getPlanetas().get(5).getDevsCont());
				preparedStatement.setInt(17, memoria.getPlanetas().get(6).getDevsCont());

				preparedStatement.setInt(18, memoria.getPlanetas().get(0).getVelocidade());
				preparedStatement.setInt(19, memoria.getPlanetas().get(1).getVelocidade());
				preparedStatement.setInt(20, memoria.getPlanetas().get(2).getVelocidade());
				preparedStatement.setInt(21, memoria.getPlanetas().get(3).getVelocidade());
				preparedStatement.setInt(22, memoria.getPlanetas().get(4).getVelocidade());
				preparedStatement.setInt(23, memoria.getPlanetas().get(5).getVelocidade());
				preparedStatement.setInt(24, memoria.getPlanetas().get(6).getVelocidade());

				preparedStatement.setInt(25, (int) memoria.getPlanetas().get(0).getHoras());
				preparedStatement.setInt(26, (int) memoria.getPlanetas().get(1).getHoras());
				preparedStatement.setInt(27, (int) memoria.getPlanetas().get(2).getHoras());
				preparedStatement.setInt(28, (int) memoria.getPlanetas().get(3).getHoras());
				preparedStatement.setInt(29, (int) memoria.getPlanetas().get(4).getHoras());
				preparedStatement.setInt(30, (int) memoria.getPlanetas().get(5).getHoras());
				preparedStatement.setInt(31, (int) memoria.getPlanetas().get(6).getHoras());

				preparedStatement.setInt(32, memoria.getPlanetas().get(0).getAnos());
				preparedStatement.setInt(33, memoria.getPlanetas().get(1).getAnos());
				preparedStatement.setInt(34, memoria.getPlanetas().get(2).getAnos());
				preparedStatement.setInt(35, memoria.getPlanetas().get(3).getAnos());
				preparedStatement.setInt(36, memoria.getPlanetas().get(4).getAnos());
				preparedStatement.setInt(37, memoria.getPlanetas().get(5).getAnos());
				preparedStatement.setInt(38, memoria.getPlanetas().get(6).getAnos());

				preparedStatement.setInt(39, relatorio.getBug_q1());
				preparedStatement.setInt(40, relatorio.getBug_q1());
				preparedStatement.setInt(41, relatorio.getBug_q1());
				preparedStatement.setInt(42, relatorio.getBug_q1());

				preparedStatement.setInt(43, relatorio.getDev_q1());
				preparedStatement.setInt(44, relatorio.getDev_q2());
				preparedStatement.setInt(45, relatorio.getDev_q3());
				preparedStatement.setInt(46, relatorio.getDev_q4());

				preparedStatement.executeUpdate();

			}

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Não foi possível fazer a conexão");

		}

	}

}
