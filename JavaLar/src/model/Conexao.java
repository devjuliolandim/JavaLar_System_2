package model;

public class Conexao {

	private static final String URL = "jdbc:mysql://da_java.mysql.dbaas.com.br:3306/da_java";
	private static final String USUARIO = "da_java";
	private static final String SENHA = "Tecnicas*2023@";

	public static String getUrl() {
		return URL;
	}

	public static String getUsuario() {
		return USUARIO;
	}

	public static String getSenha() {
		return SENHA;
	}

}
